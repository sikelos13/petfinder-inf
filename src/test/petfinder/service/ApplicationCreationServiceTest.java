package petfinder.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import petfinder.service.ApplicationCreationService;
import petfinder.persistence.Initializer;
import petfinder.persistence.JPAUtil;
import petfinder.domain.*;

public class ApplicationCreationServiceTest {
	private Adoption ad;
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
	public void testPersistAValidApplicationCreation(){
		Ad ad = new Ad(null, null, null);
		ApplicationCreationService service = new ApplicationCreationService(em);
		Adoption newAdoption = service.createApplication(ad, null, null);
		// EntityManager.persist() updates the ID of the persisted object
		Assert.assertNotNull("Excpected not null adoption id", newAdoption.getId());
		em.close(); // close session
		
		// new session, data will be retrieved from database
		em = JPAUtil.getCurrentEntityManager();	

		ApplicationCreationService savedAdoption = em.find(ApplicationCreationService.class, newAdoption.getId()); 
		Assert.assertNotNull(savedAdoption);
		Assert.assertEquals("Description", savedAdoption.createApplication(ad,null,null));
		
	}

}
