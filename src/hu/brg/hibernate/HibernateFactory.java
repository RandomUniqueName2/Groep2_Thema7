package hu.brg.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;


public class HibernateFactory {
	private Configuration config;

	public HibernateFactory() {
		this.createNewConfig();
	}
	
	public Configuration getCurrentConfig() {
		if (config == null) {
			this.createNewConfig();
		}
		
		return this.config;
	}
	
	public Configuration createNewConfig() {
		this.config = new Configuration();
		return this.config;
	}

	public SessionFactory buildSessionFactory()
			throws HibernateException {
		ServiceRegistryBuilder registry = new ServiceRegistryBuilder();
				
		this.config.configure();
		registry.applySettings(this.config.getProperties());		
		
		return this.config.buildSessionFactory(registry.buildServiceRegistry());
	}
}
