package hu.brg.implementor;

import hu.brg.domain.businessrule.BRGBusinessRule;
import hu.brg.domain.database.BRGTable;
import hu.brg.domain.mapping.BRGRuleToTable;
import hu.brg.implementor.generator.TableGenerator;
import hu.brg.implementor.generator.strategies.oracle.OracleRulePersistor;
import hu.brg.implementor.generator.strategies.oracle.OracleTableGenerator;

import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ImplementorService {
	private ImplementorStrategy strategy;
	
	public final void implementBusinessRules(Collection<BRGBusinessRule> forRules, RulePersistor persistor) throws SQLException, Exception {
		Set<BRGTable> tables = new HashSet<BRGTable>();
		
		for (BRGBusinessRule rule : forRules) {
			for (BRGRuleToTable rtt : rule.getRuleToTables()) {
				tables.add(rtt.getDatabaseTable());
			}
		}
		
		TableGenerator generator = getTableGenerator();
		
		for (BRGTable table : tables) {			
			String sqlCode = generator.generateRulesForTable(table);
			persistor.runStatement(sqlCode);
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
	
	public final RulePersistor getRulePersistor() {
		RulePersistor persistor = null;
		
		switch (strategy) {
		case ORACLE:
			persistor = new OracleRulePersistor();
			break;
		default:
			break;
		}
		
		return persistor;
	}
}