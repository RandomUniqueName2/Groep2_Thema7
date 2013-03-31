package hu.brg.domain.database;

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
@Table(name = "BRG_Schema")
public class BRGSchema {
	private Long id;
	private String name;
	private BRGDatabase database;
	
	private Set<BRGTable> tables;

	public BRGSchema() {}
	
	public BRGSchema(Long id, String name, BRGDatabase database,
			Set<BRGTable> tables) {
		this.id = id;
		this.name = name;
		this.database = database;
		this.tables = tables;
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
	
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	public BRGDatabase getDatabase() {
		return this.database;
	}

	@OneToMany(targetEntity = BRGTable.class, mappedBy = "schema")
	@LazyCollection(LazyCollectionOption.FALSE)
	public Set<BRGTable> getTables() {
		return this.tables;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDatabase(BRGDatabase database) {
		this.database = database;
	}

	public void setTables(Set<BRGTable> tables) {
		this.tables = tables;
	}
}
