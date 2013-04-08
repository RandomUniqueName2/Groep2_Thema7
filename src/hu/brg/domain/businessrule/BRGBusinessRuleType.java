package hu.brg.domain.businessrule;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BRG_BusinessRuleType")
public class BRGBusinessRuleType {
	private Long id;
	private String name;
	private String code;
	private BRGBusinessRuleCategory category;
	
	public BRGBusinessRuleType() {}
	
	public BRGBusinessRuleType(Long id, String name, String code,
			BRGBusinessRuleCategory category) {
		this.id = id;
		this.name = name;
		this.code = code;
		this.category = category;
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

	@Column(nullable = false)
	public String getCode() {
		return this.code;
	}

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	public BRGBusinessRuleCategory getCategory() {
		return this.category;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setCategory(BRGBusinessRuleCategory category) {
		this.category = category;
	}	
}
