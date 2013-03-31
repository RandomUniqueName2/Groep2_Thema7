package hu.brg.domain.mapping;

import hu.brg.domain.businessrule.BRGBusinessRule;
import hu.brg.domain.database.BRGTable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "BRG_RuleToTable")
public class BRGRuleToTable {
	private Long id;
	private BRGBusinessRule businessRule;
	private BRGTable databaseTable;
	
	public BRGRuleToTable() {}
	
	public BRGRuleToTable(Long id, BRGBusinessRule businessRule, BRGTable databaseTable) {
		this.id = id;
		this.businessRule = businessRule;
		this.databaseTable = databaseTable;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return this.id;
	}

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "rule_id")
	public BRGBusinessRule getBusinessRule() {
		return this.businessRule;
	}

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "table_id")
	public BRGTable getDatabaseTable() {
		return this.databaseTable;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setBusinessRule(BRGBusinessRule businessRule) {
		this.businessRule = businessRule;
	}

	public void setDatabaseTable(BRGTable databaseTable) {
		this.databaseTable = databaseTable;
	}
}
