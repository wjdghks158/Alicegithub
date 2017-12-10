
public interface OnReceived {
	//무엇을 보내는가 포인터가 없으니 바이트array 쓰면 되는데 bytebuf도 있는데 수신한거
	// 소켓 받은거 가공해야 한다면 편법으로 포인터를 사용하는가 JNI로 해서 메모리 풀 해서 c언어 사용할 수 도 있음
	//int packetType 데이타 보낼 때 tcp/ip 한덩어리로 간다는 보장이 없잖아 처리하는 부분 델리게이터 구분자 하는 경우도 있고
	//보통의 경우 앞에 헤더 + 데이타 네티는 내부에서 되어있음 헤더가 사이즈 얼마냐 지정하면 지가 알아서 짜르고 붙인다.
	// 패킷 타입으로 어떤건가 알기도 한다.
	public void onReceived(Object connection,int packetType, Object data);

}
