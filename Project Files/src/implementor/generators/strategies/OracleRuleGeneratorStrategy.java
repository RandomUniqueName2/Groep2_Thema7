package implementor.generators.strategies;

import implementor.generators.RuleGenerator;
import implementor.generators.iRuleGenerator;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import domain.businessrule.BRGBusinessRule;
import domain.database.BRGTable;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class OracleRuleGeneratorStrategy extends RuleGenerator implements
		iRuleGenerator {

	public OracleRuleGeneratorStrategy() {
		super();
	}

	@Override
	public String generatePreTriggerWrapper(BRGTable forTable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generatePostTriggerWrapper(BRGTable forTable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateACMPRule(BRGBusinessRule forRule) {
		Template tpl = getTemplateFromResources("oracle/ACMPRule.ftl");
		Writer tplWriter = new StringWriter();

		try {
			tpl.process(getACMPMappings(forRule), tplWriter);
		} catch (TemplateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tplWriter.toString();
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
