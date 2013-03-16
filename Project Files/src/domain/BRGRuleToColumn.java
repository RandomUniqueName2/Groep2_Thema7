package domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import data.BRGColumn;

@Entity
@Table(name="BRG_RuleToColumn")
public class BRGRuleToColumn {
	private BRGColumn column;
	private BRGBusinessRule rule;
	private String type;

	// constructors
	public BRGRuleToColumn() { }

	public BRGRuleToColumn(data.BRGColumn column, String type) {
		this.column = column;
		this.type = type;
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
	public data.BRGColumn getColumn() {
		return column;
	}
	
	public void setColumn(data.BRGColumn column) {
		this.column = column;
	}
	
	@Column(nullable = false)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}