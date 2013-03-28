package implementor.generators;

import implementor.generators.strategies.OracleRuleGeneratorStrategy;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import domain.businessrule.BRGBusinessRule;
import freemarker.template.Configuration;
import freemarker.template.Template;

public abstract class RuleGenerator implements iRuleGenerator {
	public static final String ORACLE = "Oracle";

	protected static final String BASE_TPL_URI = "Groep2_Thema7/Project Files/src/resources/templates";

	protected Configuration cfg;

	protected RuleGenerator() {
		this.cfg = new Configuration();
		try {
			this.cfg.setDirectoryForTemplateLoading(new File(BASE_TPL_URI));
		} catch (IOException e) {
			System.err.println("RESOURCE FOLDER IS GONE");
			e.printStackTrace();
		}
	}

	public static iRuleGenerator fromStrategy(String strategy) throws Exception {
		switch (strategy) {
		case "Oracle":
			return new OracleRuleGeneratorStrategy();
		default:
			throw new Exception("Chosen strategy is not implemented");
		}
	}

	protected Template getTemplateFromResources(String tplName) {
		Template tpl = null;

		try {
			tpl = cfg.getTemplate(tplName);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return tpl;
	}

	protected Map<String, String> getACMPMappings(BRGBusinessRule fromRule) {
		Map<String, String> mappings = new HashMap<String, String>();

		mappings.put("name", fromRule.getName());
		mappings.put("column", fromRule.getRuleToColumn().get(0).getColumn()
				.getName());
		mappings.put("operand", fromRule.getOperator());
		mappings.put("value", fromRule.getBusinessRuleValues().get(0)
				.toString());

		return mappings;
	}
}
