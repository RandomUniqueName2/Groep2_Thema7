package hu.brg.gui;

import hu.brg.common.AbstractAuthGetter;

import java.util.Properties;

import javax.swing.JOptionPane;

public class DBAuthGetter extends AbstractAuthGetter {
	@Override
	public void getAuth(Properties props) {
		DBConnectDialog connDialog = new DBConnectDialog();
		this.authed = false;
		
		if (props.containsKey("title")) {
			connDialog.setTitle(props.getProperty("title"));
		}
		
		if (props.containsKey("connstring")) {
			connDialog.setConnectString(props.getProperty("connstring"));
			connDialog.setConnStringReadOnly(true);
		}
		
		connDialog.showDialog();
		
		if (!connDialog.isClosed()) {
			this.password = connDialog.getPassword();
			this.userName = connDialog.getUsername();
			this.authed = true;
			connDialog.close();
		}
	}

	@Override
	public void showAuthError(String reason) {
		String[] options = new String[] { "Retry", "Skip" };
		JOptionPane.showOptionDialog(null, reason, "An authentication error occured" , JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[1]);
	}

}
