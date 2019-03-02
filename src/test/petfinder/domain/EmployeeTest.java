package petfinder.domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import petfinder.domain.Employee;
import petfinder.persistence.Initializer;
import petfinder.persistence.JPAUtil;

public class EmployeeTest {
	
	protected EntityManager em;
	
	@Before
	public void setup(){
		// prepare database for each test
		em = JPAUtil.getCurrentEntityManager();
		Initializer dataHelper = new Initializer();
		dataHelper.prepareData();
		
	}
	
	@After
	public void tearDown(){
		em.close();
	}
	
	@Test
	public void testValidEmployee(){
		Employee employee = new Employee();
		employee.setEmail("diamantis@test.gr");
		employee.setJobTitle("Pet manager");
		employee.setFullName("Spyros Diamantis");
		employee.setTelephone("6923101230");

		// EntityManager.persist() updates the ID of the persisted object
		Assert.assertNotNull("Excpected not null employee id", employee.employeeID);
		em.close(); // close session
		
		// new session, data will be retrieved from database
		em = JPAUtil.getCurrentEntityManager();	

		Employee savedEmployee = em.find(Employee.class, employee.employeeID); 
		Assert.assertNotNull(savedEmployee);
		Assert.assertEquals("diamantis@test.gr", savedEmployee.getEmail());
		Assert.assertEquals("Pet manager", savedEmployee.getJobTitle());
		Assert.assertEquals("Spyros Diamantis", savedEmployee.getFullName());
		Assert.assertEquals("6923101230", savedEmployee.getTelephone());

		
	}

}
