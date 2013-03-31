package hu.brg.domain.businessrule;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BRG_Category")
public class BRGBusinessRuleCategory {
	private Long id;
	private String name;
	
	public BRGBusinessRuleCategory() {}
	
	public BRGBusinessRuleCategory(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	@Id
	@GeneratedValue
	public Long getId() {
		return this.id;
	}

	@Column(nullable = false)
	public String getName() {
		return this.name;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
}
