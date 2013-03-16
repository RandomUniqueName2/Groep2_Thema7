package data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="BRG_View")
public class BRGView {
	private int id;
	private String name;
	private BRGDatabase database;

	// constructors
	public BRGView() { }

	public BRGView(String name, BRGDatabase database) {
		this.name = name;
		this.database = database;
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
	public BRGDatabase getDatabase() {
		return database;
	}

	public void setDatabase(BRGDatabase database) {
		this.database = database;
	}

}
