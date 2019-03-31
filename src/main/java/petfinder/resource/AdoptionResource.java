package petfinder.resource;

import petfinder.domain.Adoption;

import static petfinder.resource.PetfinderUri.ADOPTION;

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

import petfinder.service.AdoptionService;;

@Path(ADOPTION)
public class AdoptionResource extends AbstractResource{

	@Context
	UriInfo uriInfo;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<AdoptionInfo> listAllAdoptions() {
		EntityManager em = getEntityManager();
		AdoptionService adoptionService = new AdoptionService(em);
		List<Adoption> adoptions = adoptionService.findAllAdoptions();

		List<AdoptionInfo> bookInfo = AdoptionInfo.wrap(adoptions);

		em.close();
		return bookInfo;

	}

	@GET
	@Path("{adoptionID:[0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public AdoptionInfo getBookDetails(@PathParam("adoptionID") int adoptionID) {

		EntityManager em = getEntityManager();

		AdoptionService adoptionService = new AdoptionService(em);
		Adoption adoption = adoptionService.findAdById(adoptionID);

		AdoptionInfo adoptionInfo = AdoptionInfo.wrap(adoption);
		em.close();

		return adoptionInfo;

	}

	@GET
	@Path("search")
	@Produces(MediaType.APPLICATION_JSON)
	public List<AdoptionInfo> searchAdoptionByStatus(@QueryParam("approved") boolean approved) {

		EntityManager em = getEntityManager();
		AdoptionService adoptionService = new AdoptionService(em);
		List<Adoption> adoptions = adoptionService.findAdByStatus(approved);

		List<AdoptionInfo> adoptionInfo = AdoptionInfo.wrap(adoptions);

		em.close();
		return adoptionInfo;

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createAdoption(AdoptionInfo adoptionInfo) {

		EntityManager em = getEntityManager();

		Adoption adoption = adoptionInfo.getAdoption(em);

		AdoptionService adoptionService = new AdoptionService(em);
		adoption = adoptionService.save(adoption);

		UriBuilder ub = uriInfo.getAbsolutePathBuilder();
		URI newAdoptionUri = ub.path(Integer.toString(adoption.getId())).build();

		em.close();

		return Response.created(newAdoptionUri).build();
	}

	/**
	 * Update a specific book
	 * 
	 * @param bookInfo
	 *            A full representation of the adoption, including its id should be
	 *            submitted
	 * @return
	 */
	@PUT
	@Path("{adoptionID:[0-9]*}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateAdoption(AdoptionInfo adoptionInfo) {

		EntityManager em = getEntityManager();

		Adoption adoption = adoptionInfo.getAdoption(em);

		AdoptionService adoptionService = new AdoptionService(em);
		adoption = adoptionService.save(adoption);

		em.close();

		return Response.ok().build();
	}

	@DELETE
	@Path("{adoptionID:[0-9]*}")
	public Response deleteAdoption(@PathParam("adoptionID") int adoptionID) {

		EntityManager em = getEntityManager();
		
		AdoptionService service = new AdoptionService(em);
		boolean result = service.deleteAdoption(adoptionID);
		
		if (!result) {
			em.close();
			return Response.status(Status.NOT_FOUND).build();
		}

		em.close();
		return Response.ok().build();

	}
	
}
