package gui;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import main.App;
import controller.ConnectionController;

@SuppressWarnings("serial")
public class ConnectPopup extends JDialog implements ActionListener {
	public JLabel message = null;
	public JTextField connectStringField = null;
	public JButton okButton = null, 
			       cancelButton = null;
	
	public ConnectPopup() {
		Point p = App.mainFrame.getLocationOnScreen();
		p.x += 150;
		p.y += 230;
		
		this.setPreferredSize(new Dimension(500, 140));
		getContentPane().setLayout(null);
		this.setResizable(false);
		this.setLocation(p);
		App.mainFrame.getLocationOnScreen();
		this.setModalityType(ModalityType.APPLICATION_MODAL);
		
		message = new JLabel("Connection string of target business rule repository:");
		message.setBounds(20, 0, 460, 40);
		
		connectStringField = new JTextField();
		connectStringField.setBounds(20, 35, 460, 25);
		
		okButton = new JButton("Ok");
		okButton.setBounds(270, 65, 100, 30);
		okButton.setActionCommand("ok");
		okButton.addActionListener(this);
		
		cancelButton = new JButton("Cancel");
		cancelButton.setBounds(380, 65, 100, 30);
		cancelButton.setActionCommand("cancel");
		cancelButton.addActionListener(this);
		
		this.getContentPane().add(message);
		this.getContentPane().add(connectStringField);
		this.getContentPane().add(okButton);
		this.getContentPane().add(cancelButton);
		
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		
		if (action == "ok") {
			ConnectionController c = new ConnectionController();
			c.StartConnection();			
		}
		
		if (action == "cancel" || action == "ok") {
			this.dispose();
		}
				
	}
}
