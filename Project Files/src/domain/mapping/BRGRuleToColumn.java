package domain.mapping;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import domain.businessrule.BRGBusinessRule;
import domain.database.BRGColumn;

@Entity
@Table(name = "BRG_RuleToColumn")
public class BRGRuleToColumn {
	private BRGColumn column;
	private Long id;
	private BRGBusinessRule rule;
	private String function;

	// constructors
	public BRGRuleToColumn() {
	}

	public BRGRuleToColumn(domain.database.BRGColumn column, String function) {
		this.column = column;
		this.function = function;
	}

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	public domain.database.BRGColumn getColumn() {
		return column;
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

	@Column(nullable = false)
	public String getFunction() {
		return function;
	}

	public void setColumn(domain.database.BRGColumn column) {
		this.column = column;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setRule(BRGBusinessRule rule) {
		this.rule = rule;
	}

	public void setFunction(String function) {
		this.function = function;
	}

}