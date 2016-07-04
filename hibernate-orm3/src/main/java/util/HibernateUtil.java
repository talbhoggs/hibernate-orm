package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			
			/* IMPORTANT CREATING BuildSessionFactory in this type does not work with 5.2 version. I spends days to solve the issue.
			 * 
			 * 
			Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
			return configuration.buildSessionFactory(
					new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build());
			
			*/
			
			 StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
				        .configure( "hibernate.cfg.xml" )
				        .build();

				        Metadata metadata = new MetadataSources( standardRegistry )
				        .getMetadataBuilder()
				        .build();

				        return metadata.getSessionFactoryBuilder().build();
			
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
