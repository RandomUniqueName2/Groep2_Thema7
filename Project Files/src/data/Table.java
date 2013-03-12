package data;

public class Table {
	private String name;
	private View view;

	// constructors
	public Table() {

	}

	public Table(String name, View view) {
		this.name = name;
		this.view = view;
	}

	// getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public View getView() {
		return view;
	}

	public void setView(View view) {
		this.view = view;
	}

}
