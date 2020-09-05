package blog.utility;


import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateConnectionManager {
	public static SessionFactory getSessionFactory() throws HibernateException{

		
//			Configuration configuration=new Configuration();
//			configuration.configure("hibernate.cfg.xml");
//			seesionFactory=configuration.buildSessionFactory();
			SessionFactory seesionFactory = new Configuration().configure().buildSessionFactory();
			
		return seesionFactory;
		
	}
}
