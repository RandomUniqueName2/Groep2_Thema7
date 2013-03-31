package hu.brg.hibernate;

import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateService {
	private static final HibernateFactory hibernateFactory = new HibernateFactory();
	
	public void connect(String connString,
			String username, String password) {
		Configuration config = hibernateFactory.getCurrentConfig();

		config.setProperty("hibernate.connection.url", connString);
		config.setProperty("hibernate.connection.username", username);
		config.setProperty("hibernate.connection.password", password);

		config.configure();
		
		// Test connection, will throw error if fails
		hibernateFactory.buildSessionFactory().openSession().close();
	}
	
	public void mapClass(Class<?> entityClass) {
		hibernateFactory.getCurrentConfig().addAnnotatedClass(entityClass);
	}
	
	public void mapClassCollection(Collection<Class<?>> entityClasses) {
		Configuration cfg = hibernateFactory.getCurrentConfig();
		
		for (Class<?> c : entityClasses) {
			cfg.addAnnotatedClass(c);
		}
	}
	
	public void persistEntity(Object entity) {
		SessionFactory sf = hibernateFactory.buildSessionFactory();
		Session session = sf.openSession();
		
		session.beginTransaction();
		session.save(entity);
		
		session.getTransaction().commit();
		session.close();
	}
	
	public void persistEntityCollection(Collection<? extends Object> entityCollection) {
		SessionFactory sf = hibernateFactory.buildSessionFactory();
		Session session = sf.openSession();
		
		session.beginTransaction();
		
		for (Object entity : entityCollection) {
			session.save(entity);
		}
		
		session.getTransaction().commit();
		session.close();
	}
	
	public void deleteEntity(Object entity) {
		SessionFactory sf = hibernateFactory.buildSessionFactory();
		Session session = sf.openSession();
		
		session.beginTransaction();
		session.delete(entity);
		
		session.getTransaction().commit();
		session.close();
	}
	
	public void deleteEntityCollection(Collection<? extends Object> entityCollection) {
		SessionFactory sf = hibernateFactory.buildSessionFactory();
		Session session = sf.openSession();
		
		session.beginTransaction();
		
		for (Object entity : entityCollection) {
			session.delete(entity);
		}
		
		session.getTransaction().commit();
		session.close();
	}
	
	@SuppressWarnings("rawtypes")
	public List getAllFromEntity(Class<?> entityClass) {
		SessionFactory sf = hibernateFactory.buildSessionFactory();
		Session session = sf.openSession();
		
		session.beginTransaction();
		
		List result = session.createQuery("from " + entityClass.getSimpleName()).list();
		
		session.getTransaction().commit();
		session.close();
		
		return result;
	}
}