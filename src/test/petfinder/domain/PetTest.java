package petfinder.domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import petfinder.domain.Pet;
import petfinder.persistence.Initializer;
import petfinder.persistence.JPAUtil;

public class PetTest {
	
	protected EntityManager em;
	private Breed breed;
	
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
	public void testValidPet(){
		breed = new Breed();
		Pet pet = new Pet(breed, null, 0, 0, false);
		pet.setAge((float) 4.0);
		pet.setBreed(breed);
		pet.setHealthStatus("Healthy");
		pet.setWeight((float) 17.5);
		pet.setHasBeenAdopted(false);

		// EntityManager.persist() updates the ID of the persisted object
		Assert.assertNotNull("Excpected not null pet id", pet.getID());
		em.close(); // close session
		
		// new session, data will be retrieved from database
		em = JPAUtil.getCurrentEntityManager();	

		Pet savedPet = em.find(Pet.class, pet.getID()); 
		Assert.assertNotNull(savedPet);
		Assert.assertEquals("Age",4.0, savedPet.getAge(),0);
		Assert.assertEquals(breed, savedPet.getBreed());
		Assert.assertEquals("Healthy", savedPet.getHealthStatus());
		Assert.assertEquals("Weight", 17.5, savedPet.getWeight(), 0);
		Assert.assertEquals(false, savedPet.getHasBeenAdopted());

		
	}

}
