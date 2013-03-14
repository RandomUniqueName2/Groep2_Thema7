package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Column {
	private int id;
	private String name;
	private Table table;

	// constructors
	public Column() {}

	public Column(String name, Table table) {
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
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToOne
	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

}
