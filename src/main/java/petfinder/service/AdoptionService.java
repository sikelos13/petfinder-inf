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

}