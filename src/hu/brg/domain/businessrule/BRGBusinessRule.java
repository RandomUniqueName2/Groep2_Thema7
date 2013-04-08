package hu.brg.domain.businessrule;

import hu.brg.domain.mapping.BRGRuleToColumn;
import hu.brg.domain.mapping.BRGRuleToTable;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


@Entity
@Table(name = "BRG_BusinessRule")
public class BRGBusinessRule {
	private Long id;
	private String name;
	private String operator;
	private Boolean implemented; 
	private BRGBusinessRuleType businessRuleType;
	
	private Set<BRGBusinessRuleValue> values = new HashSet<BRGBusinessRuleValue>();
	private Set<BRGRuleToTable> ruleToTables = new HashSet<BRGRuleToTable>();
	private Set<BRGRuleToColumn> ruleToColumns = new HashSet<BRGRuleToColumn>();
	
	public BRGBusinessRule() {}
	
	public BRGBusinessRule(Long id, String name,
			String operator, Boolean implemented,
			BRGBusinessRuleType type, Set<BRGBusinessRuleValue> values,
			Set<BRGRuleToTable> tables, Set<BRGRuleToColumn> columns) {
		this.id = id;
		this.name = name;
		this.operator = operator;
		this.implemented = implemented;
		this.businessRuleType = type;
		this.values = values;
		this.ruleToTables = tables;
		this.ruleToColumns = columns;
	}
	
	@Id
	@GeneratedValue
	public Long getId() {
		return this.id;
	}

	@Column(nullable = false)
	public String getName() {
		return this.name;
	}
	
	public String getOperator() {
		return this.operator;
	}

	@Column(nullable = false)
	public Boolean isImplemented() {
		return this.implemented;
	}

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	public BRGBusinessRuleType getBusinessRuleType() {
		return this.businessRuleType;
	}

	@OneToMany(targetEntity = BRGBusinessRuleValue.class, mappedBy = "businessRule")
	@LazyCollection(LazyCollectionOption.FALSE)
	public Set<BRGBusinessRuleValue> getValues() {
		return this.values;
	}

	@OneToMany(targetEntity = BRGRuleToTable.class, mappedBy = "businessRule")
	@LazyCollection(LazyCollectionOption.FALSE)
	public Set<BRGRuleToTable> getRuleToTables() {
		return this.ruleToTables;
	}
	
	@OneToMany(targetEntity = BRGRuleToColumn.class, mappedBy = "businessRule")
	@LazyCollection(LazyCollectionOption.FALSE)
	public Set<BRGRuleToColumn> getRuleToColumns() {
		return this.ruleToColumns;
	}
		
	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public void setImplemented(Boolean implemented) {
		this.implemented = implemented;
	}

	public void setBusinessRuleType(BRGBusinessRuleType type) {
		this.businessRuleType = type;
	}

	public void setValues(Set<BRGBusinessRuleValue> values) {
		this.values = values;
	}

	public void setRuleToTables(Set<BRGRuleToTable> tables) {
		this.ruleToTables = tables;
	}

	public void setRuleToColumns(Set<BRGRuleToColumn> columns) {
		this.ruleToColumns = columns;
	}
}
