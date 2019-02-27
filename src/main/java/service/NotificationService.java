package service;

import java.util.List;
import petfinder.domain.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


public class NotificationService {
    private String provider;
    
    
    /**
     * Θέτει τον πάροχο του ηλεκτρονικού ταχυδρομείου.
     * @param provider Ο πάροχος ηλεκτρονικού ταχυδρομείου.
     */
    public void setProvider(String provider) {
        this.provider = provider;
    }

    /**
     * Ενημερώνει όσους.
     * η αίτηση δεν έχει εγκριθεί.
     */
    @SuppressWarnings("unchecked")
	public void notifyApplicants() {
        if (provider == null) {
//            throw new LibraryException();
        }

        EntityManager em  = JPAUtil.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        List<AdList> allAds = em.createQuery("select a from AdList a where a.hasBeenAdopted is false")
        	.getResultList();
        
        for (AdList ad : allAds) {
            if (ad.isRejected() && ad.getApplicant().getEmail()!=null &&
            		ad.getApplicant().getEmail().isValid()) {
                String message = composeMessage(ad.getPet(),
                        -ad.reasonForRejection());
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
        message += ad.getID();
        return message;
    }
}