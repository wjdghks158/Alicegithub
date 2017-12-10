
public class Protocol {
	
	private Socket m_Socket = new Socket();
	private UserList m_UserList = new UserList();
	private ConnectionsList m_ConnectionList = new ConnectionsList();
	
	//생성자 초기화 작업 하자
	public Protocol() {
		m_UserList.setOnUserAdded(new OnUserAdded() {

			@Override
			public void onUserAdded(Object user) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		m_UserList.setOnUserRemoved(new OnUserRemoved() {
			//유저 remove 되면 뭐라뭐라 말해주자
			@Override
			public void onUserRemoved(Object user) {
				sp_UserOut(user);
				
			}
		});
		
		m_Socket.setOnConnected(new OnConnected() {
			
			@Override
			public void onConnected(Object connection) {
				m_ConnectionList.add(connection);//리스트에 conn add 하자 
				sp_AskUserID(connection);
				
			}
		});
		
		m_Socket.setOnDisconnected(new OnDisconnected() {
			
			@Override
			public void onDisconnected(Object connection) {
				m_ConnectionList.remove(connection);
				m_UserList.remove(connection); // 지우고 나서 비동기로 콜백 해주자
				
			}
		});
		
		m_Socket.setReceived(new OnReceived() {
			
			@Override
			public void onReceived(Object connection, int packetType, Object data) {
				switch (packetType) {
				//패킷 유저 아이디 받으면  패스워드 물어볼까? 콘솔로 하기 때문에 아이디 입력하고 password 입력한다.
				case PacketType.ptUserID : {
					// TODO : connection.UserID = ...;
					sp_AskPassword(connection);
				}
				break;
				//패스워드 받으면 로그인 해야지
				case PacketType.ptAskPassword: {
					// TODO: Login
				}
				break;
				
				case PacketType.ptChat: {
					// TODO : 소켓안에 send 페킷 
				}
				break;
				
				}
				
			}
		});
	}
	
	
	// 나중에 보내는 뭐시기 
	private void sp_AskUserID(Object connection) {
		
	}
	private void sp_AskPassword(Object connection) {
		
	}
	private void sp_UserOut(Object connection) {
		
	}

}
