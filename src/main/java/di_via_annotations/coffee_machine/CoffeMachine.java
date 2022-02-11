package di_via_annotations.coffee_machine;

public interface CoffeMachine {
	public static final int small = 2;
	public static final int medium =3;
	public static final int big = 5;
	
	String typeOfCoffee();
	int costOfCoffee(String size);
}
