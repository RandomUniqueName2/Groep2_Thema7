package hu.brg.domain;

import hu.brg.domain.businessrule.BRGBusinessRule;
import hu.brg.domain.businessrule.BRGBusinessRuleCategory;
import hu.brg.domain.businessrule.BRGBusinessRuleType;
import hu.brg.domain.businessrule.BRGBusinessRuleValue;
import hu.brg.domain.database.BRGColumn;
import hu.brg.domain.database.BRGDatabase;
import hu.brg.domain.database.BRGSchema;
import hu.brg.domain.database.BRGTable;
import hu.brg.domain.mapping.BRGRuleToColumn;
import hu.brg.domain.mapping.BRGRuleToTable;
import hu.brg.hibernate.HibernateService;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;


public class DomainService {
	private static final HibernateService hbnService = new HibernateService();
	
	private List<BRGBusinessRule> allBusinessRules;
	private List<BRGBusinessRuleType> allBusinessRuleTypes;
	private List<BRGDatabase> allDatabases;
	
	public static void Init() {
		MapDomain();
	}
	
	private static void MapDomain() {
		Collection<Class<?>> toMap = new HashSet<Class<?>>();

		toMap.add(BRGDatabase.class);
		toMap.add(BRGSchema.class);
		toMap.add(BRGTable.class);
		toMap.add(BRGColumn.class);

		toMap.add(BRGBusinessRuleType.class);
		toMap.add(BRGBusinessRule.class);
		toMap.add(BRGBusinessRuleCategory.class);
		toMap.add(BRGBusinessRuleValue.class);

		toMap.add(BRGRuleToColumn.class);
		toMap.add(BRGRuleToTable.class);

		hbnService.mapClassCollection(toMap);
	}
	
	@SuppressWarnings("unchecked")
	public List<BRGBusinessRule> getAllBusinessRules() {
		this.allBusinessRules = (List<BRGBusinessRule>)hbnService.getAllFromEntity(BRGBusinessRule.class);
		return this.allBusinessRules;
	}
	
	@SuppressWarnings("unchecked")
	public List<BRGDatabase> getAllDatabases() {
		this.allDatabases = (List<BRGDatabase>)hbnService.getAllFromEntity(BRGDatabase.class);
		return this.allDatabases;
	}
	
	@SuppressWarnings("unchecked")
	public List<BRGBusinessRuleType> getAllBusinessRuleTypes() {
		this.allBusinessRuleTypes = (List<BRGBusinessRuleType>)hbnService.getAllFromEntity(BRGBusinessRuleType.class);
		return this.allBusinessRuleTypes;
	}
	
	public void persistAllBusinessRules() {
		hbnService.persistEntityCollection(this.allBusinessRules);
	}
	
	public void persistBusinessRules(Collection<BRGBusinessRule> rules) {
		hbnService.persistEntityCollection(rules);
	}
	
	public void connectToRepository(String connectionString, String username, String password) throws Exception {
		hbnService.connect(connectionString, username, password);
	}
}
