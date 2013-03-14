package gui;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;



@SuppressWarnings("serial")
public class GeneratorMainFrame extends JFrame {
	private GeneratorMenuBar topMenuBar;
	private final JTable table = new JTable();
	
	public GeneratorMainFrame() {
		super();
		
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(800, 600));
		getContentPane().setLayout(null);
		
		JScrollPane tableWrapScrollPane = new JScrollPane();
		tableWrapScrollPane.setBounds(-3, 51, 797, 490);
		getContentPane().add(tableWrapScrollPane);
		getTable().setFillsViewportHeight(true);
		tableWrapScrollPane.setViewportView(getTable());
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(-3, 0, 797, 52);
		getContentPane().add(buttonPanel);
		buttonPanel.setLayout(null);
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.setBounds(10, 11, 120, 30);
		buttonPanel.add(btnGenerate);
		this.setResizable(false);
		this.setLocationByPlatform(true);
		
		topMenuBar = new GeneratorMenuBar();
        this.setJMenuBar(topMenuBar);
		
		this.pack();
		this.setVisible(true);
	}

	public JTable getTable() {
		return table;
	}
}
