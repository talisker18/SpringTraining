package spring_jdbc_hibernate.jdbc_template.employee2;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	
	public static void main(String[] args) {
		//before this: create db and table
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring_jdbc_hibernate/jdbc_template/employee2/spring.xml"); //root dir to load is always: src/main/java
		EmployeeCRUD crud = (EmployeeCRUD) ac.getBean(EmpCRUD.class);
		Employee e = ac.getBean(Employee.class);
		
		//System.out.println("rows inserted: "+crud.save(e));
		List<Employee> list = crud.getEmployees();
		System.out.println(list);
	}
	

}
