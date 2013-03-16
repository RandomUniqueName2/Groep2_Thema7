package domain;

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

@Entity
@Table(name="BRG_BusinessRule")
public class BRGBusinessRule {
	private int id;
	private String name, operator;
	private BRGBusinessRuleType businessRuleType;
	private List<BRGBusinessRuleValue> businessRuleValues;
	private Set<BRGRuleToTable> ruleToTable;
	private Set<BRGRuleToColumn> ruleToColumn;

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

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(nullable = false)
	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	public BRGBusinessRuleType getBusinessRuleType() {
		return businessRuleType;
	}

	public void setBusinessRuleType(BRGBusinessRuleType businessRuleType) {
		this.businessRuleType = businessRuleType;
	}
	

	@OneToMany(targetEntity=BRGBusinessRuleValue.class, mappedBy="businessRule", fetch=FetchType.EAGER)
	public List<BRGBusinessRuleValue> getBusinessRuleValues() {
		return businessRuleValues;
	}

	public void setBusinessRuleValues(List<BRGBusinessRuleValue> businessRuleValues) {
		this.businessRuleValues = businessRuleValues;
	}

	@OneToMany(targetEntity=BRGRuleToTable.class, mappedBy="rule", fetch=FetchType.EAGER)
	public Set<BRGRuleToTable> getRuleToTable() {
		return ruleToTable;
	}

	public void setRuleToTable(Set<BRGRuleToTable> ruleToTable) {
		this.ruleToTable = ruleToTable;
	}

	@OneToMany(targetEntity=BRGRuleToColumn.class, mappedBy="rule", fetch=FetchType.EAGER)
	public Set<BRGRuleToColumn> getRuleToColumn() {
		return ruleToColumn;
	}

	public void setRuleToColumn(Set<BRGRuleToColumn> ruleToColumn) {
		this.ruleToColumn = ruleToColumn;
	}
}
