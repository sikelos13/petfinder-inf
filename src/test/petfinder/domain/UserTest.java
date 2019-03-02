package petfinder.domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import petfinder.domain.User;
import petfinder.persistence.Initializer;
import petfinder.persistence.JPAUtil;

public class UserTest {
	
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
	public void testValidUser(){
		User user = new User();
		user.setFullName("User Test");
		user.setTelephone("6923410132");
		user.setEmail("user@test.com");

		// EntityManager.persist() updates the ID of the persisted object
		Assert.assertNotNull("Excpected not null pet id", user.getID());
		em.close(); // close session
		
		// new session, data will be retrieved from database
		em = JPAUtil.getCurrentEntityManager();	

		User savedUser = em.find(User.class, user.getID()); 
		Assert.assertNotNull(savedUser);
		Assert.assertEquals("User Test", user.getFullName());
		Assert.assertEquals("6923410132", user.getTelephone());
		Assert.assertEquals("user@test.com", user.getEmail());
	

		
	}

}
