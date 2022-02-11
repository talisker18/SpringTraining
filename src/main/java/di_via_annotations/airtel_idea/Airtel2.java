package di_via_annotations.airtel_idea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Component auto generates a reference for a object of this class

@Primary
@Component
public class Airtel2 implements Sim{

	@Autowired
	Idea idea;
	
	
	//@Value("airtel has good data strength")
	String dataStrength;
	
	public String str1;
	
	public Airtel2(String str) {
		this.str1 = str;
	}
	
	public Airtel2() {
		
	}
	
	public void displayIdea() {
		this.idea.dataTypeOfSim();
	}
	
	public void typeOfSim() {
		System.out.println("Airtel");
		
	}

	public void dataTypeOfSim() {
		System.out.println("4g data of airtel2");
		
	}

	public String getStr1() {
		return str1;
	}

	public void setStr1(String str1) {
		this.str1 = str1;
	}
	
	public String getDataStrength() {
		return this.dataStrength;
	}
	
	@Required
	@Value("airtel has good data strength")
	public void setDataStrength(String str) {
		this.dataStrength = str;
	}
}
