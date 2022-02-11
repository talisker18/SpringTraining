package spring_jdbc_hibernate.jdbc_template.employee2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

public class EmpCRUD implements EmployeeCRUD{
	
	
	JdbcTemplate temp;
	
	public EmpCRUD(JdbcTemplate temp) {
		this.temp = temp;
	}

	public int save(Employee e) {
		// TODO Auto-generated method stub
		String sql = "insert into employee values("+e.getId()+",'"+e.getName()+"');";
		return temp.update(sql); //used for insert, update and delete
	}

	public List<Employee> getEmployees() {
		String sql = "select * from employee";
		
		return temp.query(sql, new ResultSetExtractor<List<Employee>>() { //anonymous inner type (functional interface)

			public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Employee> list= new ArrayList<Employee>();
				
				while(rs.next()) {
					Employee emp = new Employee();
					emp.setId(rs.getInt(1));
					emp.setName(rs.getString(2));
					list.add(emp);
				}
				
				return list;
			}
			
		});
	}

}
