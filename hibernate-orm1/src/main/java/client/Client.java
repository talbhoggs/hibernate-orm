package client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Message;
import util.HibernateUtil;

public class Client {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		Message m = new Message("test");
		// This section explore component mapping.
		
		// Component are Composition in relationship with the Whole
		// example
		// House --> room
		// if the house is destroy room is also destroy
		
		// Using Value types (Composition Releationship)
		
		session.getTransaction().commit();
		session.close();
		
	}
}
