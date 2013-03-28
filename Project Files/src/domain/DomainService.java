package domain;

import hibernate.HibernateService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import domain.businessrule.BRGBusinessRule;
import domain.businessrule.BRGBusinessRuleType;
import domain.businessrule.BRGBusinessRuleValue;
import domain.businessrule.BRGCategory;
import domain.database.BRGColumn;
import domain.database.BRGDatabase;
import domain.database.BRGSchema;
import domain.database.BRGTable;
import domain.mapping.BRGRuleToColumn;
import domain.mapping.BRGRuleToTable;

public class DomainService {
	private static List<BRGDatabase> databases = null;
	private static List<BRGSchema> schemes = null;
	private static List<BRGTable> tables = null;
	private static List<BRGColumn> columns = null;

	private static List<BRGBusinessRuleType> ruletypes = null;
	private static List<BRGBusinessRule> rules = null;
	
	private static List<BRGCategory> categories = null;
	private static List<BRGBusinessRuleValue> values = null;
	
	public static void Init() {
		Set<Class<?>> toMap = new HashSet<Class<?>>();
		
		toMap.add(BRGDatabase.class);
		toMap.add(BRGSchema.class);
		toMap.add(BRGTable.class);
		toMap.add(BRGColumn.class);
		
		toMap.add(BRGBusinessRuleType.class);
		toMap.add(BRGBusinessRule.class);
		

		toMap.add(BRGCategory.class);
		toMap.add(BRGBusinessRuleValue.class);
		
		toMap.add(BRGRuleToColumn.class);
		toMap.add(BRGRuleToTable.class);
		
		HibernateService.mapClasses(toMap);
	}

	public static void createBaseRepository() {
		List<BRGCategory> cats = new ArrayList<BRGCategory>();
		List<BRGBusinessRuleType> types = new ArrayList<BRGBusinessRuleType>();

		BRGCategory staticCat = new BRGCategory(BRGCategory.STATIC);
		BRGCategory dynamicCat = new BRGCategory(BRGCategory.DYNAMIC);

		cats.add(staticCat);
		cats.add(dynamicCat);

		BRGBusinessRuleType[] _types = {
				new BRGBusinessRuleType("Attribute Range Rule",
						BRGBusinessRuleType.ARNG, "", staticCat),
				new BRGBusinessRuleType("Attribute Compare Rule",
						BRGBusinessRuleType.ACMP, "", staticCat),
				new BRGBusinessRuleType("Attribute List Rule",
						BRGBusinessRuleType.ALIS, "", staticCat),
				new BRGBusinessRuleType("Attribute Other Rule",
						BRGBusinessRuleType.AOTH, "", staticCat),
				new BRGBusinessRuleType("Tuple Compare Rule",
						BRGBusinessRuleType.TCMP, "", staticCat),
				new BRGBusinessRuleType("Tuple Other Rule",
						BRGBusinessRuleType.TOTH, "", staticCat),
				new BRGBusinessRuleType("Inter-Entity Compare Rule",
						BRGBusinessRuleType.ICMP, "", staticCat),
				new BRGBusinessRuleType("Enity Other Rule",
						BRGBusinessRuleType.EOTH, "", staticCat),
				new BRGBusinessRuleType("Modify Rule",
						BRGBusinessRuleType.MODI, "", dynamicCat) };

		for (BRGBusinessRuleType brt : _types) {
			types.add(brt);
		}

		DomainService.setAllRuletypes(types);
	}

	/*
	 * public static void scanTargetDBDomain(Session session, BRGDatabase db) {
	 * 
	 * SQLQuery schemaQuery = session.createSQLQuery("").addScalar("USERNAME",
	 * StringType.INSTANCE);
	 * 
	 * schemaQuery.list(); }
	 */

	/*
	 * public static void persistDomainToDB(Session session) { Transaction tx =
	 * session.beginTransaction();
	 * 
	 * if (DomainService.categories != null) { for (BRGCategory cat :
	 * DomainService.categories.values()) { session.persist(cat); } }
	 * 
	 * if (DomainService.ruletypes != null) { for (BRGBusinessRuleType brt :
	 * DomainService.ruletypes.values()) { session.persist(brt);
	 * 
	 * } }
	 * 
	 * // TODO: Persist other stuff
	 * 
	 * tx.commit(); }
	 */

	public static void getMockTargetDBDomain() {
		BRGDatabase db = new BRGDatabase(
				"jdbc:oracle:thin:@ondora01.hu.nl:8521/cursus01.hu.nl", "null");

		BRGSchema vw = new BRGSchema("THO7_2012_2B_TEAM2", db);

		BRGTable t1 = new BRGTable("Person", vw);
		BRGColumn t1c1 = new BRGColumn("name", t1);
		BRGColumn t1c2 = new BRGColumn("age", t1);

		BRGTable t2 = new BRGTable("Adress", vw);
		BRGColumn t2c1 = new BRGColumn("Street", t2);
	}

	public static List<BRGColumn> getAllColumns() {
		return columns;
	}

	public static void setAllColumns(List<BRGColumn> columns) {
		DomainService.columns = columns;
	}

	public static List<BRGSchema> getAllSchemes() {
		return schemes;
	}

	public static void setAllSchemes(List<BRGSchema> schemes) {
		DomainService.schemes = schemes;
	}

	public static List<BRGDatabase> getAllDatabases() {
		return databases;
	}

	public static void setAllDatabases(List<BRGDatabase> databases) {
		DomainService.databases = databases;
	}

	@SuppressWarnings("unchecked")
	public static List<BRGBusinessRule> getAllRules() {
		if(HibernateService.isConnected()){
			Session session = HibernateService.getSessionFactory().openSession();
			session.beginTransaction();
			 List<BRGBusinessRule> allRules = session.createQuery("from BRGBusinessRule").list();
			 session.getTransaction().commit();
			 session.close();
			return allRules;
		}
		else{
			return null;
		}
	}

	public static void setAllRules(List<BRGBusinessRule> rules) {
		DomainService.rules = rules;
	}

	public static List<BRGBusinessRuleType> getAllRuletypes() {
		return ruletypes;
	}

	public static void setAllRuletypes(List<BRGBusinessRuleType> ruletypes) {
		DomainService.ruletypes = ruletypes;
	}

	public static List<BRGTable> getAllTables() {
		return tables;
	}

	public static void setAllTables(List<BRGTable> tables) {
		DomainService.tables = tables;
	}
}
