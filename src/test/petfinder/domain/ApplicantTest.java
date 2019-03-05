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

public class ApplicantTest {
	Adoption adoption;
	Pet pet;
	Applicant applicant;
	Date date;
	AnimalWelfare welfare;
	protected EntityManager em;
	
	@Before
	public void setup(){
		// prepare database for each test
		applicant = new Applicant(null, null, null, null, null, null, null, 0.0, 0.0, 0.0);
		applicant.setCountry("Greece");
		applicant.setRegion("Attica");
		applicant.setAddress("Troias");

	}
	
	
//	   @Test
//	    public void addApplicant() {
//		   Applicant applicant = new Applicant();
//	        adoption.setApplicant(applicant);
//	        Assert.assertEquals(applicant,adoption.getApplicant());
//	    }
	   
	   @Test
	    public void addCountry() {
		   applicant.setCountry("Greece");
	        Assert.assertEquals("Greece",applicant.getCountry());
	    }
	   
	   @Test
	    public void addRegion() {
	        String regionTest = "Attica";
	        applicant.setRegion(regionTest);
	        Assert.assertEquals(regionTest,applicant.getRegion());
	    }
	   
	   @Test
	    public void addAddress() {
		   String addressTest = "Troias 2";
		   applicant.setAddress(addressTest);
	        Assert.assertEquals(addressTest,applicant.getAddress());
	    }
	   
	   @Test
	    public void addCity() {
		   String cityTest = "Athens";
		   applicant.setCity(cityTest);
	        Assert.assertEquals(cityTest,applicant.getCity());
	    }
	   
	   @Test
	    public void addHouseArea() {
		   Double testValue = 26.00;
		   applicant.setHouseArea(testValue);
	        Assert.assertEquals((Double) testValue,applicant.getHouseArea());
	    }
	   
	   @Test
	    public void addAvailableHoursPerDay() {
		   Double testValue = 31.5;
		   applicant.setAvailableHoursPerDay(testValue);
	        Assert.assertEquals((Double) testValue,applicant.getAvailableHoursPerDay());
	    }
	   
	   @Test
	    public void addPetBudgetPerWeek() {
		   Double testValue = 250.00;
		   applicant.setPetBudgetPerWeek(testValue);
	        Assert.assertEquals((Double) testValue,applicant.getPetBudgetPerWeek());
	    }
	   
	   @Test
	    public void addId() {
		   Integer testId = 2;
		   applicant.setID(testId);
	        Assert.assertEquals((Integer) testId,applicant.getID());
	    }
//	   

}
