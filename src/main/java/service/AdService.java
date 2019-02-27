package service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import petfinder.domain.User;
import petfinder.domain.Breed;

public class AdService  {
	private static final List<Breed> Breed = null;

	private String Details;
	
	private EntityManager pet;

	public AdService(EntityManager pet) {
		this.pet = pet;
	}
	
	
	public List<Breed> findPetByBreed() {
		return Breed;
		
	}
	
	public void findPetByLocation(String petLocation) {
		
	}
	
	public void findPetByName(String petName) {
		
	}


	public AdService(String Breed, String Location, String Name) {
//		super(Breed, Location, Name);
		// TODO Auto-generated constructor stub
	}

}