import * as bodyParser from 'body-parser';
import * as dotenv from 'dotenv';
import * as express from 'express';
import * as morgan from 'morgan';
import * as mongoose from 'mongoose';
import * as path from 'path';
import * as multer from 'multer';
import setRoutes from './routes';
const UPLOAD_DIR ='./uploads/';


const app = express();
dotenv.load({ path: '.env' });
app.set('port', (process.env.PORT || 3000));

app.use('/', express.static(path.join(__dirname, '../public')));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));

//multer 업로드 관련 uploads
app.use('/uploads', express.static(path.join(__dirname, '../../uploads')));
//app.use('/bbb', express.static('uploads'));
app.get('/download/:filename/', function(req,res,next){
  console.log(req.params.filen);
  res.setHeader('content-type', 'image/jpeg');
  res.download(UPLOAD_DIR+req.params.filename);
})

//Uploader cb
const storage1 = multer.diskStorage({
  destination: function (req, file, cb) {
    cb(null, UPLOAD_DIR)
  },
  filename: function (req, file, cb) {
      let extension = path.extname(file.originalname);
      let basename = path.basename(file.originalname, extension);
      cb(null, basename + extension);
  }
})

 const filter1 =function(req, file, cb){
  const extension = file.mimetype.split('/')[0];
  if(extension !== 'image'){
      return cb(new Error('Invalid file format'), false);
  }
  cb(null, true);
};
const upload = multer({
    storage: storage1,
    fileFilter: filter1,

    limit:{
        files:10,
        fileSize:1024*1024*1024
    }
});

app.post('/api/upload', upload.single('file'), function (req, res, next) {
  console.log('Uploaded file asd : ', req.file); 
  res.end('success');
  next();
})
//여기 까지가 파일 업로드

app.use(morgan('dev'));
mongoose.connect(process.env.MONGODB_URI);
const db = mongoose.connection;
(<any>mongoose).Promise = global.Promise;

db.on('error', console.error.bind(console, 'connection error:'));
db.once('open', () => {
  console.log('Connected to MongoDB');

  setRoutes(app);

  app.get('/*', function(req, res) {
    res.sendFile(path.join(__dirname, '../public/index.html'));
  });

  app.listen(app.get('port'), () => {
    console.log('Angular Full Stack listening on port ' + app.get('port'));
  });

});




export { app };
