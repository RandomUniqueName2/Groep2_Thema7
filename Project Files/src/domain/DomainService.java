package domain;

import java.util.HashMap;
import java.util.Map;

import domain.businessrule.BRGBusinessRule;
import domain.businessrule.BRGBusinessRuleType;
import domain.businessrule.BRGCategory;
import domain.database.BRGColumn;
import domain.database.BRGDatabase;
import domain.database.BRGTable;
import domain.database.BRGScheme;

public class DomainService {
	private static Map<String, BRGDatabase> databases = null;
	private static Map<String, BRGScheme> vieuws = null;
	private static Map<String, BRGTable> tables = null;
	private static Map<String, BRGColumn> columns = null;

	private static Map<String, BRGBusinessRuleType> ruletypes = null;
	private static Map<String, BRGBusinessRule> rules = null;

	public static void createBaseRepository() {
		Map<String, BRGCategory> cats = new HashMap<String, BRGCategory>();
		Map<String, BRGBusinessRuleType> types = new HashMap<String, BRGBusinessRuleType>();

		BRGCategory staticCat = new BRGCategory(BRGCategory.STATIC);
		BRGCategory dynamicCat = new BRGCategory(BRGCategory.DYNAMIC);

		cats.put(BRGCategory.STATIC, staticCat);
		cats.put(BRGCategory.DYNAMIC, dynamicCat);

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
			types.put(brt.getCode(), brt);
		}

		DomainService.ruletypes = types;
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

		BRGScheme vw = new BRGScheme("THO7_2012_2B_TEAM2", db);

		BRGTable t1 = new BRGTable("Person", vw);
		BRGColumn t1c1 = new BRGColumn("name", t1);
		BRGColumn t1c2 = new BRGColumn("age", t1);

		BRGTable t2 = new BRGTable("Adress", vw);
		BRGColumn t2c1 = new BRGColumn("Street", t2);
	}
}
