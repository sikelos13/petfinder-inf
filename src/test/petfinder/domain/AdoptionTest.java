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

public class AdoptionTest {
	Adoption adoption;
	Pet pet;
	Applicant applicant;
	Date date;
	protected EntityManager em;
	
	@Before
	public void setup(){
		// prepare database for each test
		adoption = new Adoption();
		adoption.setDetails("Some test details");
		adoption.setApplicant(applicant);
		
	}
	
	
//	   @Test
//	    public void addApplicant() {
//		   Applicant applicant = new Applicant();
//	        adoption.setApplicant(applicant);
//	        Assert.assertEquals(applicant,adoption.getApplicant());
//	    }
	   
	   @Test
	    public void addPet() {
	        Pet pet = new Pet(null, null, null, null, false);
	        adoption.setPet(pet);
	        Assert.assertEquals(pet,adoption.getPet());
	    }
	   
	   @Test
	    public void addDetails() {
	        String detailTest = "test string for adoption class";
	        adoption.setDetails(detailTest);
	        Assert.assertEquals("test string for adoption class",adoption.getDetails());
	    }
	   
	   @Test
	    public void isRejected() {
	        Assert.assertEquals(false,adoption.isRejected());
	    }
	   
	   @Test
	    public void addDate() {
	        Date dateTest = new Date();
	        adoption.setAdoptionDate(dateTest);
	        Assert.assertEquals(dateTest,adoption.getAdoptionDate());
	    }
	   
//	   @Test
//	    public void addId() {
//	        Integer id = 1;
//	        Assert.assertEquals((Integer) 1,adoption.getId());
//	    }
//	   

}
