package hu.brg.implementor.generator.strategies.oracle;

import hu.brg.domain.DomainUtils;
import hu.brg.domain.businessrule.BRGBusinessRule;
import hu.brg.domain.businessrule.BRGBusinessRuleValue;
import hu.brg.domain.mapping.BRGRuleToColumn;
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
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int intval;
		
		for (BRGBusinessRuleValue val : forRule.getValues()) {
			intval = Integer.parseInt(val.getValue()); 
			
			if (intval < min) {
				min = intval;
			}
			
			if (intval > max) {
				max = intval;
			}
		}
		
		
		data.put("column", DomainUtils.getFirstColumnFromBusinessRule(forRule));
		data.put("operand", getOperandSQL(forRule.getOperator()));
		data.put("minvalue", min);
		data.put("maxvalue", max);
		
		return fms.processTemplate("oracle/ARNGRule.ftl", data);
	}

	@Override
	public String generateALISRule(BRGBusinessRule forRule) {
		Map<String, Object> data = new HashMap<String, Object>();
		
		data.put("colum", DomainUtils.getFirstColumnFromBusinessRule(forRule));
		data.put("values", forRule.getValues());
		
		return fms.processTemplate("oracle/ALISRule.ftl", data);
	}

	@Override
	public String generateAOTHRule(BRGBusinessRule forRule) {
		Map<String, Object> data = new HashMap<String, Object>();
		
		data.put("query", DomainUtils.getFirstValueFromBusinessRule(forRule));
		
		return fms.processTemplate("oracle/AOTHRule.ftl", data);
	}

	@Override
	public String generateTCMPRule(BRGBusinessRule forRule) {
		Map<String, Object> data = new HashMap<String, Object>();
		
		String colA = "";
		String colB = "";
		
		for (BRGRuleToColumn rtc : forRule.getRuleToColumns()) {
			if (rtc.getFunction().equals("A")) {
				colA = rtc.getDatabaseColumn().getName();
			}
			
			if (rtc.getFunction().equals("B")) {
				colB = rtc.getDatabaseColumn().getName();
			}
		}
		
		data.put("column1", colA);
		data.put("column2", colB);
		data.put("operand", getOperandSQL(forRule.getOperator()));
		
		return fms.processTemplate("oracle/TCMPRule.ftl", data);
	}

	@Override
	public String generateTOTHRule(BRGBusinessRule forRule) {
		Map<String, Object> data = new HashMap<String, Object>();
		
		data.put("query", DomainUtils.getFirstValueFromBusinessRule(forRule));
		
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
		
		data.put("query", DomainUtils.getFirstValueFromBusinessRule(forRule));
		
		return fms.processTemplate("oracle/EOTHRule.ftl", data);
	}

	@Override
	public String generateMODIRule(BRGBusinessRule forRule) {
		// TODO: Implement this.
		return "";
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
