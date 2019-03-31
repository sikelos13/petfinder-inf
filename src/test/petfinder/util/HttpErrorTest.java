package petfinder.util;

import javax.persistence.EntityManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class HttpErrorTest {
	private HttpError errorCode;
	private String message;
	protected EntityManager em;
	
	@Before
	public void setup(){
		// prepare database for each test
		  	errorCode = new HttpError();
	 
		
	}
	
	
	   @Test
	    public void addErrorCode() {
	        HttpError error = new HttpError();
	        error.setErrorCode(400);
	        Assert.assertEquals(400,error.getErrorCode());
	    }
	   
	   @Test
	    public void addMessage() {
	        message = "test string for error class";
	        HttpError error = new HttpError();
	        error.setMessage(message);
	        Assert.assertEquals("test string for error class",error.getMessage());
	    }
	   
	   

}
