package di_via_annotations.coffee_machine;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RunApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new AnnotationConfigApplicationContext(ConfigClass.class);
		
		CoffeMachine cappuccino1 = ac.getBean(Cappuccino.class);
		System.out.println("cost of small Cappuccino: "+cappuccino1.costOfCoffee("small"));
		CoffeMachine cappuccino2 = ac.getBean(Cappuccino.class);
		System.out.println("cost of medium Cappuccino: "+cappuccino2.costOfCoffee("medium"));
		
		CoffeMachine espresso1 = ac.getBean(Espresso.class);
		System.out.println("cost of small Espresso: "+espresso1.costOfCoffee("small"));

	}

}
