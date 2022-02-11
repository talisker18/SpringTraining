package spring_jdbc_hibernate.jdbc_template.employee2;

import java.util.List;

public interface EmployeeCRUD {
	int save(Employee e);
	List<Employee> getEmployees();

}
