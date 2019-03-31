package petfinder.resource;

import petfinder.domain.Ad;

import static petfinder.resource.PetfinderUri.AD;

import java.net.URI;
import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import petfinder.service.AdService;;

@Path(AD)
public class AdResource extends AbstractResource{

	@Context
	UriInfo uriInfo;

	@GET
	@Path("{adID:[0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public AdInfo getAdDetails(@PathParam("adID") int adID) {

		EntityManager em = getEntityManager();

		AdService adService = new AdService(em);
		Ad ad = adService.findAdById(adID);

		AdInfo adInfo = AdInfo.wrap(ad);
		em.close();

		return adInfo;

	}

	@GET
	@Path("search")
	@Produces(MediaType.APPLICATION_JSON)
	public List<AdInfo> searchAdByStatus(@QueryParam("breedName") String breedName) {

		EntityManager em = getEntityManager();
		AdService adService = new AdService(em);
		List<Ad> ads = adService.findAdByBreed(breedName);

		List<AdInfo> adInfo = AdInfo.wrap(ads);

		em.close();
		return adInfo;

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createAd(AdInfo adInfo) {

		EntityManager em = getEntityManager();

		Ad ad = adInfo.getAd(em);

		AdService adService = new AdService(em);
		ad = adService.save(ad);

		UriBuilder ub = uriInfo.getAbsolutePathBuilder();
		URI newAdUri = ub.path(Integer.toString(ad.getID())).build();

		em.close();

		return Response.created(newAdUri).build();
	}

	/**
	 * Update a specific ad
	 * 
	 * @param AdInfo
	 *            A full representation of the ad, including its id should be
	 *            submitted
	 * @return
	 */
	@PUT
	@Path("{adID:[0-9]*}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateAd(AdInfo adInfo) {
 
		EntityManager em = getEntityManager();

		Ad ad = adInfo.getAd(em);

		AdService adService = new AdService(em);
		ad = adService.save(ad);

		em.close();

		return Response.ok().build();
	}

	@DELETE
	@Path("{adID:[0-9]*}")
	public Response deleteAd(@PathParam("adID") int adID) {

		EntityManager em = getEntityManager();
		
		AdService service = new AdService(em);
		
		boolean result = service.deleteAd(service.findAdById(adID));
		
		if (!result) {
			em.close();
			return Response.status(Status.NOT_FOUND).build();
		}

		em.close();
		return Response.ok().build();

	}
	
}
