package gui;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import domain.businessrule.BRGBusinessRule;

@SuppressWarnings("serial")
public class GeneratorMainFrame extends JFrame {
	private GeneratorMenuBar topMenuBar;
	public static JTable table;

	public GeneratorMainFrame() {
		super();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(800, 600));
		getContentPane().setLayout(null);

		table = new JTable();
		table.setFillsViewportHeight(true);

		JScrollPane tableWrapScrollPane = new JScrollPane(table);
		tableWrapScrollPane.setBounds(0, 0, 800, 600);

		topMenuBar = new GeneratorMenuBar();
		this.setJMenuBar(topMenuBar);

		BusinessRuleTableModel model = new BusinessRuleTableModel(
				new ArrayList<BRGBusinessRule>());

		table.setModel(model);

		getContentPane().add(tableWrapScrollPane);

		this.pack();
		this.setVisible(true);
	}

	public JTable getTable() {
		return table;
	}
}
