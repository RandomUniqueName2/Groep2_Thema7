package hu.brg.common;

import java.util.Properties;

public interface iAuthGetter {
	public void getAuth(Properties props);
	public void showAuthError(String reason);
	public Boolean hasAuthed();
	public String getUserName();
	public String getPassword();
}
