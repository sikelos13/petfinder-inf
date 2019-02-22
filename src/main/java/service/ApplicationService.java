/**
 * 
 */
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import petfinder.domain.User;
import petfinder.domain.Breed;

public class ApplicationService  {
	
	
	private EntityManager pet;

	public ApplicationService(EntityManager pet) {
		this.pet = pet;
	}
	
	
	public List<Breed> findPetByBreed() {
		
	}
	
	public void findPetByLocation(String petLocation) {
		
	}
	
	public void findPetByName(String petName) {
		
	}


	public ApplicationService(String Breed, String Location, String Name) {
		super(Breed, Location, Name);
		// TODO Auto-generated constructor stub
	}

}