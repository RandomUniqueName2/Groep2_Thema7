package hu.brg.gui;

import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class DBConnectDialog implements ActionListener {
	private final JDialog dialog = new JDialog();
	private final JLabel messageLabel = new JLabel();
	private final JLabel usernameLabel = new JLabel(); 
	private final JLabel passwordLabel = new JLabel();
	private final JTextField connectStringField = new JTextField();
	private final JTextField usernameField = new JTextField();
	private final JPasswordField passwordField = new JPasswordField();
	private final JButton okButton = new JButton();
	private final JButton cancelButton = new JButton();
	
	private Boolean closed = false;	
	
	public DBConnectDialog() {
		dialog.setPreferredSize(new Dimension(500, 200));
		
		dialog.setPreferredSize(new Dimension(500, 200));
		dialog.getContentPane().setLayout(null);
		dialog.setResizable(false);
		dialog.setModalityType(ModalityType.APPLICATION_MODAL);
		dialog.setModal(true);
		
		messageLabel.setBounds(20, 0, 460, 40);
		messageLabel.setText("Connection String:");

		usernameLabel.setBounds(20, 71, 145, 14);
		usernameLabel.setText("Username");

		passwordLabel.setBounds(250, 71, 164, 14);
		passwordLabel.setText("Password");

		connectStringField.setBounds(20, 35, 460, 25);

		usernameField.setBounds(20, 91, 220, 25);
		
		passwordField.setBounds(250, 91, 230, 25);

		okButton.setText("Connect");
		okButton.setBounds(270, 130, 100, 30);
		okButton.setActionCommand("ok");
		okButton.addActionListener(this);

		cancelButton.setText("Cancel");
		cancelButton.setBounds(380, 130, 100, 30);
		cancelButton.setActionCommand("cancel");
		cancelButton.addActionListener(this);

		dialog.getContentPane().add(messageLabel);
		dialog.getContentPane().add(connectStringField);
		dialog.getContentPane().add(okButton);
		dialog.getContentPane().add(cancelButton);
		dialog.getContentPane().add(passwordField);
		dialog.getContentPane().add(usernameField);
		dialog.getContentPane().add(passwordLabel);
		dialog.getContentPane().add(usernameLabel);
		
		dialog.pack();
	}

	@Override
	public void actionPerformed(ActionEvent anEvent) {
		if (anEvent.getActionCommand() == "ok") {
			dialog.setVisible(false);
		}
		
		if (anEvent.getActionCommand() == "cancel") {
			close();
		}
	}
	
	public void setConnStringReadOnly(Boolean readonly) {
		connectStringField.setEditable(!readonly);
	}
	
	public void setUsernameReadOnly(Boolean readonly) {
		usernameField.setEditable(!readonly);
	}
	
	public void setPasswordReadOnly(Boolean readonly) {
		passwordField.setEditable(!readonly);
	}
	
	public void showDialog() {
		dialog.setVisible(true);
	}
	
	public void close() {
		dialog.dispose();
		closed = true;
	}
	
	public Boolean isClosed() {
		return closed;
	}
	
	public String getPassword() {
		return new String(passwordField.getPassword());
	}
	
	public String getUsername() {
		return usernameField.getText();
	}
	
	public String getConnectString() {
		return connectStringField.getText();
	}
	
	public void setPassword(String pwd) {
		passwordField.setText(pwd);
	}
	
	public void setUsername(String username) {
		usernameField.setText(username);
	}
	
	public void setConnectString(String connString) {
		connectStringField.setText(connString);
	}

	public String getTitle() {
		return this.dialog.getTitle();
	}

	public void setTitle(String title) {
		this.dialog.setTitle(title);
	}
}
