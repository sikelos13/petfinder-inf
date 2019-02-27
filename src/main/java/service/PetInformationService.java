package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import petfinder.domain.Pet;
public class PetInformationService {

	private EntityManager em;

	public PetInformationService(EntityManager em) {
		this.em = em;
	}

	public Pet save(Pet pet) {

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		if (pet.getID() != 0) {
			// beware, always use the result of merge
			pet = em.merge(pet);
		} else {
			em.persist(pet);
		}
		tx.commit();
		return pet;

	}

	@SuppressWarnings("unchecked")
	public List<Pet> findAllAnimals() {

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		List<Pet> results = null;

		results = em.createQuery("select p from Publisher p").getResultList();

		tx.commit();
		return results;
	}

	public Pet findPetById(int petId) {

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Pet id = null;
		try {
			id = em.find(Pet.class, id);
			tx.commit();
		} catch (NoResultException ex) {
			tx.rollback();
		}
		return id;
	}
	
	public Pet changePetInformation() {
		return null;

	}

//	@SuppressWarnings("unchecked")
//	public List<Book> findBooksByAuthor(String authorName) {
//
//		EntityTransaction tx = em.getTransaction();
//		tx.begin();
//		List<Book> results = null;
//		results = em.createQuery("select books from Author a where a.person.lastName like :surname ")
//				// "select b from Book b join fetch b.authors as a where
//				// a.person.lastName like :surname ")
//				.setParameter("surname", authorName).getResultList();
//
//		tx.commit();
//		return results;
//	}

//	@SuppressWarnings("unchecked")
//	public List<Book> findBooksByTitle(String title) {
//		EntityTransaction tx = em.getTransaction();
//		tx.begin();
//		List<Book> results = null;
//
//		results = em.createQuery("select b from Book b join fetch b.publisher p where b.title like :title")
//				// "select b from Book b left join fetch b.authors where b.title
//				// like :title")
//				.setParameter("title", "%" + title + "%").getResultList();
//		tx.commit();
//		return results;
//	}

//	@SuppressWarnings("unchecked")
//	public List<Book> findAllBooks() {
//		EntityTransaction tx = em.getTransaction();
//		tx.begin();
//		List<Book> results = null;
//
//		results = em.createQuery("select b from Book b").getResultList();
//		tx.commit();
//		return results;
//	}

//	public boolean deleteBook(Book b) {
//		EntityTransaction tx = em.getTransaction();
//		tx.begin();
//		if (b != null) {
//			em.remove(b);
//			return true;
//		}
//		tx.commit();
//		return false;
//
//	}
//
//	public boolean deleteBook(int bookId) {
//		
//		EntityTransaction tx = em.getTransaction();
//		tx.begin();
//
//		try {
//			Book book = em.getReference(Book.class, bookId);
//			em.remove(book);
//		} catch (EntityNotFoundException e) {
//			tx.rollback();
//			return false;
//		}
//
//		tx.commit();
//
//		return true;
//
//	}

}