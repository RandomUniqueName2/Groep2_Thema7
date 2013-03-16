package data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="BRG_Column")
public class BRGColumn {
	private int id;
	private String name;
	private BRGTable table;

	// constructors
	public BRGColumn() {}

	public BRGColumn(String name, BRGTable table) {
		this.name = name;
		this.table = table;
	}

	// getters and setters
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

	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	public BRGTable getTable() {
		return table;
	}

	public void setTable(BRGTable table) {
		this.table = table;
	}

}
