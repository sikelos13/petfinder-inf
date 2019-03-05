package petfinder.domain;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import petfinder.domain.Ad;
import petfinder.domain.Pet;
import petfinder.domain.Employee;
import petfinder.persistence.Initializer;
import petfinder.persistence.JPAUtil;

public class EmployeeTest {
	Adoption adoption;
	Pet pet;
	Applicant applicant;
	Employee employee;
	protected EntityManager em;
	
	@Before
	public void setup(){
		// prepare database for each test
		employee = new Employee();
		employee.setJobTitle("Pet manager");

	}
	
	
//	   @Test
//	    public void addApplicant() {
//		   Applicant applicant = new Applicant();
//	        adoption.setApplicant(applicant);
//	        Assert.assertEquals(applicant,adoption.getApplicant());
//	    }
	   
	   @Test
	    public void addJobTitle() {
		   employee.setJobTitle("Pet manager");
	        Assert.assertEquals("Pet manager",employee.getJobTitle());
	    }
	   
	   @Test
	    public void addId() {
		   	
	        Assert.assertNotNull(employee.getID());
	    }
//	   

}
