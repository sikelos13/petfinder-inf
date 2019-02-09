package gr.aueb.mscis.sample.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import gr.aueb.mscis.sample.model.Movie;
import gr.aueb.mscis.sample.persistence.JPAUtil;

/**
 * CRUD operations and other functionality related to movies
 * 
 * @author bzafiris
 *
 */
public class MovieService {

	EntityManager em;
	
	public MovieService() {
		em = JPAUtil.getCurrentEntityManager();
	}
	
	public Movie createMovie(String title, int year, String director){
		
		if (title == null || year < 1970 || director == null){
			return null;
		}
		
		Movie newMovie = new Movie(title, year, director);
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(newMovie);
		tx.commit();
		
		return newMovie;
		
	}
	
}
