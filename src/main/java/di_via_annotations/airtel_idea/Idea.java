package di_via_annotations.airtel_idea;

import org.springframework.stereotype.Component;

//@Component auto generates a reference for a object of this class

@Component
public class Idea implements Sim{
	
	public String str1;
	Airtel2 airtel;
	
	public Idea() {
		
	}

	public void typeOfSim() {
		System.out.println("Idea");
		
	}

	public void dataTypeOfSim() {
		System.out.println("4g of idea");
		
	}

	public String getStr1() {
		return str1;
	}

	public void setStr1(String str1) {
		this.str1 = str1;
	}
}
