package gui;

import hibernate.HibernateService;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import main.App;

@SuppressWarnings("serial")
public class ConnectPopup extends JDialog implements ActionListener {
	private JLabel messageLabel, usernameLabel, passwordLabel;
	private JTextField connectStringField;
	public JButton okButton = null, cancelButton = null;
	private JTextField usernameField;
	private JPasswordField passwordField;

	public ConnectPopup() {
		Point p = App.mainFrame.getLocationOnScreen();
		p.x += 150;
		p.y += 230;

		this.setPreferredSize(new Dimension(500, 200));
		getContentPane().setLayout(null);
		this.setResizable(false);
		this.setLocation(p);
		App.mainFrame.getLocationOnScreen();
		this.setModalityType(ModalityType.APPLICATION_MODAL);

		messageLabel = new JLabel("Connection string:");
		messageLabel.setBounds(20, 0, 460, 40);

		usernameLabel = new JLabel("Username:");
		usernameLabel.setBounds(20, 71, 145, 14);

		passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(250, 71, 164, 14);

		connectStringField = new JTextField();
		connectStringField.setBounds(20, 35, 460, 25);
		connectStringField.setText(HibernateService
				.getConfigProp(HibernateService.CONNECT_PROPERTY_NAME));

		usernameField = new JTextField();
		usernameField.setBounds(20, 91, 220, 25);
		usernameField.setText(HibernateService
				.getConfigProp(HibernateService.USERNAME_PROPERTY_NAME));

		passwordField = new JPasswordField();
		passwordField.setBounds(250, 91, 230, 25);
		passwordField.setText(HibernateService
				.getConfigProp(HibernateService.PASSWORD_PROPERTY_NAME));

		okButton = new JButton("Ok");
		okButton.setBounds(270, 130, 100, 30);
		okButton.setActionCommand("ok");
		okButton.addActionListener(this);

		cancelButton = new JButton("Cancel");
		cancelButton.setBounds(380, 130, 100, 30);
		cancelButton.setActionCommand("cancel");
		cancelButton.addActionListener(this);

		this.getContentPane().add(messageLabel);
		this.getContentPane().add(connectStringField);
		this.getContentPane().add(okButton);
		this.getContentPane().add(cancelButton);
		this.getContentPane().add(passwordField);
		this.getContentPane().add(usernameField);
		this.getContentPane().add(passwordLabel);
		this.getContentPane().add(usernameLabel);

		this.pack();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();

		if (action == "ok") {
			String connString = this.connectStringField.getText();
			String usrnString = this.usernameField.getText();
			String pswdString = new String(this.passwordField.getPassword());

			try {
				// HibernateService.setHibernateConnection(connString,
				// usrnString,
				// pswdString);
				HibernateService.setHibernateConnection(
						"jdbc:oracle:thin:@ondora01.hu.nl:8521/cursus01.hu.nl",
						"THO7_2012_2B_TEAM2", "THO7_2012_2B_TEAM2");
				HibernateService.getSessionFactory();
				this.dispose();
			} catch (Exception err) {
				err.printStackTrace();
				JOptionPane
						.showMessageDialog(
								this,
								"Connection to repository failed.\nPlease doublecheck the connection details.",
								"Connection error", JOptionPane.ERROR_MESSAGE);
			}

		}

		if (action == "cancel") {
			this.dispose();
		}

	}
}
