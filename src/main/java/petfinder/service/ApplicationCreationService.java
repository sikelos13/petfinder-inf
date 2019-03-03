package petfinder.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import petfinder.domain.*;

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
	private Date adDate;
	private String details;
	private Pet pet;

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
	public Adoption createApplication(Ad adPet, Long adId, Long applicantId) {
		Adoption application = new Adoption(null, null, null, null);


		boolean applicantFound = findApplicant(applicantId);
		boolean adFound = findAd(adId);

		if (!applicantFound) {
			throw new ThrowAnException("Applicant with id " + applicantId + "  does not exist.");
		} else if(!adFound) {
			throw new ThrowAnException("Pet ad with id" + adId + " does not exist");
		}else if(applicantFound && adFound) {
			application = new Adoption();
			em.persist(application);

		}
//		return adPet;
		return application;

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




	
