package petfinder.service;


import java.util.ArrayList;
import java.util.List;
import petfinder.domain.*;
import petfinder.service.LibraryException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;


/**
 * Η υπηρεσία του δανεισμού. Αναλαμβάνει την αναζήτηση δανειζομένων και
 * αντιτύπων και καταγράφει τους δανεισμούς
 * 
 * @author Νίκος Διαμαντίδης
 *
 */
public class ApplicationCreationService {
	private Applicant applicant;
	private EntityManager em;

	public ApplicationCreationService(EntityManager em) {
		this.em = em;
	}

	/**
	 * Αναζητά το δανειζόμενο με βάση τον αριθμό δανειζομένου.
	 * 
	 * @param borrowerNo
	 *            Ο αριθμός δανειζομένου
	 * @return {@code true} αν βρεθεί ο δανειζόμενος
	 */
	public Boolean findApplicant(int applicantId) {
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


	/**
	 * throws LibraryException with the error message
	 * @param itemId
	 * @param borrowerNo
	 * @return
	 */
	public void adoptePet(int adId, int applicantId) {

		boolean applicantFound = findApplicant(applicantId);

		if (!applicantFound) {
			throw new LibraryException("Applicant with id " + applicantId + "  does not exist.");
		}

	}

//	@SuppressWarnings("unchecked")
//	public List<Loan> findPendingLoans(boolean overdueOnly) {
//		List<Loan> allLoans = new ArrayList<Loan>();
//
//		Query query = null;
//
//		query = em
//				.createQuery("select loan from Loan loan join fetch loan.borrower b"
//						+ " join fetch loan.item i");
//
//		allLoans = query.getResultList();
//
//		if (!overdueOnly) {
//			return allLoans;
//		} else {
//			List<Loan> overdueLoans = new ArrayList<Loan>();
//
//			for (Loan l : allLoans) {
//
//				if (l.isOverdue()) {
//					overdueLoans.add(l);
//				}
//
//			}
//
//			return overdueLoans;
//		}
//
//	}
	
	public boolean createApplication(Applicant b) {

		if (b != null) {
			em.persist(b);
			return true;
		}

		return false;
	}
	
	public boolean deleteApplication(Applicant b) {

		if (b != null) {
			em.remove(b);
			return true;
		}

		return false;
	}
	
}




	
