package petfinder.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import petfinder.domain.Breed;
import petfinder.persistence.Initializer;
import petfinder.persistence.JPAUtil;

public class JPAQueriesTest {
	
	 private Initializer dataHelper;
	 
	 @Before
	    public void setUpJpa() {
	        dataHelper = new Initializer();
	        dataHelper.prepareData();
	    }
	 
	 
	 @SuppressWarnings("unchecked")
	    @Test
	    public void simpleQuery() {
	        int EXPECTED_BREED_NUMBER = 3;
	        EntityManager em = JPAUtil.getCurrentEntityManager();
	        Query query = em.createQuery("select breed from Breed breed");
	        List<Breed> results = query.getResultList();      
	        Assert.assertEquals(EXPECTED_BREED_NUMBER, results.size());	        
	    }
}
