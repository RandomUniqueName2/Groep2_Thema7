package controller;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;


public class HibernateService {
	private static Configuration _cfg  = null;
	private static SessionFactory _sF  = null;

	private static Boolean _cfgChanged = false;
	
	public static final String CONNECT_PROPERTY_NAME  = "hibernate.connection.url";
	public static final String USERNAME_PROPERTY_NAME = "hibernate.connection.username";
	public static final String PASSWORD_PROPERTY_NAME = "hibernate.connection.password";
	
	
	public static void setHibernateConnection(String connString, String username, String password) {
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
			_sF = cfg.buildSessionFactory(new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry());
		}
		
		return _sF;
	}
		
	public static String getConfigProp(String prop) {
		Configuration cfg = getConfiguration();
		
		return cfg.getProperty(prop);
	}
	
}
