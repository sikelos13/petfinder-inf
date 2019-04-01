package petfinder.service;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import petfinder.domain.*;

public class AdoptionServiceTest extends PetfinderServiceTest {

	@Test
	public void testFindByIdAdoption() {
		
		AdoptionService service = new AdoptionService(em);
		Adoption adoption = service.findAdById(0);

		assertNotNull(adoption);
//		assertEquals(3, ads.size());
	}

	@Test
	public void testΑpproveAdoption() {

		AdoptionService service = new AdoptionService(em);
		Adoption adoptionTest = new Adoption();
		 boolean adoption = service.approveAdoption(adoptionTest);
		
		 assertNotNull(adoption);
//		 assertEquals(1, ads.size());

	}
	
	@Test
	public void testRejectAdoption() {

		AdoptionService service = new AdoptionService(em);
		Adoption adoptionTest = new Adoption();
		 boolean adoption = service.rejectAdoption(adoptionTest);
		
		 assertNotNull(adoption);

	}
	

}