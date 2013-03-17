package domain.mapping;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import domain.businessrule.BRGBusinessRule;
import domain.database.BRGTable;

@Entity
@Table(name = "BRG_RuleToTable")
public class BRGRuleToTable {
	private Long id;
	private BRGBusinessRule rule;
	private BRGTable table;

	public BRGRuleToTable() {
	}

	public BRGRuleToTable(BRGTable table, BRGBusinessRule rule) {
		this.table = table;
		this.rule = rule;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	// getters and setters
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	public BRGBusinessRule getRule() {
		return rule;
	}

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	public BRGTable getTable() {
		return table;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setRule(BRGBusinessRule rule) {
		this.rule = rule;
	}

	public void setTable(BRGTable table) {
		this.table = table;
	}
}
