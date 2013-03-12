package data;

public class Database {
	private String connectionString, databaseProvider;

	// constructors
	public Database() {

	}

	public Database(String connectionString, String databaseProvider) {
		this.connectionString = connectionString;
		this.databaseProvider = databaseProvider;
	}

	// getters and setters
	public String getConnectionString() {
		return connectionString;
	}

	public void setConnectionString(String connectionString) {
		this.connectionString = connectionString;
	}

	public String getDatabaseProvider() {
		return databaseProvider;
	}

	public void setDatabaseProvider(String databaseProvider) {
		this.databaseProvider = databaseProvider;
	}

}
