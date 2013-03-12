package domain;

public class RuleToColumn {
	private data.Column column;
	private String type;

	// constructors
	public RuleToColumn() {

	}

	public RuleToColumn(data.Column column, String type) {
		this.column = column;
		this.type = type;
	}

	// getters and setters
	public data.Column getColumn() {
		return column;
	}

	public void setColumn(data.Column column) {
		this.column = column;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}