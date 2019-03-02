package petfinder.service;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import petfinder.domain.*;

public class AdoptionService {
	
	private Date adoptionDate;

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
	public Ad findAdById(int id) {
		return em.find(Ad.class, id);
	}
	
	public Applicant findApplicantById(int id) {
		return em.find(Applicant.class, id);
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

	public Adoption createAdoption(String strin1, String string, String string2, String string4) {
		
		return null;
	}

}