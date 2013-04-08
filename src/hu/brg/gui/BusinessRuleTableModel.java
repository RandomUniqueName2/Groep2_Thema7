package hu.brg.gui;

import hu.brg.domain.DomainUtils;
import hu.brg.domain.businessrule.BRGBusinessRule;

import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class BusinessRuleTableModel extends AbstractTableModel {
	private String[] columnNames = { "Implemented", "Name", "Type", "Table(s)" };
	private Class<?>[]  columnClasses = { Boolean.class, String.class, String.class, String.class };
	
	private List<BRGBusinessRule> data;
	
	public BusinessRuleTableModel(List<BRGBusinessRule> data) {
		this.data = data;
	}
	
	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return columnClasses[columnIndex];
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		
		switch (columnIndex) {
		case 0:
			return true;
		case 1:
			return false;
		case 2:
			return false;
		case 3: 
			return false;
		}
		
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		BRGBusinessRule rule = this.data.get(rowIndex);
		
		switch (columnIndex) {
		case 0:
			return rule.isImplemented();
		case 1:
			return rule.getName();
		case 2:
			return rule.getBusinessRuleType().getName();
		case 3: 
			return DomainUtils.getTablesFromBusinessRuleAsString(rule);
		}
		
		return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		BRGBusinessRule rule = this.data.get(rowIndex);
		
		switch (columnIndex) {
		case 0:
			rule.setImplemented((Boolean)aValue);
		}
		
	}
	
	public List<BRGBusinessRule> getData() {
		return data;
	}
}
