package petfinder.contacts;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TextMessageTest {
	TextMessage message;

	protected EntityManager em;
	
	@Before
	public void setup(){
		// prepare database for each test
		  	message = new TextMessage();
		  	message.setFrom("Stefanos");
		  	message.setTo("Spuros");
		  	message.setSubject("Test subject");
		  	message.setBody("Test body");
		
	}
	
	
	   @Test
	    public void addFrom() {
		   	String testMessage = "Stefanos";
		  	message = new TextMessage();
	        message.setFrom(testMessage);
	        Assert.assertEquals(testMessage,message.getFrom());
	    }
	   
	   @Test
	    public void addTo() {
		 	String testMessage = "Spuros";
		  	message = new TextMessage();
	        message.setTo(testMessage);
	        Assert.assertEquals(testMessage,message.getTo());
	    }
	   
	   @Test
	    public void addSubject() {
		   	String testMessage = "Test subject";
		  	message = new TextMessage();
	        message.setSubject(testMessage);
	        Assert.assertEquals(testMessage,message.getSubject());
	    }
	   
	   @Test
	    public void addBody() {
			String testMessage = "Test body";
		  	message = new TextMessage();
	        message.setBody(testMessage);
	        Assert.assertEquals(testMessage,message.getBody());
	    }
	   

}
