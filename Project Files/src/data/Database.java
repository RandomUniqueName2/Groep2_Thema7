package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Database {
	private int id;


	private String connectionString, databaseProvider;

	// constructors
	public Database() {	}

	public Database(String connectionString, String databaseProvider) {
		this.connectionString = connectionString;
		this.databaseProvider = databaseProvider;
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
