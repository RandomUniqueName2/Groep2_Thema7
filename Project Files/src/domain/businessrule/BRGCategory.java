package domain.businessrule;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BRG_Category")
public class BRGCategory {
	public static final String STATIC = "STATIC";
	public static final String DYNAMIC = "DYNAMIC";

	private int id;
	private String name;

	public BRGCategory() {

	}

	public BRGCategory(String name) {
		this.name = name;
	}

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

}
