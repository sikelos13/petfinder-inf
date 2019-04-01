package petfinder.domain;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import petfinder.contacts.TextMessage;


@Entity
@Table(name="employees")
public class Employee extends User {

	@Id
    @Column(name="employeeID")
    @GeneratedValue(strategy = GenerationType.AUTO) 
	private Integer employeeID;
	
	private String jobTitle;
	
	public Employee() {
		super();
		setJobTitle("Unknown");
	}

	public Employee(String FullName, String Telephone, String Email, String JobTitle) {
		super(FullName, Telephone, Email);
		this.jobTitle = JobTitle;
	}
	
	public void setJobTitle(String JobTitle) {
		this.jobTitle = JobTitle;
	}
	
	public String getJobTitle() {
		return this.jobTitle;
	}
	
	public boolean acceptAdoption(Adoption adpt) {
		return adpt.approve();
	}

	public static void sendText(TextMessage textMessage) {
		// TODO Auto-generated method stub
		
	}
	

}
