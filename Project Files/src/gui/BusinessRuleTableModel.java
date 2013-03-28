package gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import domain.businessrule.BRGBusinessRule;
import domain.mapping.BRGRuleToTable;

public class BusinessRuleTableModel implements TableModel {
	List<BRGBusinessRule> data;
	List<TableModelListener> listeners;

	public BusinessRuleTableModel(List<BRGBusinessRule> list) {
		this.data = list;
		this.listeners = new ArrayList<TableModelListener>();
	}

	@Override
	public int getColumnCount() {
		// Implemented, Name, Type, Table
		return 4;
	}

	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public Object getValueAt(int r, int c) {
		if (r < data.size() && c < getColumnCount()) {
			switch (c) {
			case 0:
				return data.get(r).getImplemented();
			case 1:
				return data.get(r).getName();
			case 2:
				return data.get(r).getBusinessRuleType().getName();
			case 3:
				StringBuilder tableNames = new StringBuilder();
				List<BRGRuleToTable> rtt = data.get(r).getRuleToTable();
				for (int i = 0; i < rtt.size(); i++) {
					if (i == 0) {
						tableNames.append(rtt.get(i).getTable().getName());
					} else {
						tableNames.append(", "
								+ rtt.get(i).getTable().getName());
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
		this.listeners.add(l);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if (columnIndex == 0) {
			return Boolean.class;
		} else {
			return String.class;
		}
	}

	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return "Implemented";
		case 1:
			return "Name";
		case 2:
			return "Rule Type";
		case 3:
			return "Table(s)";
		}

		return null;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if (columnIndex == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		this.listeners.remove(l);
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		if (columnIndex == 0) {
			data.get(rowIndex).setImplemented((Boolean) aValue);
		}
	}

}
