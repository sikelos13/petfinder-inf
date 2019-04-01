package petfinder.resource;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.spi.TestContainerFactory;

import petfinder.persistence.Initializer;

public class PetfinderResourceTest  extends JerseyTest{

	Initializer dataHelper;
	
	
	public PetfinderResourceTest() {
		super();
	}
	
	public PetfinderResourceTest(TestContainerFactory testContainerFactory) {
		super(testContainerFactory);
	}
	
	public PetfinderResourceTest(Application jaxrsApplication) {
		super(jaxrsApplication);
	}
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
		dataHelper = new Initializer();
		dataHelper.prepareData();
	}
	
	

}
