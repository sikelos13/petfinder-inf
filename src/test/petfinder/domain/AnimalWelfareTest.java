package petfinder.domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import petfinder.domain.AnimalWelfare;
import petfinder.persistence.Initializer;
import petfinder.persistence.JPAUtil;

public class AnimalWelfareTest {
	
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
		AnimalWelfare animalWelfare = new AnimalWelfare(null, null, null, null, null, null);
		animalWelfare.setAddress("Kuprou-42");
		animalWelfare.setCountry("Greece");
		animalWelfare.setEmail("animalwelfare@test.gr");
		animalWelfare.setRegion("Attica");
		animalWelfare.setFullName("TestWelfare");

		// EntityManager.persist() updates the ID of the persisted object
		Assert.assertNotNull("Excpected not null animalWelfare id", animalWelfare.getAnimalWelfareID());
		em.close(); // close session
		
		// new session, data will be retrieved from database
		em = JPAUtil.getCurrentEntityManager();	

		AnimalWelfare savedWelfare = em.find(AnimalWelfare.class, animalWelfare.getAnimalWelfareID()); 
		Assert.assertNotNull(savedWelfare);
		Assert.assertEquals("Kuprou-42", savedWelfare.getAddress());
		Assert.assertEquals("Greece", savedWelfare.getCountry());
		Assert.assertEquals("animalwelfare@test.gr", savedWelfare.getEmail());
		Assert.assertEquals("Attica", savedWelfare.getRegion());
		Assert.assertEquals("TestWelfare", savedWelfare.getFullName());

		
	}

}
