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
		// Save
		//Message message = new Message("Hello World!!!!!!!!!! Log 4j");
		//session.save(message);
		
		Message msg = session.get(Message.class, 2L);
		//Message msg1 = session.get(Message.class, 2L);
		
		// Second level cache
		
		session.getTransaction().commit();
		session.close();
		
	}
}
