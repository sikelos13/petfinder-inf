package petfinder.service;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;

import petfinder.domain.*;

public class AdoptionService {
	
	private Date adoptionDate;

	private EntityManager em;

	public AdoptionService(EntityManager em) {
		this.em = em;
	}
	
	public Adoption save(Adoption adoption) {

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		if (adoption.getId() != null) {
			// beware, always use the result of merge
			adoption = em.merge(adoption);
		} else {
			em.persist(adoption);
		}
		tx.commit();
		return adoption;

	}
	
	public boolean deleteAdoption(int adoptionID) {
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
			Adoption adoption = em.getReference(Adoption.class, adoptionID);
			em.remove(adoption);
		} catch (EntityNotFoundException e) {
			tx.rollback();
			return false;
		}

		tx.commit();

		return true;

	}


	public Adoption findAdById(int id) {
		return em.find(Adoption.class, id);
	}
	

	public boolean serverOnUpdateAdoption(Adoption adoption) {

		if (adoption != null) {
			em.merge(adoption);
			return true;
		}

		return false;
	}

	/**
	 * Update Adoption with data
	 * @param adoption
	 * @return status
	 */
	public boolean approveAdoption(Adoption adoption) {

		if (adoption != null) {
			adoption.getPet().setHasBeenAdopted(true);
			adoption.getApplicant().PetAdoption(adoption.getPet());
			em.persist(adoption);
			return true;
		}

		return false;
	}
	
	/**
	 * Update Adoption with data.  Αpprove adoption
	 * @param adoption, ad
	 * @return status
	 */
	public boolean approveAdoption(Adoption adoption, Ad ad) {

		if (adoption != null) {
			ad.setActive(false);
			adoption.getPet().setHasBeenAdopted(true);
			adoption.getApplicant().PetAdoption(adoption.getPet());
			em.persist(adoption);
			return true;
		}

		return false;
	}
	
	public boolean rejectAdoption(Adoption adoption) {

		if (adoption != null) {
			adoption.getPet().setHasBeenAdopted(false);
			em.remove(adoption);
			return true;
		}

		return false;
	}
	
	public boolean rejectAdoption(Adoption adoption, Ad ad) {

		if (adoption != null) {
			adoption.getPet().setHasBeenAdopted(false);
			ad.setActive(true);
			em.remove(adoption);
			return true;
		}

		return false;
	}

	@SuppressWarnings("unchecked")
	public List<Adoption> findAllAdoptions() {
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		List<Adoption> results = null;

		results = em.createQuery("select a from Adoption a").getResultList();
		tx.commit();
		return results;

	}


	@SuppressWarnings("unchecked")
	public List<Adoption> findAdByStatus(boolean approved) {
		// TODO Alter query
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		List<Adoption> results = null;

		results = em.createQuery("select a from Adoption a").getResultList();
		tx.commit();
		return results;
	}

}