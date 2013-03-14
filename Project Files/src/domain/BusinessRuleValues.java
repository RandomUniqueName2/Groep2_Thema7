package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BusinessRuleValues {
	private int id;
	private String value;

	// constructors
	public BusinessRuleValues() { }

	public BusinessRuleValues(String value) {
		this.value = value;
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
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
