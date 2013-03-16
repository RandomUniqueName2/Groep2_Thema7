package domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import data.BRGTable;

@Entity
@Table(name="BRG_RuleToTable")
public class BRGRuleToTable {
	private BRGTable table;
	private BRGBusinessRule rule;

	// constructors
	public BRGRuleToTable() { }

	public BRGRuleToTable(BRGTable table, BRGBusinessRule rule) {
		this.table = table;
		this.rule = rule;
	}

	// getters and setters
	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	public BRGBusinessRule getRule() {
		return rule;
	}

	public void setRule(BRGBusinessRule rule) {
		this.rule = rule;
	}

	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	public BRGTable getTable() {
		return table;
	}

	public void setTable(BRGTable table) {
		this.table = table;
	}
}
