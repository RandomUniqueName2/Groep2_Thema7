package domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import data.Table;

public class RuleToTable {
	private int id;
	private Table table;
	private BusinessRule rule;
	private String type;

	// constructors
	public RuleToTable() { }

	public RuleToTable(Table table, String type) {
		this.table = table;
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
	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
