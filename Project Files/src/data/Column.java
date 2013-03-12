package data;

public class Column {
	private String name;
	private Table table;

	// constructors
	public Column() {

	}

	public Column(String name, Table table) {
		this.name = name;
		this.table = table;
	}

	// getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

}
