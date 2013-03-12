package domain;

public class BusinessRuleType {
	private String name, code, description;
	private Category category;

	// constructors
	public BusinessRuleType() {

	}

	public BusinessRuleType(String name, String code, String description,
			Category category) {
		this.name = name;
		this.code = code;
		this.description = description;
		this.category = category;
	}

	// getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
