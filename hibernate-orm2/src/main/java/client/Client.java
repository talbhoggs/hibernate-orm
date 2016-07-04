package client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Guide;
import model.Student;
import util.HibernateUtil;

public class Client {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction txn = session.getTransaction();
		
		try {
			txn.begin();
			/*
			Guide guide1 = new Guide("1234", "Charles Amper", 1000);
			Guide guide2 = new Guide("1235", "Joy Amper", 1000);
			
			Student student1 = new Student("12341", "Eric Salip Ahmad", guide1);
			Student student2 = new Student("12342", "Erica Salip Ahmad", guide2);
			
			guide1.getStudents().add(student1);
			guide2.getStudents().add(student2);
			
			session.persist(student1);
			session.persist(student2);
			*/
			
			Guide guide = (Guide) session.get(Guide.class, 2L);
			
			// One to Manay Associations
			// Bi directional
			
			
			
			txn.commit();
		} catch (Exception e) {
			if(txn!=null) txn.rollback();
		} finally {
			if(session!=null) session.close();
		}
		
		
	}
}
