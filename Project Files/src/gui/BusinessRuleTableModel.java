package gui;

import java.util.ArrayList;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import domain.BRGBusinessRule;
import domain.BRGRuleToTable;

public class BusinessRuleTableModel implements TableModel {
	ArrayList<BRGBusinessRule> data;
	ArrayList<TableModelListener> listeners;
	
	public BusinessRuleTableModel(ArrayList<BRGBusinessRule> data)
	{
		this.data = data;
	}
	
	@Override
	public int getColumnCount() {
		// Name, Type, Table
		return  3;
	}

	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public Object getValueAt(int r, int c) {
		if (r < data.size() && c < getColumnCount()) {
			switch(c) {
			case 0:
				return data.get(r).getName();
			case 1:
				return data.get(r).getBusinessRuleType().getName();
			case 2:
				StringBuilder tableNames = new StringBuilder();
				for (BRGRuleToTable rtt : data.get(r).getRuleToTable()) {
					if (r == 0) {
						tableNames.append(rtt.getTable().getName());
					} else {
						tableNames.append(", " + rtt.getTable().getName());
					}
				}
				return tableNames.toString();
			}
		}
		// Else
		return null;
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		//this.listeners.add(l);		
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex)
		{
		case 0:
			return "Name";
		case 1:
			return "Rule Type";
		case 2: 
			return "Table(s)";
		}
		
		return null;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		this.listeners.remove(l);
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		
	}

}
