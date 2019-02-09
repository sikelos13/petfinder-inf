package gr.aueb.mscis.sample.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.mscis.sample.model.Movie;
import gr.aueb.mscis.sample.persistence.Initializer;
import gr.aueb.mscis.sample.persistence.JPAUtil;

public class MovieServiceTest {
	
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
	public void testPersistAValidMovie(){
		
		MovieService service = new MovieService();
		Movie newMovie = service.createMovie("Django", 2012, "Tarantino");
		// EntityManager.persist() updates the ID of the persisted object
		Assert.assertNotEquals(0, newMovie.getId());
		em.close(); // close session
		
		// new session, data will be retrieved from database
		em = JPAUtil.getCurrentEntityManager();	

		Movie savedMovie = em.find(Movie.class, newMovie.getId()); 
		Assert.assertNotNull(savedMovie);
		Assert.assertEquals("Django", savedMovie.getTitle());
		
	}

}
