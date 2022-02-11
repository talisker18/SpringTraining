package di_via_annotations.airtel_idea;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
 * using annotations
 * 
 * */

public class App {
	
	public static void main(String[] args) {
		
		ApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
		
		Airtel2 airtel2 = ac.getBean(Airtel2.class);
		//System.out.println(airtel.getStr1());
		
		//Idea idea = ac.getBean(Idea.class);
		//System.out.println(idea.getStr1());
		
		//for this to work we have to put Primary on Airtel2 class. if we do not, Sim bean does not know whether to get Airtel2 or Idea
		Sim sim = ac.getBean(Sim.class);
		sim.dataTypeOfSim();
		
		Airtel2 airtel3 = ac.getBean(Airtel2.class);
		//since we have a instance var of Idea in Airtel2, the @Autowired will instantiate automatically an object of Idea
		airtel3.displayIdea();
		
		System.out.println(airtel3.getDataStrength());
		
	}

}
