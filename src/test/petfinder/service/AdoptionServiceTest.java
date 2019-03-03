package petfinder.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import petfinder.domain.Ad;
import petfinder.persistence.Initializer;
import petfinder.persistence.JPAUtil;

public class AdoptionServiceTest {
	private Ad ad;
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
		Ad ad = new Ad(null, null, null);
		AdoptionService service = new AdoptionService(em);
		boolean newAdoption = service.approveApplication(ad);
		// EntityManager.persist() updates the ID of the persisted object
		Assert.assertNotNull("Excpected not null on finding ad id", service.findAdById(0));
		Assert.assertNotNull("Excpected not null on finding applicant id", service.findApplicantById(0));
		em.close(); // close session
		
		// new session, data will be retrieved from database
		em = JPAUtil.getCurrentEntityManager();	

		AdoptionService savedAdoptionService = em.find(AdoptionService.class, service.findAdById(0)); 
		Assert.assertNotNull(savedAdoptionService);
		Assert.assertEquals(newAdoption, savedAdoptionService.approveApplication(ad));
		
	}

}
