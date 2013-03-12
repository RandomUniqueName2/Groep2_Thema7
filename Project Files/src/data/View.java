package data;

public class View {
	private String name;
	private Database database;

	// constructors
	public View() {

	}

	public View(String name, Database database) {
		this.name = name;
		this.database = database;
	}

	// getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Database getDatabase() {
		return database;
	}

	public void setDatabase(Database database) {
		this.database = database;
	}

}
