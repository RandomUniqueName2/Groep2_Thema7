package hu.brg.gui;

import hu.brg.domain.DomainService;
import hu.brg.domain.businessrule.BRGBusinessRule;
import hu.brg.domain.mapping.BRGRuleToTable;
import hu.brg.implementor.ImplementorService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Collection;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class ImplementorMainFrame extends JFrame implements ActionListener {
	private final DomainService ds = new DomainService();
	private final ImplementorService is = new ImplementorService();

	private JPanel contentPane;
	private JTable table;

	public ImplementorMainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setTitle("Business Rule Implementor");
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmConnect = new JMenuItem("Connect to Repository");
		mntmConnect.setSelected(true);
		mntmConnect.setActionCommand("connect");
		mntmConnect.addActionListener(this);
		mntmConnect.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mnFile.add(mntmConnect);
		
		JMenuItem mntmImplementRules = new JMenuItem("Implement Business Rules");
		mntmImplementRules.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mnFile.add(mntmImplementRules);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setActionCommand("exit");
		mntmExit.addActionListener(this);
		mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
		mnFile.add(mntmExit);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
			
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {
				"", "Name", "Type", "Table(s)"
			}
		) {
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				Boolean.class, String.class, String.class, String.class
			};
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(0).setMaxWidth(30);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 784, 540);
		contentPane.add(scrollPane);
	}
	
	@Override
	public void actionPerformed(ActionEvent aEvent) {
		switch(aEvent.getActionCommand()) {
		case "exit": 
			this.dispose();
			break;
		case "connect":
			new ConnectPopup(this);
			break;
		case "generate":
			
			break;
		default:
			break;
		}
	}
	
	public void setTableData(Collection<BRGBusinessRule> businessRules) {
		Object[][] modelData = new Object[businessRules.size()][4];
		
		int i = 0;
		for (BRGBusinessRule rule : businessRules) {
			StringBuilder SBTables = new StringBuilder();
			
			for (BRGRuleToTable t : rule.getRuleToTables()) {
				SBTables.append(t.getDatabaseTable().getName() + " ");
			}
			
			modelData[i][0] = rule.isImplemented() != null ? rule.isImplemented() : false;
			modelData[i][1] = rule.getName();
			modelData[i][2] = rule.getBusinessRuleType().getName();
			modelData[i][3] = SBTables.toString();
			i++;
		}
		
		table.setModel(new DefaultTableModel(
			modelData,
			new String[] {
				"Implemented", "Name", "Type", "Table(s)"
			}
		) {
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				Boolean.class, String.class, String.class, String.class
			};
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
	}
}
