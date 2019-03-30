package petfinder.domain;

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

public class AdTest {
	Ad ad;
	Pet pet;
	Employee employee;
	protected EntityManager em;
	
	@Before
	public void setup(){
		// prepare database for each test
		  	ad = new Ad(pet, null, null);
	        ad.setDetails("Some test details");
	        ad.setPet(pet);
	        ad.setActive(true);
		
	}
	
	
	   @Test
	    public void addPet() {
	        Pet pet = new Pet(null, null, null, null, false);
	        ad.setPet(pet);
	        Assert.assertEquals(pet,ad.getPet());
	    }
	   
	   @Test
	    public void addDetails() {
	        String detailTest = "test string for ad class";
	        ad.setDetails(detailTest);
	        Assert.assertEquals("test string for ad class",ad.getDetails());
	    }
	   
	   @Test
	    public void addActive() {
	        Boolean activeTest = true;
	        ad.setActive(activeTest);
	        Assert.assertEquals(true,ad.isActive());
	    }
	   
	   @Test
	    public void addAuthor() {
	        Employee employee = new Employee();
	        ad.setAuthor(employee);
	        Assert.assertEquals(employee,ad.getAuthor());
	    }
	   
	   @Test
	    public void addId() {
	        Integer id = 1;
	        ad.setID(1);
	        Assert.assertEquals((Integer) 1,ad.getID());
	    }
	   

}
