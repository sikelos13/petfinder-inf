package petfinder.domain;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import petfinder.domain.Adoption;
import petfinder.persistence.Initializer;
import petfinder.persistence.JPAUtil;

public class AdoptionTest {
	
	protected EntityManager em;
	private Date testDate;
	private Applicant applicant;
	
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
	public void testValidAdoption(){
		Applicant applicant = new Applicant();
		testDate = new Date();
		Adoption adoption = new Adoption(null, null, null, null);
		adoption.setAdoptionDate(testDate);
		adoption.setDetails("Details test");
		adoption.setApplicant(applicant);
		// EntityManager.persist() updates the ID of the persisted object
		Assert.assertNotNull("Excpected not null adoption id", adoption.getId());
		em.close(); // close session
		
		// new session, data will be retrieved from database
		em = JPAUtil.getCurrentEntityManager();	

		Adoption savedAdoption = em.find(Adoption.class, adoption.getId()); 
		Assert.assertNotNull(savedAdoption);
		Assert.assertEquals("Details test", savedAdoption.getDetails());
		Assert.assertEquals(testDate, savedAdoption.getAdoptionDate());
		Assert.assertEquals(applicant, savedAdoption.getApplicant());

		
	}

}
