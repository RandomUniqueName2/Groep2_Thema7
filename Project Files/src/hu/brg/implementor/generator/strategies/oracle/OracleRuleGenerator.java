package hu.brg.implementor.generator.strategies.oracle;

import hu.brg.domain.businessrule.BRGBusinessRule;
import hu.brg.implementor.generator.RuleGenerator;

import java.util.HashMap;
import java.util.Map;

public class OracleRuleGenerator extends RuleGenerator {

	@Override
	public String generateACMPRule(BRGBusinessRule forRule) {
		Map<String, String> data = new HashMap<String, String>();
		
		
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

}
