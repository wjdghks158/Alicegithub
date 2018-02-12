/**
 * 게시판을 위한 데이터베이스 스키마를 정의하는 모듈
 *
 * @date 2016-11-10
 * @author Mike
 */

//var utils = require('../utils/utils');

var SchemaObj = {};


SchemaObj.createSchema = function(mongoose) {
    
    
	// 글 스키마 정의
	var CounterSchema = mongoose.Schema({
        _id: {type: String, required: true},
        number: { type: Number, default: 0 }

	});
	

	
	console.log('count_shema 정의함.');

	return CounterSchema;
};

// module.exports에 PostSchema 객체 직접 할당
module.exports = SchemaObj;

