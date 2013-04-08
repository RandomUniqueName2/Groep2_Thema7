package hu.brg.implementor.generator.strategies.oracle;

import hu.brg.domain.DomainUtils;
import hu.brg.domain.businessrule.BRGBusinessRule;
import hu.brg.implementor.generator.RuleGenerator;

import java.util.HashMap;
import java.util.Map;

public class OracleRuleGenerator extends RuleGenerator {

	@Override
	public String generateACMPRule(BRGBusinessRule forRule) {
		Map<String, String> data = new HashMap<String, String>();
		
		data.put("column1", DomainUtils.getFirstColumnFromBusinessRule(forRule).getName());
		data.put("value", DomainUtils.getFirstValueFromBusinessRule(forRule).getValue());
		data.put("operand", getOperandSQL(forRule.getOperator()));
		
		return fms.processTemplate("oracle/ACMPRule.ftl", data);
	}

	@Override
	public String generateARNGRule(BRGBusinessRule forRule) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateALISRule(BRGBusinessRule forRule) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateAOTHRule(BRGBusinessRule forRule) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateTCMPRule(BRGBusinessRule forRule) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateTOTHRule(BRGBusinessRule forRule) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateICMPRule(BRGBusinessRule forRule) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateEOTHRule(BRGBusinessRule forRule) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateMODIRule(BRGBusinessRule forRule) {
		// TODO Auto-generated method stub
		return null;
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
