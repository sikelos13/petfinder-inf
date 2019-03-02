package petfinder.domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import petfinder.domain.Ad;
import petfinder.persistence.Initializer;
import petfinder.persistence.JPAUtil;

public class AdTest {
	
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
	public void testValidAd(){
		
		Ad ad = new Ad(null, null, null);
		ad.setAuthor(null);
		ad.setDetails("Some test details");
		ad.setPet(null);
		// EntityManager.persist() updates the ID of the persisted object
		Assert.assertNotNull("Excpected not null adoption id", ad.getID());
		em.close(); // close session
		
		// new session, data will be retrieved from database
		em = JPAUtil.getCurrentEntityManager();	

		Ad savedAd = em.find(Ad.class, ad.getID()); 
		Assert.assertNotNull(savedAd);
		Assert.assertEquals("Description", savedAd.getDetails());
		Assert.assertEquals("Pet", savedAd.getPet());
		Assert.assertEquals("Employee", savedAd.getAuthor());

		
	}

}
