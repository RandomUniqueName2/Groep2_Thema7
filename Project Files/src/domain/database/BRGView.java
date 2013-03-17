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
@Table(name = "BRG_View")
public class BRGView {
	private BRGDatabase database;
	private long id;
	private String name;
	private Set<BRGTable> tables;

	public BRGView() {
		this.tables = new HashSet<BRGTable>();
	}

	public BRGView(String name, BRGDatabase database) {
		this.name = name;
		this.database = database;
		this.tables = new HashSet<BRGTable>();
	}

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	public BRGDatabase getDatabase() {
		return this.database;
	}

	@Id
	@GeneratedValue
	public long getId() {
		return this.id;
	}

	@Column(nullable = false)
	public String getName() {
		return this.name;
	}

	@OneToMany(targetEntity = BRGView.class, mappedBy = "database", fetch = FetchType.EAGER)
	public Set<BRGTable> getTables() {
		return tables;
	}

	public void setDatabase(BRGDatabase database) {
		this.database = database;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTables(Set<BRGTable> tables) {
		this.tables = tables;
	}
}
