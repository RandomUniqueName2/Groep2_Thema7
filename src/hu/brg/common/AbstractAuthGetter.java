package hu.brg.common;

public abstract class AbstractAuthGetter implements iAuthGetter {
	protected String userName;
	protected String password;
	protected Boolean authed;

	@Override
	public String getUserName() {	
		return userName;
	}

	@Override
	public String getPassword() {
		return password;
	}
	
	@Override
	public Boolean hasAuthed() {
		return authed;
	}

}
