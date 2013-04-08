package hu.brg.domain;

import hu.brg.domain.businessrule.BRGBusinessRule;
import hu.brg.domain.database.BRGTable;
import hu.brg.domain.mapping.BRGRuleToTable;

import java.util.ArrayList;
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
}
