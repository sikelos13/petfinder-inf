package petfinder.domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import petfinder.domain.Applicant;
import petfinder.persistence.Initializer;
import petfinder.persistence.JPAUtil;

public class ApplicantTest {
	
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
	public void testValidAnimalWelfare(){
		Applicant applicant = new Applicant();
		applicant.setAddress("Kuprou-42");
		applicant.setCountry("Greece");
		applicant.setEmail("animalwelfare@test.gr");
		applicant.setRegion("Attica");
		applicant.setFullName("Stefanos-Ath");
		applicant.setTelephone("6934120592");

		// EntityManager.persist() updates the ID of the persisted object
		Assert.assertNotNull("Excpected not null applicant id", applicant.getID());
		em.close(); // close session
		
		// new session, data will be retrieved from database
		em = JPAUtil.getCurrentEntityManager();	

		Applicant savedApplicant = em.find(Applicant.class, applicant.getID()); 
		Assert.assertNotNull(savedApplicant);
		Assert.assertEquals("Kuprou-42", savedApplicant.getAddress());
		Assert.assertEquals("Greece", savedApplicant.getCountry());
		Assert.assertEquals("animalwelfare@test.gr", savedApplicant.getEmail());
		Assert.assertEquals("Attica", savedApplicant.getRegion());
		Assert.assertEquals("Stefanos-Ath", savedApplicant.getFullName());
		Assert.assertEquals("6934120592", savedApplicant.getTelephone());

		
	}

}
