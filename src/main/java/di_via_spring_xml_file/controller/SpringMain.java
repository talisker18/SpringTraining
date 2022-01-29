package di_via_spring_xml_file.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import di_via_spring_xml_file.transfer_object.Employee;
import di_via_spring_xml_file.transfer_object.Hello;

public class SpringMain {
	public static void main(String[] args) {
		//access spring.xml file
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		//getting instances via setter injection
		Hello h = (Hello) context.getBean("h1"); //get bean by id. id is defined in spring.xml
		System.out.println(h.getMessage());
		
		Hello h2 = (Hello) context.getBean("h2"); //get bean by id. id is defined in spring.xml
		System.out.println(h2.getMessage());
		
		//here you will see that the setter methods and default constructor were called when DI via setter
		Employee e1 = (Employee) context.getBean("e1");
		
		
		
		
		
		
		//getting instance via constructor injection. You will see that param constructor was called
		Employee e2 = (Employee) context.getBean("e2");
		
		
	}
}
