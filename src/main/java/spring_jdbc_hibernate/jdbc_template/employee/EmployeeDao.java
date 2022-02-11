package spring_jdbc_hibernate.jdbc_template.employee;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class EmployeeDao {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private PlatformTransactionManager platformTransactionManager;
	
	public void setDataSource(DataSource source) {
		this.dataSource = source;
		this.jdbcTemplate = new JdbcTemplate(this.dataSource);
	}
	
	public int addEmployee(Employee e) {
		int count = 0;
		String query = "insert into employee values(?,?)";
		count = this.jdbcTemplate.update(query,e.getEmployeeId(),e.getName());
		return count;
	}
	
	public List<Object> getAllEmployees(){
		String query = "select * from employee";
		List<Object> list = this.jdbcTemplate.query(query, new EmployeeMapper());
		return list;
	}
	
	public void performMultiActions(Employee e) {
		TransactionDefinition td = new DefaultTransactionDefinition();
		TransactionStatus ts = this.platformTransactionManager.getTransaction(td);
		
		try {
			String query = "insert into employee values(?,?);";
			int count = this.jdbcTemplate.update(query,e.getEmployeeId(),e.getName());
			System.out.println(count+" records inserted");
			
			query = "select * from employee";
			List<Object> list = this.jdbcTemplate.query(query, new EmployeeMapper());
			
			for(Object emp: list) {
				Employee current = (Employee) emp;
				System.out.println(current);
			}
			
			this.platformTransactionManager.commit(ts);
		} catch (Exception e2) {
			this.platformTransactionManager.rollback(ts);
		}
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public PlatformTransactionManager getPlatformTransactionManager() {
		return platformTransactionManager;
	}

	public void setPlatformTransactionManager(PlatformTransactionManager platformTransactionManager) {
		this.platformTransactionManager = platformTransactionManager;
	}
}
