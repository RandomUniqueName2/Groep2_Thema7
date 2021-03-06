package hu.brg.gui;

import hu.brg.domain.DomainService;
import hu.brg.domain.businessrule.BRGBusinessRule;
import hu.brg.implementor.ImplementorService;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

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
		menuBar.setBackground(UIManager.getColor("MenuBar.background"));
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setBackground(UIManager.getColor("Menu.background"));
		menuBar.add(mnFile);
		
		JMenuItem mntmConnect = new JMenuItem("Connect to Repository");
		mntmConnect.setSelected(true);
		mntmConnect.setActionCommand("connect");
		mntmConnect.addActionListener(this);
		mntmConnect.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mnFile.add(mntmConnect);
		
		JMenuItem mntmReloadBusinnesRules = new JMenuItem("Reload Businnes Rules");
		mntmReloadBusinnesRules.setActionCommand("reload");
		mntmReloadBusinnesRules.addActionListener(this);
		mntmReloadBusinnesRules.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mnFile.add(mntmReloadBusinnesRules);
		
		JMenuItem mntmImplementRules = new JMenuItem("Implement Business Rules");
		mntmImplementRules.setActionCommand("generate");
		mntmImplementRules.addActionListener(this);
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
			
		table = new JTable();
		table.setFillsViewportHeight(true);
		
		this.setTableData(new ArrayList<BRGBusinessRule>());
		
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane(table);
		contentPane.add(scrollPane);
	}
	
	@Override
	public void actionPerformed(ActionEvent aEvent) {
		switch(aEvent.getActionCommand()) {
		case "exit": 
			this.saveBusinessRules();
			this.dispose();
			break;
		case "connect":
			connectToRepository();
			loadBusinessRules();
			break;
		case "generate":
			this.saveBusinessRules();
			try {
				is.implementBusinessRules(ds.getAllDatabases(), new DBAuthGetter());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Implementation of business rules failed\n" + e.getMessage(), "Implementation Error",	 JOptionPane.ERROR_MESSAGE, null);
				e.printStackTrace();
			}
			break;
		case "reload":
			this.loadBusinessRules();
			break;
		default:
			break;
		}
	}
	
	public void connectToRepository() {
		DBConnectDialog connDialog = new DBConnectDialog();
		
		connDialog.setTitle("Connect to repository");
		connDialog.showDialog();
		
		while (!connDialog.isClosed()) {
			try {
				//ds.connectToRepository(connDialog.getConnectString(), connDialog.getUsername(), connDialog.getPassword());
				// TODO: Remove this debug connection!
				ds.connectToRepository("jdbc:oracle:thin:@ondora01.hu.nl:8521/cursus01.hu.nl", "THO7_2012_2B_TEAM2", "THO7_2012_2B_TEAM2");
				break;
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Failed to connect to repository\n" + e.getMessage(), "Connection Error",	 JOptionPane.ERROR_MESSAGE, null);
				connDialog.showDialog();
			}
		}
	}
	
	public void setTableData(List<BRGBusinessRule> businessRules) {
		BusinessRuleTableModel model = new BusinessRuleTableModel(businessRules);
			
		table.setModel(model);
		
		table.setRowSorter(new TableRowSorter<TableModel>(model));
		
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(0).setMaxWidth(30);
	}
	
	public void loadBusinessRules() {
		try {
			List<BRGBusinessRule> allRules = ds.getAllBusinessRules();
			this.setTableData(allRules);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Failed to retrieve business rules.\n" + e.getMessage(), "Connection Error",	 JOptionPane.ERROR_MESSAGE, null);
		}
	}
	
	public void saveBusinessRules() {
		TableModel model = table.getModel();
		List<BRGBusinessRule> allRules = ((BusinessRuleTableModel) model).getData();
		
		ds.persistBusinessRules(allRules);
	}
}
