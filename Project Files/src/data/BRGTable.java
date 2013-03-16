package data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="BRG_Table")
public class BRGTable {
	private int id;
	private String name;
	private BRGView view;

	// constructors
	public BRGTable() {}

	public BRGTable(String name, BRGView view) {
		this.name = name;
		this.view = view;
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
	public BRGView getView() {
		return view;
	}

	public void setView(BRGView view) {
		this.view = view;
	}

}
