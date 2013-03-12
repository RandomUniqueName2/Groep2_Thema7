package domain;

import java.util.ArrayList;

public class BusinessRule {
	private String name, operator;
	private BusinessRuleType businessRuleType;
	private ArrayList<BusinessRuleValues> businessRuleValues;
	private ArrayList<RuleToTable> ruleToTable;
	private ArrayList<RuleToColumn> ruleToColumn;

	// contructors
	public BusinessRule() {
		businessRuleValues = new ArrayList<BusinessRuleValues>();
		ruleToTable = new ArrayList<RuleToTable>();
		ruleToColumn = new ArrayList<RuleToColumn>();
	}

	public BusinessRule(String name, String operator) {
		businessRuleValues = new ArrayList<BusinessRuleValues>();
		ruleToTable = new ArrayList<RuleToTable>();
		ruleToColumn = new ArrayList<RuleToColumn>();
		this.name = name;
		this.operator = operator;
	}

	// getters and setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public BusinessRuleType getBusinessRuleType() {
		return businessRuleType;
	}

	public void setBusinessRuleType(BusinessRuleType businessRuleType) {
		this.businessRuleType = businessRuleType;
	}

	public ArrayList<BusinessRuleValues> getBusinessRuleValues() {
		return businessRuleValues;
	}

	public void addBusinessRuleValues(BusinessRuleValues businessRuleValues) {
		this.businessRuleValues.add(businessRuleValues);
	}

	public ArrayList<RuleToTable> getRuleToTable() {
		return ruleToTable;
	}

	public void addRuleToTable(RuleToTable ruleToTable) {
		this.ruleToTable.add(ruleToTable);
	}

	public ArrayList<RuleToColumn> getRuleToColumn() {
		return ruleToColumn;
	}

	public void addRuleToColumn(RuleToColumn ruleToColumn) {
		this.ruleToColumn.add(ruleToColumn);
	}

}
