package spring_jdbc_hibernate.jdbc_template.employee;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeMapper implements RowMapper<Object>{

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee e = new Employee();
		e.setEmployeeId(rs.getInt("employeeId"));
		e.setName("name");
		return e;
	}

}
