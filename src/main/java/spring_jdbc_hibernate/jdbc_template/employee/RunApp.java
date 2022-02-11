package spring_jdbc_hibernate.jdbc_template.employee;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RunApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ap = new ClassPathXmlApplicationContext("path to spring.xml");
		EmployeeDao dao = (EmployeeDao) ap.getBean("edao"); //edao specified in spring.xml as bean
		
		Employee e1 = new Employee();
		e1.setEmployeeId(1);
		e1.setName("joel");
		
		//add new employee
		int count = dao.addEmployee(e1);
		
		//get all employees
		
		List<Object> list = dao.getAllEmployees();
		
		for(Object o: list) {
			Employee emp = (Employee) o;
			System.out.println(emp);
		}
		
		//do multiple actions in db
		dao.performMultiActions(e1);
		
	}

}
