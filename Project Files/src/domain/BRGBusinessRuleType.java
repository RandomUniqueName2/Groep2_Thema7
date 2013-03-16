package domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="BRG_BusinessRuleType")
public class BRGBusinessRuleType {
	private int id;
	private String name, code, description;
	private BRGCategory category;

	// constructors
	public BRGBusinessRuleType() { }

	public BRGBusinessRuleType(String name, String code, String description,
			BRGCategory category) {
		this.name = name;
		this.code = code;
		this.description = description;
		this.category = category;
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

	@Column(nullable = false)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(nullable = false)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	public BRGCategory getCategory() {
		return category;
	}

	public void setCategory(BRGCategory category) {
		this.category = category;
	}
}
