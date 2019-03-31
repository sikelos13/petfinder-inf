package petfinder.resource;

import petfinder.domain.Pet;

import static petfinder.resource.PetfinderUri.PET;

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

import petfinder.service.PetService;;

@Path(PET)
public class PetResource extends AbstractResource{

	@Context
	UriInfo uriInfo;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<PetInfo> listAllPets() {
		EntityManager em = getEntityManager();
		PetService petService = new PetService(em);
		List<Pet> pets = petService.findAllPets();

		List<PetInfo> petInfo = PetInfo.wrap(pets);

		em.close();
		return petInfo;

	}

	@GET
	@Path("{petID:[0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public PetInfo getPetDetails(@PathParam("petID") int petID) {

		EntityManager em = getEntityManager();

		PetService petService = new PetService(em);
		Pet pet = petService.findPetById(petID);

		PetInfo petInfo = PetInfo.wrap(pet);
		em.close();

		return petInfo;

	}

	@GET
	@Path("search")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PetInfo> searchPetByBreed(@QueryParam("breedName") String breedName) {

		EntityManager em = getEntityManager();
		PetService petService = new PetService(em);
		List<Pet> pets = petService.findPetByBreed(breedName);

		List<PetInfo> petInfo = PetInfo.wrap(pets);

		em.close();
		return petInfo;

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createPet(PetInfo petInfo) {

		EntityManager em = getEntityManager();

		Pet pet = petInfo.getPet(em);

		PetService petService = new PetService(em);
		pet = petService.save(pet);

		UriBuilder ub = uriInfo.getAbsolutePathBuilder();
		URI newPetUri = ub.path(Integer.toString(pet.getID())).build();

		em.close();

		return Response.created(newPetUri).build();
	}

	/**
	 * Update a specific pet
	 * 
	 * @param PetInfo
	 *            A full representation of the pet, including its id should be
	 *            submitted
	 * @return
	 */
	@PUT
	@Path("{petID:[0-9]*}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updatePet(PetInfo petInfo) {

		EntityManager em = getEntityManager();

		Pet pet = petInfo.getPet(em);

		PetService petService = new PetService(em);
		pet = petService.save(pet);

		em.close();

		return Response.ok().build();
	}

	@DELETE
	@Path("{petID:[0-9]*}")
	public Response deleteAdoption(@PathParam("petID") int petID) {

		EntityManager em = getEntityManager();
		
		PetService service = new PetService(em);
		boolean result = service.deletePet(service.findPetById(petID));
		
		if (!result) {
			em.close();
			return Response.status(Status.NOT_FOUND).build();
		}

		em.close();
		return Response.ok().build();

	}
	
}
