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

public class UserTest {
	Adoption adoption;
	Pet pet;
	Applicant applicant;
	Breed breed;
	User user;
	Image image;
	protected EntityManager em;
	
	@Before
	public void setup(){
		// prepare database for each test
		user = new User();
		user.setFullName("Test User");
		user.setTelephone("2108946128");
		user.setEmail("user@test.gr");

	}
	
	
//	   @Test
//	    public void addApplicant() {
//		   Applicant applicant = new Applicant();
//	        adoption.setApplicant(applicant);
//	        Assert.assertEquals(applicant,adoption.getApplicant());
//	    }
	   
	   @Test
	    public void addFullName() {
		   String testFullName = "Test user";
		   user.setFullName(testFullName);
	        Assert.assertEquals(testFullName,user.getFullName());
	    }
	   
	   @Test
	    public void addTelephone() {
	        String testTelephone = "2105876234";
	        user.setTelephone(testTelephone);
	        Assert.assertEquals(testTelephone,user.getTelephone());
	    }
	   
	   @Test
	    public void addEmail() {
	        String testEmail = "user@test.gr";
		   user.setEmail(testEmail);
	        Assert.assertEquals(testEmail,user.getEmail());
	    }
	   
	   @Test
	    public void addId() {
		   Integer testId = 2;
		   user.setID(testId);
	        Assert.assertEquals((Integer) testId,user.getID());
	    }
	   
	
//	   

}
