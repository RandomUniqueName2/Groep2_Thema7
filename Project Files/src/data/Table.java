package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Table {
	private int id;
	private String name;
	private View view;

	// constructors
	public Table() {}

	public Table(String name, View view) {
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
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToOne
	public View getView() {
		return view;
	}

	public void setView(View view) {
		this.view = view;
	}

}
