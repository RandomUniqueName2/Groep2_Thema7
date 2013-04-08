package hu.brg.implementor.generator;

import hu.brg.domain.database.BRGTable;

public interface iTableGenerator {
	public abstract String generateRulesForTable(BRGTable forTable);
}

