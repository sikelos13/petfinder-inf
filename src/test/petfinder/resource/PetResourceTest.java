package petfinder.resource;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.spi.TestContainerFactory;

import petfinder.persistence.Initializer;

public class PetResourceTest  extends JerseyTest{

	Initializer dataHelper;
	
	
	public PetResourceTest() {
		super();
	}
	
	public PetResourceTest(TestContainerFactory testContainerFactory) {
		super(testContainerFactory);
	}
	
	public PetResourceTest(Application jaxrsApplication) {
		super(jaxrsApplication);
	}
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
		dataHelper = new Initializer();
		dataHelper.prepareData();
	}
	
	

}
