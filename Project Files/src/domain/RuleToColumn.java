package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import data.Column;

@Entity
public class RuleToColumn {
	private int id;
	private Column column;
	private BusinessRule rule;
	private String type;

	// constructors
	public RuleToColumn() { }

	public RuleToColumn(data.Column column, String type) {
		this.column = column;
		this.type = type;
	}

	// getters and setters
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@OneToOne
	public BusinessRule getRule() {
		return rule;
	}

	public void setRule(BusinessRule rule) {
		this.rule = rule;
	}

	@OneToOne
	public data.Column getColumn() {
		return column;
	}

	public void setColumn(data.Column column) {
		this.column = column;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}