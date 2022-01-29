package di_via_spring_xml_file.transfer_object;

/*
 * instances of this class can be injected via setter or constructor, see spring.xml
 * 
 * */

public class Employee {
	private int employeeId;
	private String employeeName;

	public Employee() {
		System.out.println("default constructor called");
	}

	public Employee(int employeeId, String employeeName) {
		System.out.println("param constructor called");
		this.employeeId = employeeId;
		this.employeeName = employeeName;
	}
	
	public int getEmployeeId() {
		System.out.println("info: getEmployeeId() was called");
		return employeeId;
	}
	
	public void setEmployeeId(int employeeId) {
		System.out.println("info: setEmployeeId() was called");
		this.employeeId = employeeId;
	}
	
	public String getEmployeeName() {
		System.out.println("info: getEmployeeName() was called");
		return employeeName;
	}
	
	public void setEmployeeName(String employeeName) {
		System.out.println("info: setEmployeeName() was called");
		this.employeeName = employeeName;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + "]";
	}
}
