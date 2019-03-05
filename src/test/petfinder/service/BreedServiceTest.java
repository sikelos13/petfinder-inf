package petfinder.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import petfinder.domain.*;

public class BreedServiceTest extends PetfinderServiceTest {

	@Test
	public void testFindBreedById() {
		
		BreedService service = new BreedService(em);
		Breed breed = service.findBreedById(0);

		assertNotNull(breed);
//		assertEquals(3, ads.size());
	}

	@Test
	public void testCreateBreed() {

		BreedService service = new BreedService(em);
		Breed testBreed = new Breed();
		 boolean breed = service.createBreed(testBreed);
		
		 assertEquals(true,breed);
//		 assertEquals(1, ads.size());

	}
	
	@Test
	public void testFindAllBreeds() {

		BreedService service = new BreedService(em);
		List<Breed> breed = service.findAllBreeds();
		
		 assertNotNull(breed);

	}
	

}