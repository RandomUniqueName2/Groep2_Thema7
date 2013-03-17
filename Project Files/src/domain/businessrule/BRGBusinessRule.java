package domain.businessrule;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import domain.mapping.BRGRuleToColumn;
import domain.mapping.BRGRuleToTable;

@Entity
@Table(name = "BRG_BusinessRule")
public class BRGBusinessRule {
	private BRGBusinessRuleType businessRuleType;
	private List<BRGBusinessRuleValue> businessRuleValues;
	private int id;
	private String name;
	private String operator;
	private Set<BRGRuleToColumn> ruleToColumn;
	private Set<BRGRuleToTable> ruleToTable;

	public BRGBusinessRule() {
		businessRuleValues = new ArrayList<BRGBusinessRuleValue>();
		ruleToTable = new HashSet<BRGRuleToTable>();
		ruleToColumn = new HashSet<BRGRuleToColumn>();
	}

	public BRGBusinessRule(String name, String operator) {
		businessRuleValues = new ArrayList<BRGBusinessRuleValue>();
		ruleToTable = new HashSet<BRGRuleToTable>();
		ruleToColumn = new HashSet<BRGRuleToColumn>();
		this.name = name;
		this.operator = operator;
	}

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	public BRGBusinessRuleType getBusinessRuleType() {
		return businessRuleType;
	}

	@OneToMany(targetEntity = BRGBusinessRuleValue.class, mappedBy = "businessRule", fetch = FetchType.EAGER)
	public List<BRGBusinessRuleValue> getBusinessRuleValues() {
		return businessRuleValues;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	@Column(nullable = false)
	public String getName() {
		return name;
	}

	@Column(nullable = false)
	public String getOperator() {
		return operator;
	}

	@OneToMany(targetEntity = BRGRuleToColumn.class, mappedBy = "rule", fetch = FetchType.EAGER)
	public Set<BRGRuleToColumn> getRuleToColumn() {
		return ruleToColumn;
	}

	@OneToMany(targetEntity = BRGRuleToTable.class, mappedBy = "rule", fetch = FetchType.EAGER)
	public Set<BRGRuleToTable> getRuleToTable() {
		return ruleToTable;
	}

	public void setBusinessRuleType(BRGBusinessRuleType businessRuleType) {
		this.businessRuleType = businessRuleType;
	}

	public void setBusinessRuleValues(
			List<BRGBusinessRuleValue> businessRuleValues) {
		this.businessRuleValues = businessRuleValues;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public void setRuleToColumn(Set<BRGRuleToColumn> ruleToColumn) {
		this.ruleToColumn = ruleToColumn;
	}

	public void setRuleToTable(Set<BRGRuleToTable> ruleToTable) {
		this.ruleToTable = ruleToTable;
	}
}
