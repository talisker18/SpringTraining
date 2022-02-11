package spring_jdbc_hibernate.using_session_factory_with_hibernate;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring_jdbc_hibernate/using_session_factory_with_hibernate/spring.xml");
		TraineeDao dao = context.getBean(TraineeDao.class);
		
		Trainee t1 = new Trainee();
		t1.setName("timo");
		int id = dao.addTrainee(t1);
		
		//another employee
		Trainee t2 = new Trainee();
		t2.setName("bruno");
		int id2 = dao.addTrainee(t2);
		
		//get list of trainees
		List<Trainee> list = dao.getAllTrainees();
		
		System.out.println(list);
	}
}
