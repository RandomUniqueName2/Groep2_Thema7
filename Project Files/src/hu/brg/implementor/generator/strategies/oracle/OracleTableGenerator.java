package hu.brg.implementor.generator.strategies.oracle;

import hu.brg.domain.database.BRGTable;
import hu.brg.implementor.generator.TableGenerator;
import hu.brg.implementor.generator.iRuleGenerator;
import hu.brg.implementor.generator.freemarker.FreemarkerService;

import java.util.HashMap;
import java.util.Map;

public class OracleTableGenerator extends TableGenerator {
	private final FreemarkerService fms = new FreemarkerService();
		
	@Override
	protected final iRuleGenerator getRuleGenerator() {
		return (iRuleGenerator) new OracleRuleGenerator();
	}

	@Override
	protected String getTablePreWrapper(BRGTable forTable) {
		Map<String, String> data = new HashMap<String, String>();
		
		data.put("tableName", forTable.getName());
		
		return fms.processTemplate("oracle/pretablewrapper.ftl", data);
	}

	@Override
	protected String getTablePostWrapper(BRGTable forTable) {
		return fms.processTemplate("oracle/posttablewrapper.ftl", null);
	}
}
