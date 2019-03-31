package petfinder.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.List;

import org.junit.Test;
import petfinder.domain.*;

public class AdServiceTest extends PetfinderServiceTest {
	
	@Test
	public void testFindAllAds() {
		
		AdService service = new AdService(em);
		List<Ad> ads = service.findAllAds();

		assertNotNull(ads);
//		assertEquals(3, ads.size());
	}

	@Test
	public void testFindAdById() {

		 AdService service = new AdService(em);
		 Ad ads = service.findAdById(1);
		
		 assertNotNull(ads);
//		 assertEquals(1, ads.size());

	}
	
	@Test
	public void testFindAdByBreed() {

		 AdService service = new AdService(em);
		 Breed breedTest = new Breed();
		 List<Ad> ad = service.findAdByBreed(breedTest.getBreedName());
		
		 assertNotNull(ad);

	}
	
	@Test
	public void testSetCompeteAd() {

		 AdService service = new AdService(em);
		 Ad adTest = new Ad(null, null, null);
		 Boolean ad = service.setCompeteAd(adTest.getID());
		
		 assertEquals(true, ad);

	}

}