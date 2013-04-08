package hu.brg.domain.database;

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
@Table(name = "BRG_Table")
public class BRGTable {
	private Long id;
	private String name;
	private BRGSchema schema;
	
	private Set<BRGColumn> columns;
	
	private Set<BRGRuleToTable> ruleToTables = new HashSet<BRGRuleToTable>();

	public BRGTable() {}
	
	public BRGTable(Long id, String name, BRGSchema schema,
			Set<BRGColumn> columns) {
		this.id = id;
		this.name = name;
		this.schema = schema;
		this.columns = columns;
	}

	@OneToMany(targetEntity = BRGColumn.class, mappedBy = "table")
	@LazyCollection(LazyCollectionOption.FALSE)
	public Set<BRGColumn> getColumns() {
		return this.columns;
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

	@OneToMany(targetEntity = BRGRuleToTable.class, mappedBy = "databaseTable")
	@LazyCollection(LazyCollectionOption.FALSE)
	public Set<BRGRuleToTable> getRuleToTables() {
		return this.ruleToTables;
	}

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	public BRGSchema getSchema() {
		return this.schema;
	}

	public void setColumns(Set<BRGColumn> columns) {
		this.columns = columns;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRuleToTables(Set<BRGRuleToTable> ruleToTables) {
		this.ruleToTables = ruleToTables;
	}

	public void setSchema(BRGSchema schema) {
		this.schema = schema;
	}
}
