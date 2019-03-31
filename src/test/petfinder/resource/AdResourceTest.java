package petfinder.resource;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.server.ResourceConfig;
import org.junit.Assert;
import org.junit.Test;

import petfinder.domain.*;
import petfinder.persistence.JPAUtil;

public class AdResourceTest extends PetfinderResourceTest {
	private Date testDate = new Date();
	@Override
	protected Application configure() {

		return new ResourceConfig(AdResourceTest.class, DebugExceptionMapper.class);
	}
	
	@Test
	public void testCreateNewAd() {
		EntityManager em = JPAUtil.getCurrentEntityManager(); 
		List<Ad> adList = em.createQuery("select t from Ad t").getResultList();
		Assert.assertEquals(4, adList.size());
		
		AdoptionInfo adoptionInfo = new AdoptionInfo(testDate,"detailsTest",null,null);
		

		Response response = target(PetfinderUri.adUri(null)).request()
				.post(Entity.entity(adoptionInfo, MediaType.APPLICATION_JSON));
		
		Assert.assertEquals(response.getStatus(), Status.CREATED.getStatusCode());
		
		String location = response.getHeaderString(HttpHeaders.LOCATION);
		Assert.assertNotNull(location);
		
		List<Ad> tanklist2 = em.createQuery("select t from Tank t").getResultList();
		Assert.assertEquals(5, tanklist2.size());
		
		em.clear();
	}
	
	@Test
	public void testRemoveAd() {
		EntityManager em = JPAUtil.getCurrentEntityManager();
		List<Ad> tanklist = em.createQuery("select t from Tank t").getResultList();
		Assert.assertEquals(4, tanklist.size());

		Response response = target(PetfinderUri.adUri(Integer.toString(4)))
				.request().delete();
		Assert.assertEquals(response.getStatus(), Status.OK.getStatusCode());

		List<Ad> tanklist2 = em.createQuery("select t from Fuel t").getResultList();
		Assert.assertEquals(3, tanklist2.size());
	}
	
	@Test
	public void testListAllTanks() {
		
		//List<Tank> tank = target(Tank).request().get(new GenericType<List<Tank>>() {});
		//Assert.assertEquals(4, tank.size());
	}

}
