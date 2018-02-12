/*
 * 사용자 조회를 담당하는 라우팅 함수 정의
 *
 * @date 2016-11-10
 * @author Mike *
 */
var autoIncrement = require('mongoose-auto-increment');
    
var listpost = function(req, res) {
	console.log('post 모듈 안에 있는 listpost 호출됨.');

	// 데이터베이스 객체 참조
	var database = req.app.get('database');
    
    // 데이터베이스 객체가 초기화된 경우, 모델 객체의 findAll 메소드 호출
	if (database.db) {
		// 1. 모든 사용자 검색
		database.PostModel.findAll(function(err, results) {
			// 에러 발생 시, 클라이언트로 에러 전송
			if (err) {
                console.error('사용자 리스트 조회 중 에러 발생 : ' + err.stack);
                
                res.writeHead('200', {'Content-Type':'text/html;charset=utf8'});
				res.write('<h2>사용자 리스트 조회 중 에러 발생</h2>');
                res.write('<p>' + err.stack + '</p>');
				res.end();
                
                return;
            }

			if (results) {
				console.log(results);
                console.log("성공");

				res.writeHead('200', {'Content-Type':'application/json;charset=utf8'});
				res.write(JSON.stringify(results));
				res.end();
				
			} else {
				res.writeHead('200', {'Content-Type':'text/html;charset=utf8'});
				res.write('<h2>사용자 리스트 조회  실패</h2>');
				res.end();
			}
		});
	} else {
		res.writeHead('200', {'Content-Type':'text/html;charset=utf8'});
		res.write('<h2>데이터베이스 연결 실패</h2>');
		res.end();
	}
	
};



// post 넘버링
function getNextSequenceValue(db, sequenceName) {
    // 데이터베이스 객체 참조
	//var database = req.app.get('database');
    console.log('여기까지는 오냐?');
    var sequenceDocument = db.PostModel.findAndModify({
        query : {_id : "sequenceName"},
        update : {$inc : {number : 1}},
        new : true
    });
    return sequenceDocument.number;
}

//사용자를 등록하는 함수
//function(database, title, deadline, tag, callback)
var addpost = function(req, res) {
	console.log('user(user.js) 모듈 안에 있는 addpost 호출됨.');

	var paramtitle = req.body.title || req.query.title;
    var paramtag = req.body.tag || req.query.tag;
    var paramdeadline = req.body.deadline || req.query.deadline;
	
    console.log('요청 파라미터 : ' + paramtitle + ', ' + paramtag + ', ' + paramdeadline);
    
    // 데이터베이스 객체 참조
	var database = req.app.get('database');
	
    // 데이터베이스 객체가 초기화된 경우, addpost 함수 호출하여 사용자 추가
	if (database.db) {
		addPost(database, paramtitle, paramtag, paramdeadline, function(err, addedPost) {
            // 동일한 id로 추가하려는 경우 에러 발생 - 클라이언트로 에러 전송
			if (err) {
                console.error('사용자 추가 중 에러 발생 : ' + err.stack);
                
                res.writeHead('200', {'Content-Type':'text/html;charset=utf8'});
				res.write('<h2>사용자 추가 중 에러 발생</h2>');
                res.write('<p>' + err.stack + '</p>');
				res.end();
                
                return;
            }
			
            // 결과 객체 있으면 성공 응답 전송
			if (addedPost) {
				console.dir(addedPost);
 
				res.writeHead('200', {'Content-Type':'text/html;charset=utf8'});
				
				// 뷰 템플레이트를 이용하여 렌더링한 후 전송
				var context = {title:'사용자 추가 성공'};
				req.app.render('addpost', context, function(err, html) {
					if (err) {throw err;}
					
					console.log("rendered : " + html);
					
					res.end(html);
				});
				
			} else {  // 결과 객체가 없으면 실패 응답 전송
				res.writeHead('200', {'Content-Type':'text/html;charset=utf8'});
				res.write('<h2>사용자 추가  실패</h2>');
				res.end();
			}
		});
	} else {  // 데이터베이스 객체가 초기화되지 않은 경우 실패 응답 전송
		res.writeHead('200', {'Content-Type':'text/html;charset=utf8'});
		res.write('<h2>데이터베이스 연결 실패</h2>');
		res.end();
	}
	
};

//게시물을 등록하는 함수
var addPost = function(database, title, tag, deadline, callback) {
	console.log('addPost 호출됨 : ' + title + ', ' + tag  + ', ' + deadline);
	
	// PostModel 인스턴스 생성
	var post = new database.PostModel({title:'전국 최강 박정환 대회', tag:'과학', deadline:'20180215'});
    //var post = new database.PostModel({email:email, password:password, name:name});
    
	// save()로 저장
	post.save(function(err) {
		if (err) {
			callback(err, null);
			return;
		}
		
	    console.log("사용자 데이터 추가함.");
	    callback(null, post);
	     
	});
}



module.exports.listpost = listpost;
module.exports.addpost = addpost;
//module.exports.listuser = listuser;

