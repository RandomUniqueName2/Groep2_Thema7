package hu.brg.domain;

import hu.brg.domain.businessrule.BRGBusinessRule;
import hu.brg.domain.businessrule.BRGBusinessRuleValue;
import hu.brg.domain.database.BRGColumn;
import hu.brg.domain.database.BRGTable;
import hu.brg.domain.mapping.BRGRuleToColumn;
import hu.brg.domain.mapping.BRGRuleToTable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DomainUtils {
	public static List<BRGTable> getTablesFromBusinessRule(BRGBusinessRule rule) {
		List<BRGTable> tables = new ArrayList<BRGTable>();
		
		for (BRGRuleToTable rtt : rule.getRuleToTables()) {
			tables.add(rtt.getDatabaseTable());
		}
		
		return tables;
	}
	
	public static String getTablesFromBusinessRuleAsString(BRGBusinessRule rule) {
		List<BRGTable> tables = getTablesFromBusinessRule(rule);
		StringBuilder sb = new StringBuilder();
		
		for (BRGTable t : tables) {
			sb.append(t.getName() + " ");
		}
		
		return sb.toString();
	}
	
	public static BRGColumn getFirstColumnFromBusinessRule(BRGBusinessRule rule) {
		Iterator<BRGRuleToColumn> columnIt = rule.getRuleToColumns().iterator();
		if (columnIt.hasNext()) {
			return columnIt.next().getDatabaseColumn();
		}
		
		return null;
	}
	
	public static BRGBusinessRuleValue getFirstValueFromBusinessRule(BRGBusinessRule rule) {
		Iterator<BRGBusinessRuleValue> valueIt = rule.getValues().iterator();
		if (valueIt.hasNext()) {
			return valueIt.next();
		}
		
		return null;
	}
	
	public static Boolean tableHasImplBusinessRules(BRGTable table) {
		for (BRGRuleToTable rtt: table.getRuleToTables()) {
			if (rtt.getBusinessRule().isImplemented()) {
				return true;
			}
		}
		
		return false;
	}
}

