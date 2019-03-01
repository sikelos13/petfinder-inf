package petfinder.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import petfinder.domain.Adoption;
import petfinder.persistence.Initializer;
import petfinder.persistence.JPAUtil;

public class AdoptionServiceTest {
	
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
	public void testPersistAValidAdoption(){
		
		AdoptionService service = new AdoptionService(em);
		Adoption newAdoption = service.createAdoption("1-2-2019","Description" ,"Mike Jones","Fluffy" );
		// EntityManager.persist() updates the ID of the persisted object
		Assert.assertNotNull("Excpected not null adoption id", newAdoption.getId());
		em.close(); // close session
		
		// new session, data will be retrieved from database
		em = JPAUtil.getCurrentEntityManager();	

		Adoption savedAdoption = em.find(Adoption.class, newAdoption.getId()); 
		Assert.assertNotNull(savedAdoption);
		Assert.assertEquals("Description", savedAdoption.getDetails());
		
	}

}
