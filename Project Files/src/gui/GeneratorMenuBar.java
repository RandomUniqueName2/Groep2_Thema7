package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class GeneratorMenuBar extends JMenuBar implements ActionListener {
	public JMenu file;
	
	public JMenuItem connect;
	
	public GeneratorMenuBar() {
		super();
		
		this.setPreferredSize(new Dimension(800,30));

		file = new JMenu("File");
		
		connect = new JMenuItem("Connect to repository");
		connect.setActionCommand("connect");
		connect.addActionListener(this);
		
		file.add(connect);
		
		this.add(file);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "connect":
			new ConnectPopup();
			break;
		}
	}
}
