package implementor.generators;

import implementor.generators.strategies.OracleRuleGeneratorStrategy;

public class RuleGenerator {
	private RuleGenerator() {
	}

	public static iRuleGenerator fromStrategy(RuleGeneratorStrategy strategy)
			throws Exception {
		switch (strategy) {
		case ORACLE:
			return new OracleRuleGeneratorStrategy();
		default:
			throw new Exception("Chosen strategy is not implemented");
		}
	}
}
