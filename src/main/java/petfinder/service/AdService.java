package petfinder.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import petfinder.domain.Ad;

/**
 * Η υπηρεσία της αγγελίας. Αναλαμβάνει την αναζήτηση αγγελίας και την καταχώρηση
 * της αγγελίας.
 * 
 * @author Spyros + Manolis + Stefanos
 *
 */

public class AdService  {
	
	private EntityManager em;

	public AdService(EntityManager em) {
		this.em = em;
	}
	
	public Ad save(Ad ad) {

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		if (ad.getID() != null) {
			// beware, always use the result of merge
			ad = em.merge(ad);
		} else {
			em.persist(ad);
		}
		tx.commit();
		return ad;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Ad> findAllAds() {

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		List<Ad> results = null;

		results = em.createQuery("select ad from Ads ad").getResultList();

		tx.commit();
		return results;
	}

	public Ad findAdById(int id) {

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Ad ad = null;
		try {
			ad = em.find(Ad.class, id);
			tx.commit();
		} catch (NoResultException ex) {
			tx.rollback();
		}
		return ad;
	}

	@SuppressWarnings("unchecked")
	public List<Ad> findAdByBreed(String breedName) {

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		List<Ad> results = null;
		results = em.createQuery("") //@ TODO Query join
				// "select b from Book b join fetch b.authors as a where
				// a.person.lastName like :surname ")
				.setParameter("breedName", breedName).getResultList();

		tx.commit();
		return results;
	}

	

	public boolean deleteAd(Ad ad) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		if (ad != null) {
			em.remove(ad);
			return true;
		}
		tx.commit();
		return false;

	}

	public boolean setCompeteAd(int adID) {
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
			Ad ad = em.getReference(Ad.class, adID);
			ad.setActive(false);
		} catch (EntityNotFoundException e) {
			tx.rollback();
			return false;
		}

		tx.commit();

		return true;

	}

}