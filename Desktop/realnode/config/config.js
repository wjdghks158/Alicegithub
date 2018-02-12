/*
 * 설정
 */

module.exports = {
	server_port: 3000,
	db_url: 'mongodb://wjdghks158:qkrwjd158@ds233208.mlab.com:33208/heroku_wws5tzzv',
	db_schemas: [
	    {file:'./user_schema', collection:'users6', schemaName:'UserSchema', modelName:'UserModel'}
        ,{file:'./device_schema', collection:'devices', schemaName:'DeviceSchema', modelName:'DeviceModel'}
        ,{file:'./post_schema', collection:'post6', schemaName:'PostSchema', modelName:'PostModel'}
        ,{file:'./count_schema', collection:'counters', schemaName:'CounterSchema', modelName:'CounterModel'}
	],
	route_info: [
        {file:'./user', path:'/process/listuser', method:'listuser', type:'get'}
        ,{file:'./user', path:'/process/adduser', method:'adduser', type:'get'}
        ,{file:'./user', path:'/process/test', method:'test', type:'get'}
	    ,{file:'./device', path:'/process/adddevice', method:'adddevice', type:'get'}
	    ,{file:'./device', path:'/process/listdevice', method:'listdevice', type:'post'}
	    ,{file:'./device', path:'/process/register', method:'register', type:'post'}
	    ,{file:'./device', path:'/process/sendall', method:'sendall', type:'post'}
        ,{file:'./post', path:'/process/listpost', method:'listpost', type:'get'}
        ,{file:'./post', path:'/process/addpost', method:'addpost', type:'get'}
	]
}