package service;
import java.util.List;

import javax.persistence.EntityManager;

import petfinder.domain.*;

public class AdoptionService {

	private EntityManager em;

	public AdoptionService(EntityManager em) {
		this.em = em;
	}

	@SuppressWarnings("unchecked")
	public List<Breed> findPetByBreed(String breed_name) {

		List<Breed> results = null;
		results = em
				.createQuery(
						"select b from Breed b where b.breed.BreedName like :name ")
				.setParameter("name", breed_name).getResultList();

		return results;
	}
/*
	public Borrower createBorrower(Map<String, String> data) {
		Borrower b = new Borrower();
		try {
			b.setBorrowerNo(Integer.valueOf(data
					.get(BorrowerInfo.BORROWERNO_KEY)));
			b.setFirstName(data.get(BorrowerInfo.FIRSTNAME_KEY));
			b.setLastName(data.get(BorrowerInfo.LASTNAME_KEY));
			b.setEmail(data.get(BorrowerInfo.EMAIL_KEY));
			b.setTelephone(data.get(BorrowerInfo.TELEPHONE_KEY));
			return b;
		} catch (Exception e) {
			return null;
		}
	}
*/
	public Ad findApplicationById(int id) {
		return em.find(Ad.class, id);
	}

	public boolean serverOnUpdateApplication(Breed b) {

		if (b != null) {
			em.merge(b);
			return true;
		}

		return false;
	}

	/**
	 * Creates a new borrower instance in the database
	 * @param b
	 * @return
	 */
	public boolean createApplication(Ad b) {

		if (b != null) {
			em.persist(b);
			return true;
		}

		return false;
	}
	
	public boolean deleteApplication(Ad b) {

		if (b != null) {
			em.remove(b);
			return true;
		}

		return false;
	}

	public List<AdList> findAllAds() {
		List<AdList> results = null;

		results = em.createQuery("select a from AdList a", AdList.class)
				.getResultList();

		return results;
	}
}