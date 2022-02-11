package di_via_annotations.coffee_machine;

import org.springframework.stereotype.Component;

@Component
public class Espresso implements CoffeMachine{
	private final static String typeOfCoffee = "Espresso";
	private final static int baseCost = 1;

	public String typeOfCoffee() {
		// TODO Auto-generated method stub
		return typeOfCoffee;
	}

	public int costOfCoffee(String size) {
		if(size.equals("small")) {
			return baseCost*CoffeMachine.small;
		}else if(size.equals("medium")) {
			return baseCost*CoffeMachine.medium;
		}else {
			return baseCost*CoffeMachine.big;
		}
	}

}
