package hu.brg.implementor.generator;

import hu.brg.domain.businessrule.BRGBusinessRule;

public interface iRuleGenerator {
	public String generateACMPRule(BRGBusinessRule forRule);
	public String generateARNGRule(BRGBusinessRule forRule);
	public String generateALISRule(BRGBusinessRule forRule);
	public String generateAOTHRule(BRGBusinessRule forRule);
	public String generateTCMPRule(BRGBusinessRule forRule);
	public String generateTOTHRule(BRGBusinessRule forRule);
	public String generateICMPRule(BRGBusinessRule forRule);
	public String generateEOTHRule(BRGBusinessRule forRule);
	public String generateMODIRule(BRGBusinessRule forRule);
	
	public String getOperandSQL(String operand);
}
