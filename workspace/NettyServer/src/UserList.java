// 비동기식 락을 걸지 않기 위해서
public class UserList {

	//외부에 알리는건 이벤트처리 = 인터페이스 사용
	
	public void add(Object connection) {
		
	}
	
	public void remove(Object connection) {
		
	}
	
	private OnUserAdded m_OnUserAdded = null;
	private OnUserRemoved m_OnUserRemoved = null;
	
	public OnUserAdded getOnUserAdded() {
		return m_OnUserAdded;
	}

	public void setOnUserAdded(OnUserAdded m_OnUserAdded) {
		this.m_OnUserAdded = m_OnUserAdded;
	}

	public OnUserRemoved getOnUserRemoved() {
		return m_OnUserRemoved;
	}

	public void setOnUserRemoved(OnUserRemoved m_OnUserRemoved) {
		this.m_OnUserRemoved = m_OnUserRemoved;
	}

	
}
