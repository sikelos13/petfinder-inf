package petfinder.service;

import java.util.ArrayList;
import java.util.List;
import petfinder.domain.*;
import petfinder.service.PetFinderException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;


/**
 * Η υπηρεσία οπου καταγράφεται η αίτηση υιοθεσιας. Αναλαμβάνει την αναζήτηση αιτούντων και των 
 * αγγελιών και δημιουργει την αίτηση βαση των Id τους.
 *
 */
public class ApplicationCreationService {
	private Applicant applicant;
	private Ad ad;
	private Adoption adoption;
	private EntityManager em;

	public ApplicationCreationService(EntityManager em) {
		this.em = em;
	}

	/**
	 * Αναζητά τoν Applicant με βάση τον μοναδικό αριθμό id.
	 * 
	 * @param applicantId
	 *            Ο αριθμός applicant
	 * @return {@code true} αν βρεθεί ο applicant
	 */
	public Boolean findApplicant(Long applicantId) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			applicant = em.find(Applicant.class, applicantId);
			tx.commit();
		} catch (NoResultException ex) {
			applicant = null;
			tx.rollback();
		}

		return applicant != null;
	}
	
	public Boolean findAd(Long adId) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			ad = em.find(Ad.class, adId);
			tx.commit();
		} catch (NoResultException ex) {
			ad = null;
			tx.rollback();
		}

		return ad != null;
		
	}


	/**
	 * throws LibraryException with the error message
	 * @param adId
	 * @param applicantId
	 * @return
	 */
	public void createAdoption(Adoption adPet, Long adId, Long applicantId) {

		boolean applicantFound = findApplicant(applicantId);
		boolean adFound = findAd(adId);

		if (!applicantFound) {
			throw new PetFinderException("Applicant with id " + applicantId + "  does not exist.");
		} else if(!adFound) {
			throw new PetFinderException("Pet ad with id" + adId + " does not exist");
		}else if(applicantFound && adFound) {
			Adoption advert = new Adoption(null, null, null, null);
			em.persist(adPet);
		}

	}

//	
//	public boolean createAdoption(Adoption b) {
//
//		if (b != null) {
//			em.persist(b);
//			return true;
//		}
//
//		return false;
//		
//		boolean applicantFound = findApplicant(applicantId);
//
//		if (!applicantFound) {
//			throw new LibraryException("Applicant with id " + applicantId + "  does not exist.");
//		}
//	}
	
	public boolean deleteAdoption(Adoption b) {

		if (b != null) {
			em.remove(b);
			return true;
		}

		return false;
	}
	
}




	
