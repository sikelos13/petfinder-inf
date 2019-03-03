package petfinder.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import petfinder.domain.Pet;

/**
 * Η υπηρεσία του ζώου. Αναλαμβάνει την αναζήτηση του ζώου και την καταχώρηση
 * του ζώου.
 * 
 * @author Spyros + Manolis + Stefanos
 *
 */

public class PetService {


	private EntityManager em;

	public PetService(EntityManager em) {
		this.em = em;
	}

	public Pet save(Pet pet) {

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		if (pet != null) {
			// beware, always use the result of merge
			pet = em.merge(pet);
		} else {
			em.persist(pet);
		}
		tx.commit();
		return pet;

	}

	@SuppressWarnings("unchecked")
	public List<Pet> findAllPets() {

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		List<Pet> results = null;

		results = em.createQuery("select p from Pets p").getResultList();

		tx.commit();
		return results;
	}

	public Pet findPetById(int id) {

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Pet pet = null;
		try {
			pet = em.find(Pet.class, id);
			tx.commit();
		} catch (NoResultException ex) {
			tx.rollback();
		}
		return pet;
	}

	
	public boolean deletePet(Pet pet) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		if (pet != null) {
			em.remove(pet);
			return true;
		}
		tx.commit();
		return false;

	}

	


}
