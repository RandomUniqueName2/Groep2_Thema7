package hu.brg.implementor;

import hu.brg.domain.businessrule.BRGBusinessRule;
import hu.brg.domain.database.BRGTable;
import hu.brg.domain.mapping.BRGRuleToTable;
import hu.brg.implementor.generator.TableGenerator;
import hu.brg.implementor.generator.strategies.oracle.OracleTableGenerator;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ImplementorService {
	private ImplementorStrategy strategy;
	
	public final void implementBusinessRules(Collection<BRGBusinessRule> forRules) {
		Set<BRGTable> tables = new HashSet<BRGTable>();
		
		for (BRGBusinessRule rule : forRules) {
			for (BRGRuleToTable rtt : rule.getRuleToTables()) {
				tables.add(rtt.getDatabaseTable());
			}
		}
		
		TableGenerator generator = getTableGenerator();
		RulePersistor persistor = getRulePersistor();
		
		for (BRGTable table : tables) {
			String sqlCode = generator.generateRulesForTable(table);
			persistor.persist(sqlCode);
		}
		
	}
	
	private final TableGenerator getTableGenerator() {
		TableGenerator generator = null;
		
		switch (strategy) {
		case ORACLE:
			generator = new OracleTableGenerator();
			break;
		default:
			break;
		}
		
		return generator;
	}
	
	private final RulePersistor getRulePersistor() {
		// TODO Get a rulepersistor;
		return null;
	}
}
