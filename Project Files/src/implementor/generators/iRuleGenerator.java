package implementor.generators;

import domain.businessrule.BRGBusinessRule;
import domain.database.BRGTable;

public interface iRuleGenerator {
	public String generatePreTriggerWrapper(BRGTable forTable);

	public String generatePostTriggerWrapper(BRGTable forTable);

	public String generateACMPRule(BRGBusinessRule forRule);

	public String generateARNGRule(BRGBusinessRule forRule);

	public String generateALISRule(BRGBusinessRule forRule);

	public String generateAOTHRule(BRGBusinessRule forRule);

	public String generateTCMPRule(BRGBusinessRule forRule);

	public String generateTOTHRule(BRGBusinessRule forRule);

	public String generateICMPRule(BRGBusinessRule forRule);

	public String generateEOTHRule(BRGBusinessRule forRule);

	public String generateMODIRule(BRGBusinessRule forRule);
}
