package hu.brg.domain.database;

import hu.brg.domain.mapping.BRGRuleToColumn;

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
@Table(name = "BRG_Column")
public class BRGColumn {
	private Long id;
	private String name;
	private BRGTable table;
	
	private Set<BRGRuleToColumn> ruleToColumns = new HashSet<BRGRuleToColumn>();
	
	public BRGColumn() {}
	
	public BRGColumn(Long id, String name, BRGTable table) {
		this.id = id;
		this.name = name;
		this.table = table;
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

	@OneToMany(targetEntity = BRGRuleToColumn.class, mappedBy = "column")
	@LazyCollection(LazyCollectionOption.FALSE)
	public Set<BRGRuleToColumn> getRuleToColumns() {
		return this.ruleToColumns;
	}

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	public BRGTable getTable() {
		return this.table;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRuleToColumns(Set<BRGRuleToColumn> ruleToColumns) {
		this.ruleToColumns = ruleToColumns;
	}

	public void setTable(BRGTable table) {
		this.table = table;
	}
}
