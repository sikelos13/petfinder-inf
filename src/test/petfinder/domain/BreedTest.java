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

public class BreedTest {
	Adoption adoption;
	Pet pet;
	Applicant applicant;
	Date date;
	AnimalWelfare welfare;
	Breed breed;
	protected EntityManager em;
	
	@Before
	public void setup(){
		// prepare database for each test
		breed = new Breed();
		breed.setBreedName("Breed name");
		breed.setAnimal("Dog");
		breed.setNeedsGarden(true);

	}
	
	
//	   @Test
//	    public void addApplicant() {
//		   Applicant applicant = new Applicant();
//	        adoption.setApplicant(applicant);
//	        Assert.assertEquals(applicant,adoption.getApplicant());
//	    }
	   
	   @Test
	    public void addBreedName() {
		   String breedName = "BreedTest";
		   breed.setBreedName(breedName);
	        Assert.assertEquals(breedName,breed.getBreedName());
	    }
	   
	   @Test
	    public void addAnimal() {
	        String animalTest = "Dog";
	        breed.setAnimal(animalTest);
	        Assert.assertEquals(animalTest,breed.getAnimal());
	    }
	   
	   @Test
	    public void addMinLivingArea() {
		   Double addressTest = 86.5;
		   breed.setMinLivingArea(addressTest);
	        Assert.assertEquals((Double) addressTest,breed.getMinLivingArea());
	    }
	   
	   @Test
	    public void addNeedsGarden() {
		   boolean needsGarden = true;
		   breed.setNeedsGarden(needsGarden);
	        Assert.assertEquals(needsGarden,breed.getNeedsGarden());
	    }
	   
	   @Test
	    public void addMinPetBudgetPerWeek() {
		   Double testValue = 26.00;
		   breed.setMinPetBudgetPerWeek(testValue);
	        Assert.assertEquals((Double) testValue,breed.getMinPetBudgetPerWeek());
	    }
	   
	   @Test
	    public void addNonCompBreed() {
		   Breed testBreed = new Breed();
		   breed.addNonCompBreed(testBreed);
	        Assert.assertEquals(testBreed,breed.getNonCompBreed());
	    }
	   
	   @Test
	    public void addMinHoursPerDay() {
		   Double testValue = 33.00;
		   breed.setMinHoursPerDay(testValue);
	        Assert.assertEquals((Double) testValue, breed.getMinHoursPerDay());
	    }
	   
//	   

}
