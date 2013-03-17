package domain.database;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BRG_Column")
public class BRGColumn {
	private long id;
	private String name;
	private BRGTable table;

	public BRGColumn() {
	}

	public BRGColumn(String name, BRGTable table) {
		this.name = name;
		this.table = table;
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
	public BRGTable getTable() {
		return table;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTable(BRGTable table) {
		this.table = table;
	}
}
