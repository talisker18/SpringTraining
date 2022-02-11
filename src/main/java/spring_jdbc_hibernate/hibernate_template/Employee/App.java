package spring_jdbc_hibernate.hibernate_template.Employee;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//use jboss plugin eclipse to auto generate hibernate.cfg.xml files
		
		//dont create table before!! this is done by hibernate
		
		//get hibernate config
		/*
		 * step1: StandardServiceRegistry
		 * step2: Metadata
		 * step3: SessionFactory
		 * step4: Session
		 * step5. Transaction
		 * step6: close connections
		 * 
		 * */
		
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder()
				.configure("spring_jdbc_hibernate/hibernate_template/Employee/hibernate.cfg.xml")
				.build();
		//in xml file read metadata
		Metadata md = new MetadataSources(ssr).getMetadataBuilder()
				.build();
		
		//get the properties of session factory within the metadata
		SessionFactory sf = md.getSessionFactoryBuilder()
				.build();
		
		//do CRUD with session object
		Session s = sf.openSession();
		
		//transaction ACID -> atomicity, consistency, isolation, durability
		Transaction t = s.beginTransaction();
		
		Employee e = new Employee();
		e.setName("hallo");
		//save operation. you can use also persist(), this will not return the primary key of inserted record
		//s.save(e); // -> return the primary key of inserted record
		//get by id
		Employee e2 = s.get(Employee.class, 1); //replaces classic select * where id = ...
		System.out.println(e2);
		
		
		//we can also save multiple Employee objects in 1 transaction!!
		//use for loop to save multiple records of a List
		
		//or use hql...you can use this also for oracle db, mongo db etc
		Query q = s.createQuery("from Employee"); //use here the name of the class, not the actual table
		List<Employee> list = q.list();
		System.out.println(list);
		
		q = s.createQuery("from Employee where id=1");
		Employee e3 = (Employee) q.uniqueResult();
		System.out.println("unique result: "+e3);
		
		//if we want to select specific fields...
		q = s.createQuery("select name from Employee"); //again: use fields and class name of bean, not of database
		List<String> listWithNames = q.list();
		System.out.println(listWithNames);
		
		//hql style for update
		q = s.createQuery("update Employee set name=:name WHERE id=:id");
		q.setParameter("name", "hansiiiii");
		q.setParameter("id", 1);
		q.executeUpdate();
		
		//or use HCQL (hibernate criteria query language) -> its deprecated
		//see: /codecademy_simplilearn_training/src/main/java/AAI_data_and_database/database/hibernate_jdbc/hibernate/hibernate_queries/Demo1.java		
		
		t.commit(); //if exception occurs during t.commit(), there will be automatically a rollback
		s.close();
		sf.close();
		
	}

}
