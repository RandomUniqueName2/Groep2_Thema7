package domain.businessrule;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BRG_BusinessRuleValues")
public class BRGBusinessRuleValue {
	private int id;
	private String value;
	private BRGBusinessRule businessRule;

	// constructors
	public BRGBusinessRuleValue() {
	}

	public BRGBusinessRuleValue(String value) {
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

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	public BRGBusinessRule getBusinessRule() {
		return businessRule;
	}

	public void setBusinessRule(BRGBusinessRule businessRule) {
		this.businessRule = businessRule;
	}
}
