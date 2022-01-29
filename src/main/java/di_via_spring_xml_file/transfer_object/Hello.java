package di_via_spring_xml_file.transfer_object;

/*
 * instances of this class can only be injected via setter, see spring.xml
 * 
 * */

public class Hello {
	private String message;
	
	public Hello() {
		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
