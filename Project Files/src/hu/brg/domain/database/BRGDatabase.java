package hu.brg.domain.database;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "BRG_Database")
public class BRGDatabase {
	private Long id;
	private String connectionString;
	private String databaseProvider;
	private Set<BRGSchema> schemas;
	
	public BRGDatabase() {}
	
	public BRGDatabase(Long id, String connectionString,
			String databaseProvider, Set<BRGSchema> schemas) {
		this.id = id;
		this.connectionString = connectionString;
		this.databaseProvider = databaseProvider;
		this.schemas = schemas;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return this.id;
	}

	@Column(nullable = false)
	public String getConnectionString() {
		return this.connectionString;
	}

	@Column(nullable = false)
	public String getDatabaseProvider() {
		return this.databaseProvider;
	}

	@OneToMany(targetEntity = BRGSchema.class, mappedBy = "database")
	@LazyCollection(LazyCollectionOption.FALSE)
	public Set<BRGSchema> getSchemas() {
		return this.schemas;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setConnectionString(String connectionString) {
		this.connectionString = connectionString;
	}

	public void setDatabaseProvider(String databaseProvider) {
		this.databaseProvider = databaseProvider;
	}

	public void setSchemas(Set<BRGSchema> schemas) {
		this.schemas = schemas;
	}
}
