package service;

import java.util.List;
import petfinder.domain.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

//import com.mgiandia.library.LibraryException;
//import com.mgiandia.library.contacts.EmailAddress;
//import com.mgiandia.library.contacts.EmailMessage;
//import com.mgiandia.library.domain.Book;
//import com.mgiandia.library.domain.Borrower;
//import com.mgiandia.library.domain.Loan;
//import com.mgiandia.library.persistence.JPAUtil;


public class NotificationService {
    private EmailProvider provider;
    
    
    /**
     * Θέτει τον πάροχο του ηλεκτρονικού ταχυδρομείου.
     * @param provider Ο πάροχος ηλεκτρονικού ταχυδρομείου.
     */
    public void setProvider(EmailProvider provider) {
        this.provider = provider;
    }

    /**
     * Ενημερώνει όσους.
     * η αίτηση δεν έχει εγκριθεί.
     */
    @SuppressWarnings("unchecked")
	public void notifyApplicants() {
        if (provider == null) {
            throw new LibraryException();
        }

        EntityManager em  = JPAUtil.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        List<AdList> allAds = em.createQuery("select a from AdList a where a.hasBeenAdopted is false")
        	.getResultList();
        
        for (AdList ad : allAds) {
            if (ad.isOverdue() && ad.getApplicant().getEmail()!=null &&
            		ad.getApplicant().getEmail().isValid()) {
                String message = composeMessage(ad.getItem().getPet(),
                        -ad.daysToDue());
                sendEmail(ad.getApplicant(),
                        "Το αίτημα δεν εγκρίθηκε", message);
            }
        }
        
        tx.commit();
        em.close();
    }


    private void sendEmail(Applicant applicant,
            String subject, String message) {
        EmailAddress eMail  = applicant.getEmail();
        if (eMail == null || !eMail.isValid()) {
            return;
        }
        
        EmailMessage emailMessage = new EmailMessage();
        emailMessage.setTo(eMail);
        emailMessage.setSubject(subject);
        emailMessage.setBody(message);
        provider.sendEmail(emailMessage);
    }

    private String composeMessage(Ad ad) {
        String message = "Η αιτηση δεν εκγριθηκε απο τον διαχειριστή για την αγγελία ";
        message += ad.getId();
        return message;
    }
}