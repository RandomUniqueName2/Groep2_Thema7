package hu.brg.gui;

import hu.brg.domain.DomainService;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ConnectPopup extends JDialog implements ActionListener {
	private final JLabel messageLabel = new JLabel();
	private final JLabel usernameLabel = new JLabel(); 
	private final JLabel passwordLabel = new JLabel();
	private final JTextField connectStringField = new JTextField();
	private final JTextField usernameField = new JTextField();
	private final JPasswordField passwordField = new JPasswordField();
	private final JButton okButton = new JButton();
	private final JButton cancelButton = new JButton();
	
	private ImplementorMainFrame imf;

	public ConnectPopup(ImplementorMainFrame imf) {
		this.setPreferredSize(new Dimension(500, 200));
		
		this.setPreferredSize(new Dimension(500, 200));
		this.getContentPane().setLayout(null);
		this.setResizable(false);
		this.setModalityType(ModalityType.APPLICATION_MODAL);
		this.setTitle("Connect to Repository");
		
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

		this.getContentPane().add(messageLabel);
		this.getContentPane().add(connectStringField);
		this.getContentPane().add(okButton);
		this.getContentPane().add(cancelButton);
		this.getContentPane().add(passwordField);
		this.getContentPane().add(usernameField);
		this.getContentPane().add(passwordLabel);
		this.getContentPane().add(usernameLabel);
		
		this.imf = imf;
		
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent anEvent) {
		if (anEvent.getActionCommand() == "ok") {
			try {
				DomainService ds = new DomainService();
				ds.connectToRepository(this.connectStringField.getText(), 
						this.usernameField.getText(), 
						new String(this.passwordField.getPassword())
				);
				
				if (imf != null) {
					imf.setTableData(ds.getAllBusinessRules());
				}
				
				this.dispose();
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(this,
					"Connection to repository failed.\nPlease doublecheck the connection details.\n\n" + e.getMessage(),
					"Connection error", 
					JOptionPane.ERROR_MESSAGE
				);
			}
		}
		
		if (anEvent.getActionCommand() == "cancel") {
			this.dispose();
		}
		
	}

}
