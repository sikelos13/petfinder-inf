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

public class PetTest {
	Adoption adoption;
	Pet pet;
	Applicant applicant;
	Breed breed;
	AnimalWelfare welfare;
	Image image;
	protected EntityManager em;
	
	@Before
	public void setup(){
		// prepare database for each test
		pet = new Pet(null, null, null, null, false);
		pet.setHealthStatus("Healthy");
		pet.setAge(6.4);
		pet.setHasBeenAdopted(false);

	}
	
	
//	   @Test
//	    public void addApplicant() {
//		   Applicant applicant = new Applicant();
//	        adoption.setApplicant(applicant);
//	        Assert.assertEquals(applicant,adoption.getApplicant());
//	    }
	   
	   @Test
	    public void addImage() {
		   Image testImage = new Image("testImageUrl", "testImage Description");
	        Assert.assertEquals(testImage,pet.getImages());
	    }
	   
	   @Test
	    public void addHealthStatus() {
	        String healthStatusTest = "Healthy";
	        pet.setHealthStatus(healthStatusTest);
	        Assert.assertEquals(healthStatusTest,pet.getHealthStatus());
	    }
	   
	   @Test
	    public void addAge() {
		   Double ageTest = 7.2;
		   pet.setAge(ageTest);
	        Assert.assertEquals((Double) ageTest,pet.getAge());
	    }
	   
	   @Test
	    public void addWeight() {
		   Double weightTest = 29.7;
		   pet.setWeight(weightTest);
	        Assert.assertEquals((Double) weightTest,pet.getWeight());
	    }
	   
	   @Test
	    public void addHasBeenAdopted() {
		   Boolean adoptedTest = true;
		   pet.setHasBeenAdopted(adoptedTest);
	        Assert.assertEquals((Boolean) adoptedTest,pet.getHasBeenAdopted());
	    }
	   
	   @Test
	    public void addBreed() {
		   Breed testBreed = new Breed();
		   pet.setBreed(testBreed);
	        Assert.assertEquals(testBreed,pet.getBreed());
	    }
	   
	   
	   @Test
	    public void addId() {
//		   pet.setID(1);
	        Assert.assertNotNull(pet.getID());
	    }
//	   

}
