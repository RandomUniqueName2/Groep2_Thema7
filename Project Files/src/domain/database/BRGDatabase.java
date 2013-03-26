package domain.database;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "BRG_Database")
public class BRGDatabase {
	private String connectionString;
	private String databaseProvider;
	private long id;
	private Set<BRGScheme> views;

	public BRGDatabase() {
		this.views = new HashSet<BRGScheme>();
	}

	public BRGDatabase(String connectionString, String databaseProvider) {
		this.connectionString = connectionString;
		this.databaseProvider = databaseProvider;
		this.views = new HashSet<BRGScheme>();
	}

	@Column(nullable = false)
	public String getConnectionString() {
		return connectionString;
	}

	@Column(nullable = false)
	public String getDatabaseProvider() {
		return databaseProvider;
	}

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	@OneToMany(targetEntity = BRGScheme.class, mappedBy = "database", fetch = FetchType.EAGER)
	public Set<BRGScheme> getViews() {
		return views;
	}

	public void setConnectionString(String connectionString) {
		this.connectionString = connectionString;
	}

	public void setDatabaseProvider(String databaseProvider) {
		this.databaseProvider = databaseProvider;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setViews(Set<BRGScheme> views) {
		this.views = views;
	}
}
