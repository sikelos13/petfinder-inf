package petfinder.resource;

import java.util.List;


import javax.persistence.EntityManager;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.Date;

import org.glassfish.jersey.server.ResourceConfig;
import org.junit.Assert;
import org.junit.Test;


import petfinder.domain.*;
import petfinder.persistence.JPAUtil;



public class AdoptionResourceTest extends PetResourceTest {
	private Date testDate = new Date();
	@Override
	protected Application configure() {

		return new ResourceConfig(AdoptionResourceTest.class, DebugExceptionMapper.class);
	}
	
	@Test
	public void testCreateNewAdoption() {
		EntityManager em = JPAUtil.getCurrentEntityManager(); 
		List<Adoption> adoptionList = em.createQuery("select t from Adoption t").getResultList();
		Assert.assertEquals(3, adoptionList.size());
		
		AdoptionInfo adoptionInfo = new AdoptionInfo(testDate,"detailsTest",null,null);
		
		Response response = target(PetfinderUri.adUri(null)).request()
				.post(Entity.entity(adoptionInfo, MediaType.APPLICATION_JSON));
		
		
		Assert.assertEquals(response.getStatus(), Status.CREATED.getStatusCode());
		String location = response.getHeaderString(HttpHeaders.LOCATION);
		Assert.assertNotNull(location);
		
		List<Adoption> adoptionList2 = em.createQuery("select t from Adoption t").getResultList();
		Assert.assertEquals(4, adoptionList2.size());
		
		em.clear();
	}
	
	@Test
	public void testRemoveAdoption() {
		EntityManager em = JPAUtil.getCurrentEntityManager();
		List<Adoption> adoptionList = em.createQuery("select t from Adoption t").getResultList();
		Assert.assertEquals(3, adoptionList.size());
			
		Response response = target(PetfinderUri.adUri(Integer.toString(3)))
				.request().delete();
		Assert.assertEquals(response.getStatus(), Status.OK.getStatusCode());

		List<Adoption> adoptionList2 = em.createQuery("select t from Adoption t").getResultList();
		Assert.assertEquals(2, adoptionList2.size());
	}
	
}
