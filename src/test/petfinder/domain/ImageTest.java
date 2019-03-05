package petfinder.domain;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import petfinder.persistence.Initializer;
import petfinder.persistence.JPAUtil;

public class ImageTest {
	Image image;
	protected EntityManager em;
	
	@Before
	public void setup(){
		// prepare database for each test
		image = new Image(null, null);
		image.setDescription("Healthy");
		image.setUrl("test url");

	}
	
	
	   @Test
	    public void addUrl() {
		     String urlTest = "url Test";
		        image.setUrl(urlTest);
		        Assert.assertEquals(urlTest,image.getUrl());
	    }
	   
	   @Test
	    public void addDescription() {
	        String destcriptionTest = "Test description";
	        image.setDescription(destcriptionTest);
	        Assert.assertEquals(destcriptionTest,image.getDescription());
	    }
	   

}
