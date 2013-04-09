package hu.brg.implementor.generator.strategies.oracle;

import hu.brg.domain.DomainUtils;
import hu.brg.domain.businessrule.BRGBusinessRule;
import hu.brg.implementor.generator.RuleGenerator;

import java.util.HashMap;
import java.util.Map;

public class OracleRuleGenerator extends RuleGenerator {

	@Override
	public String generateACMPRule(BRGBusinessRule forRule) {
		Map<String, Object> data = new HashMap<String, Object>();
		
		data.put("column1", DomainUtils.getFirstColumnFromBusinessRule(forRule).getName());
		data.put("value", DomainUtils.getFirstValueFromBusinessRule(forRule).getValue());
		data.put("operand", getOperandSQL(forRule.getOperator()));
		
		return fms.processTemplate("oracle/ACMPRule.ftl", data);
	}

	@Override
	public String generateARNGRule(BRGBusinessRule forRule) {
		Map<String, Object> data = new HashMap<String, Object>();
		
		data.put("column", null);
		data.put("operand", null);
		data.put("minvalue", null);
		data.put("maxvalue", null);
		
		return fms.processTemplate("oracle/ARNGRule.ftl", data);
	}

	@Override
	public String generateALISRule(BRGBusinessRule forRule) {
		Map<String, Object> data = new HashMap<String, Object>();
		
		data.put("colum", null);
		data.put("values", null);
		
		return fms.processTemplate("oracle/ALISRule.ftl", data);
	}

	@Override
	public String generateAOTHRule(BRGBusinessRule forRule) {
		Map<String, Object> data = new HashMap<String, Object>();
		
		data.put("query", null);
		
		return fms.processTemplate("oracle/AOTHRule.ftl", data);
	}

	@Override
	public String generateTCMPRule(BRGBusinessRule forRule) {
		Map<String, Object> data = new HashMap<String, Object>();
		
		return fms.processTemplate("oracle/TCMPRule.ftl", data);
	}

	@Override
	public String generateTOTHRule(BRGBusinessRule forRule) {
		Map<String, Object> data = new HashMap<String, Object>();
		
		return fms.processTemplate("oracle/TOTHRule.ftl", data);
	}

	@Override
	public String generateICMPRule(BRGBusinessRule forRule) {
		Map<String, Object> data = new HashMap<String, Object>();
		
		return fms.processTemplate("oracle/ICMPRule.ftl", data);
	}

	@Override
	public String generateEOTHRule(BRGBusinessRule forRule) {
		Map<String, Object> data = new HashMap<String, Object>();
		
		return fms.processTemplate("oracle/EOTHRule.ftl", data);
	}

	@Override
	public String generateMODIRule(BRGBusinessRule forRule) {
		Map<String, Object> data = new HashMap<String, Object>();
		
		return fms.processTemplate("oracle/MODIRule.ftl", data);
	}

	@Override
	public String getOperandSQL(String operand) {
		switch (operand) {
			case "LT":
				return "<";
			case "LTE":
				return "<=";
			case "GT":
				return ">";
			case "GTE":
				return ">=";
			case "EQ":
				return "=";
			case "NEQ":
				return "!=";
			case "IN":
				return "BETWEEN";
			case "NOTIN":
				return "NOT BETWEEN";
		}
		return null;
	}

}
