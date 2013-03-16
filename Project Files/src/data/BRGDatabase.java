package data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BRG_Database")
public class BRGDatabase {
	private int id;


	private String connectionString, databaseProvider;

	// constructors
	public BRGDatabase() {	}

	public BRGDatabase(String connectionString, String databaseProvider) {
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
	
	@Column(nullable = false)
	public String getConnectionString() {
		return connectionString;
	}

	public void setConnectionString(String connectionString) {
		this.connectionString = connectionString;
	}

	@Column(nullable = false)
	public String getDatabaseProvider() {
		return databaseProvider;
	}

	public void setDatabaseProvider(String databaseProvider) {
		this.databaseProvider = databaseProvider;
	}

}
