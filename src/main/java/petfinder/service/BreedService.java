package petfinder.service;

import petfinder.domain.Breed;

import java.util.List;

import javax.persistence.EntityManager;


/**
 * Η υπηρεσία της ράτσας. Αναλαμβάνει την αναζήτηση ράτσας και την καταχώριση
 * της ράτσας.
 * 
 * @author Spyros + Manolis + Stefanos
 *
 */
public class BreedService {

	
	private EntityManager em;
	
	public BreedService(EntityManager em) {
		this.em = em;
	}
	
	@SuppressWarnings("unchecked")
	public List<Breed> findBreedByName(String breedName) {

		List<Breed> results = null;
		results = em
				.createQuery(
						"select b from breedsList b where b.BreedName like :BreedName ")
				.setParameter("BreedName", breedName).getResultList();

		return results;
	}
	
	public Breed findBreedById(int id) {
		return em.find(Breed.class, id);
	}

	public boolean saveOrUpdateBreed(Breed b) {

		if (b != null) {
			em.merge(b);
			return true;
		}

		return false;
	}

	/**
	 * Creates a new breed instance in the database
	 * @param b
	 * @return
	 */
	public boolean createBreed(Breed b) {

		if (b != null) {
			em.persist(b);
			return true;
		}

		return false;
	}
	
	public boolean deleteBreed(Breed b) {

		if (b != null) {
			em.remove(b);
			return true;
		}

		return false;
	}

	public List<Breed> findAllBreeds() {
		List<Breed> results = null;

		results = em.createQuery("select b from breedsList b", Breed.class)
				.getResultList();

		return results;
	}

}
