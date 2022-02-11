package spring_jdbc_hibernate.using_session_factory_with_hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/*
 * see also github: https://github.com/talisker18/EmployeeManagementSystem
 * --> we do not use HibernateTemplate there but we use spring mvc annotations
 * 
 * */


@Entity
@Table(name="trainee")
public class Trainee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int traineeId;
	private String name;
	
	public Trainee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getTraineeId() {
		return traineeId;
	}
	
	public void setTraineeId(int traineeId) {
		this.traineeId = traineeId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Trainee [traineeId=" + traineeId + ", name=" + name + "]";
	}
}
