package hu.brg.domain.mapping;

import hu.brg.domain.businessrule.BRGBusinessRule;
import hu.brg.domain.database.BRGColumn;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "BRG_RuleToColumn")
public class BRGRuleToColumn {
	private Long id;
	private String function;
	private BRGBusinessRule businessRule;
	private BRGColumn databaseColumn;
	
	public BRGRuleToColumn() {}
	
	public BRGRuleToColumn(Long id, String function,
			BRGBusinessRule businessRule, BRGColumn databaseColumn) {
		this.id = id;
		this.function = function;
		this.businessRule = businessRule;
		this.databaseColumn = databaseColumn;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return this.id;
	}

	public String getFunction() {
		return this.function;
	}

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "rule_id")
	public BRGBusinessRule getBusinessRule() {
		return this.businessRule;
	}

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "column_id")
	public BRGColumn getDatabaseColumn() {
		return this.databaseColumn;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public void setBusinessRule(BRGBusinessRule businessRule) {
		this.businessRule = businessRule;
	}

	public void setDatabaseColumn(BRGColumn databaseColumn) {
		this.databaseColumn = databaseColumn;
	}
	
	
}
