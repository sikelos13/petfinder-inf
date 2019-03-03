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

public class AnimalWelfareTest {
	Adoption adoption;
	Pet pet;
	Applicant applicant;
	Date date;
	AnimalWelfare welfare;
	protected EntityManager em;
	
	@Before
	public void setup(){
		// prepare database for each test
		welfare = new AnimalWelfare(null, null, null, null, null, null);
		welfare.setCountry("Greece");
		welfare.setRegion("Attica");
        welfare.setAddress("Troias");

	}
	
	
//	   @Test
//	    public void addApplicant() {
//		   Applicant applicant = new Applicant();
//	        adoption.setApplicant(applicant);
//	        Assert.assertEquals(applicant,adoption.getApplicant());
//	    }
	   
	   @Test
	    public void addCountry() {
		   welfare.setCountry("Greece");
	        Assert.assertEquals("Greece",welfare.getCountry());
	    }
	   
	   @Test
	    public void addRegion() {
	        String regionTest = "Attica";
	        welfare.setRegion(regionTest);
	        Assert.assertEquals(regionTest,welfare.getRegion());
	    }
	   
	   @Test
	    public void addAddress() {
		   String addressTest = "Troias 2";
	        welfare.setAddress(addressTest);
	        Assert.assertEquals(addressTest,welfare.getAddress());
	    }
	   
	   @Test
	    public void addDate() {
	        welfare.setAnimalWelfareID(1);
	        Assert.assertEquals((Integer) 1,welfare.getAnimalWelfareID());
	    }
	   
//	   @Test
//	    public void addId() {
//	        Integer id = 1;
//	        Assert.assertEquals((Integer) 1,adoption.getId());
//	    }
//	   

}
