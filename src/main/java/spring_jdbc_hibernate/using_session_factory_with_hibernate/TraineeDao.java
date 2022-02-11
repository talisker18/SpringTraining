package spring_jdbc_hibernate.using_session_factory_with_hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TraineeDao {
	private SessionFactory sessionFactory;
	
	//add transaction too in the methods!e
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public int addTrainee(Trainee t) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		int primaryKey = (Integer) session.save(t);
		transaction.commit();
		
		//close resources
		session.close();
		
		//do not close SessionFactory!!
		
		return primaryKey;
	}
	
	@SuppressWarnings("unchecked")
	public List<Trainee> getAllTrainees(){
		Session session = this.sessionFactory.openSession();
		//use Transaction for search queries as well
		Transaction transaction = session.beginTransaction();
		
		List<Trainee> listWithTrainees = session.createQuery("from Trainee").list();
		transaction.commit();
		
		//close resources
		session.close();
		
		//do not close SessionFactory!!
		
		return listWithTrainees;
	}

}
