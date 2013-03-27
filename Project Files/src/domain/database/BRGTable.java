package domain.database;

import java.util.HashSet;
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
@Table(name = "BRG_Table")
public class BRGTable {
	private Set<BRGColumn> columns;
	private long id;
	private String name;
	private BRGSchema schema;

	// constructors
	public BRGTable() {
		this.columns = new HashSet<BRGColumn>();
	}

	public BRGTable(String name, BRGSchema schema) {
		this.name = name;
		this.schema = schema;
		this.columns = new HashSet<BRGColumn>();
	}

	@OneToMany(targetEntity = BRGSchema.class, mappedBy = "database", fetch = FetchType.EAGER)
	public Set<BRGColumn> getColumns() {
		return columns;
	}

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	@Column(nullable = false)
	public String getName() {
		return name;
	}

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	public BRGSchema getSchema() {
		return schema;
	}

	public void setColumns(Set<BRGColumn> columns) {
		this.columns = columns;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSchema(BRGSchema schema) {
		this.schema = schema;
	}

}
