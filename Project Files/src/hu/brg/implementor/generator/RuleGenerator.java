package hu.brg.implementor.generator;

import hu.brg.implementor.generator.freemarker.FreemarkerService;


public abstract class RuleGenerator implements iRuleGenerator {
	protected final FreemarkerService fms = new FreemarkerService();
}
