package hu.brg.domain.businessrule;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BRG_BusinessRuleValues")
public class BRGBusinessRuleValue {
	private Long id;
	private String value;
	private BRGBusinessRule businessRule;
	
	public BRGBusinessRuleValue() {}
	
	public BRGBusinessRuleValue(Long id, String value,
			BRGBusinessRule businessRule) {
		this.id = id;
		this.value = value;
		this.businessRule = businessRule;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return this.id;
	}

	@Column(nullable = false)
	public String getValue() {
		return this.value;
	}

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	public BRGBusinessRule getBusinessRule() {
		return this.businessRule;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setBusinessRule(BRGBusinessRule businessRule) {
		this.businessRule = businessRule;
	}
	
	
}
