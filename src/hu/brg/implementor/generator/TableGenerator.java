package hu.brg.implementor.generator;

import hu.brg.domain.businessrule.BRGBusinessRule;
import hu.brg.domain.database.BRGTable;
import hu.brg.domain.mapping.BRGRuleToTable;

public abstract class TableGenerator implements iTableGenerator {

	@Override
	public final String generateRulesForTable(BRGTable forTable) {
		iRuleGenerator generator = getRuleGenerator();
		StringBuilder sb = new StringBuilder();
		
		sb.append(getTablePreWrapper(forTable));
		
		for (BRGRuleToTable rtt : forTable.getRuleToTables()) {
			BRGBusinessRule forRule = rtt.getBusinessRule();
			
			if (forRule.isImplemented()) {
				switch (forRule.getBusinessRuleType().getCode()) {
				case "ACMP":
					sb.append(generator.generateACMPRule(forRule));
					break;
				case "ARNG":
					sb.append(generator.generateARNGRule(forRule));
					break;
				case "ALIS":
					sb.append(generator.generateALISRule(forRule));
					break;
				case "AOTH":
					sb.append(generator.generateAOTHRule(forRule));
					break;
				case "TCMP":
					sb.append(generator.generateTCMPRule(forRule));
					break;
				case "TOTH":
					sb.append(generator.generateTOTHRule(forRule));
					break;
				case "ICMP":
					sb.append(generator.generateICMPRule(forRule));
					break;
				case "EOTH":
					sb.append(generator.generateEOTHRule(forRule));
					break;
				case "MODI":
					sb.append(generator.generateMODIRule(forRule));
					break;
				}
			}
		}
		
		sb.append(getTablePostWrapper(forTable));
		
		return sb.toString();
	}
	
	protected abstract iRuleGenerator getRuleGenerator();
	protected abstract String getTablePreWrapper(BRGTable forTable);
	protected abstract String getTablePostWrapper(BRGTable forTable);
	public abstract String getDropTableTriggerStmt(BRGTable forTable);
}
