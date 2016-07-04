package client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Customer;
import model.Guide;
import model.Passport;
import model.Student;
import util.HibernateUtil;

public class Client {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction txn = session.getTransaction();
		
		try {
			txn.begin();
			Passport p = new Passport("1234");
			Customer c = new Customer("Charles", p);
			
			session.persist(c);
			
			// OneToOne Relationship
			
			
			txn.commit();
		} catch (Exception e) {
			if(txn!=null) txn.rollback();
		} finally {
			if(session!=null) session.close();
		}
		
		
	}
}
