

//소켓 오픈 

//socket은 3가지 중요 이벤트가 있어
public class Socket {
	private OnConnected m_OnConnected = null;
	private OnDisconnected m_OnDisconnected = null;
	private OnReceived m_Received = null;
	

	public OnConnected getOnConnected() {
		return m_OnConnected;
	}

	public void setOnConnected(OnConnected m_OnConnected) {
		this.m_OnConnected = m_OnConnected;
	}

	public OnDisconnected getOnDisconnected() {
		return m_OnDisconnected;
	}

	public void setOnDisconnected(OnDisconnected m_OnDisconnected) {
		this.m_OnDisconnected = m_OnDisconnected;
	}

	public OnReceived getReceived() {
		return m_Received;
	}

	public void setReceived(OnReceived m_Received) {
		this.m_Received = m_Received;
	}

	public void start(int port) {
		
	}
	
	public void stop() {
		
	}
}
