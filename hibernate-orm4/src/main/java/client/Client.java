package client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Actor;
import model.Movie;
import util.HibernateUtil;

public class Client {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction txn = session.getTransaction();
		
		try {
			txn.begin();

			// ManyToManay Relationship
			
			Actor c = new Actor("Drew Barrymore");
			Actor c1 = new Actor("Adam Sandler");
			
			Movie m = new Movie("50 first date");
			m.getActors().add(c);
			m.getActors().add(c1);
			
			session.persist(m);
			
			
			txn.commit();
		} catch (Exception e) {
			if(txn!=null) txn.rollback();
		} finally {
			if(session!=null) session.close();
		}
		
		
	}
}
