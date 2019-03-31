package petfinder.service;

import static org.junit.Assert.assertNotNull;
import java.util.List;

import org.junit.Test;
import petfinder.domain.*;

public class PetServiceTest extends PetfinderServiceTest {

	@Test
	public void testFindPetById() {
		
		PetService service = new PetService(em);
		Pet pet = service.findPetById(0);

		assertNotNull(pet);
//		assertEquals(3, ads.size());
	}

	
	@Test
	public void testFindAllPets() {

		PetService service = new PetService(em);
		List<Pet> pet = service.findAllPets();
		
		 assertNotNull(pet);

	}
	

}