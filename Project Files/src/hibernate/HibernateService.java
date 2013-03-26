package hibernate;

import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateService {
	private static Configuration _cfg = null;
	private static SessionFactory _sF = null;
	private static Boolean _cfgChanged = false;

	public static final String CONNECT_PROPERTY_NAME = "hibernate.connection.url";
	public static final String USERNAME_PROPERTY_NAME = "hibernate.connection.username";
	public static final String PASSWORD_PROPERTY_NAME = "hibernate.connection.password";
	public static final String DRIVER_PROPERTY_NAME = "connection.driver_class";
	public static final String FACTORY_PROPERTY_NAME = "transaction.factory_class";
	public static final String HBM2DDL_PROPERTY_NAME = "hibernate.hbm2ddl.auto";

	public static void InitService() {
		Configuration cfg = getConfiguration();

		cfg.setProperty(DRIVER_PROPERTY_NAME, "oracle.jdbc.driver.OracleDriver")
				.setProperty(FACTORY_PROPERTY_NAME,
						"org.hibernate.transaction.JDBCTransactionFactory")
				.setProperty(HBM2DDL_PROPERTY_NAME, "validate").configure();
	}

	public static void mapClasses(Set<Class<?>> entityClasses) {
		Configuration cfg = getConfiguration();

		for (Class<?> c : entityClasses) {
			cfg.addAnnotatedClass(c);
		}
	}

	public static void setHibernateConnection(String connString,
			String username, String password) {
		Configuration cfg = getConfiguration();

		cfg.setProperty(CONNECT_PROPERTY_NAME, connString);
		cfg.setProperty(USERNAME_PROPERTY_NAME, username);
		cfg.setProperty(PASSWORD_PROPERTY_NAME, password);

		cfg.configure();

		_cfgChanged = true;
	}

	public static Configuration getConfiguration() {
		if (_cfg == null) {
			_cfg = new Configuration();
		}
		return _cfg;
	}

	public static SessionFactory getSessionFactory() {
		if (_cfgChanged && _sF != null) {
			_sF.close();
			_sF = null;
		}

		if (_sF == null) {
			Configuration cfg = getConfiguration();
			_sF = cfg.buildSessionFactory(new ServiceRegistryBuilder()
					.applySettings(cfg.getProperties()).buildServiceRegistry());
		}

		return _sF;
	}

	public static String getConfigProp(String prop) {
		Configuration cfg = getConfiguration();

		return cfg.getProperty(prop);
	}
}