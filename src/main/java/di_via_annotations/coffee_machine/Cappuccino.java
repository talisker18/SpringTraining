package di_via_annotations.coffee_machine;

import org.springframework.stereotype.Component;

@Component
public class Cappuccino implements CoffeMachine{
	private static final String typeOfCoffee = "Cappuccino";
	private static final int baseCost = 2;

	public String typeOfCoffee() {
		// TODO Auto-generated method stub
		return typeOfCoffee;
	}

	public int costOfCoffee(String size) {
		// TODO Auto-generated method stub
		if(size.equals("small")) {
			return baseCost*CoffeMachine.small;
		}else if(size.equals("medium")) {
			return baseCost*CoffeMachine.medium;
		}else {
			return baseCost*CoffeMachine.big;
		}
	}
}
