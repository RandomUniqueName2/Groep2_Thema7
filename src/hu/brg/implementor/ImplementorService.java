package hu.brg.implementor;

import hu.brg.common.iAuthGetter;
import hu.brg.domain.DomainUtils;
import hu.brg.domain.database.BRGDatabase;
import hu.brg.domain.database.BRGSchema;
import hu.brg.domain.database.BRGTable;
import hu.brg.implementor.generator.TableGenerator;
import hu.brg.implementor.generator.strategies.oracle.OracleRulePersistor;
import hu.brg.implementor.generator.strategies.oracle.OracleTableGenerator;

import java.util.Collection;
import java.util.Properties;

public class ImplementorService {
	private ImplementorStrategy strategy;
	
	public final void implementBusinessRules(Collection<BRGDatabase> dbs, iAuthGetter author) throws Exception {
		
		
		for (BRGDatabase db : dbs) {
			this.strategy = Enum.valueOf(ImplementorStrategy.class, db.getDatabaseProvider().toUpperCase());
			
			RulePersistor persistor = getRulePersistor();
			Properties props = new Properties();
			
			props.setProperty("title", "Connect to target database");
			props.setProperty("connstring", db.getConnectionString());
			
			author.getAuth(props);
			
			if (author.hasAuthed()) {
				persistor.connect(db.getConnectionString(), author.getUserName(), author.getPassword());
				
				if (persistor.isConnected()) {
					for (BRGSchema schema : db.getSchemas()) {
						for (BRGTable table : schema.getTables()) {
							TableGenerator tableGenerator = getTableGenerator();
							
							if (DomainUtils.tableHasImplBusinessRules(table)) {
								String generatedTableSQL = tableGenerator.generateRulesForTable(table);
								System.out.println(generatedTableSQL);
								persistor.runStatement(generatedTableSQL);
							} else {
								System.out.println(tableGenerator.getDropTableTriggerStmt(table));
								//persistor.runStatement(tableGenerator.getDropTableTriggerStmt(table));
							}
						}
					}
				}
			}
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