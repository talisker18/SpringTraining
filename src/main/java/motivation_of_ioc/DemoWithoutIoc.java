package motivation_of_ioc;

public class DemoWithoutIoc {
	//here, use instance var of interface
	private SomeInterface impl;
	
	public DemoWithoutIoc() {
		//in this way we have to make implementation here
		this.impl = new SomeInterface() {
			
			public void doSomething() {
				// TODO Auto-generated method stub
				
			}
		};
	}

}
