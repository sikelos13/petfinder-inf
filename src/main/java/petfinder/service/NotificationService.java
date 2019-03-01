package petfinder.service;

import java.util.List;
import petfinder.domain.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import petfinder.contacts.*;
import petfinder.persistence.JPAUtil;


public class NotificationService {

    /*
     * Ενημερώνει όσων
     * η αίτηση δεν έχει εγκριθεί.
     */
    @SuppressWarnings("unchecked")
	public void notifyApplicants() {


		EntityManager em  = JPAUtil.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        List<Adoption> allApplications = em.createQuery("select a from Application List a where a.approvedAd is false")
        	.getResultList();
        
        for (Adoption ad : allApplications) {
            if (ad.isRejected() && ad.getApplicant().getTel() !=null &&
            		ad.getApplicant().getId() != null) {
                String message = composeMessage(ad.getPet(),
                        -ad.reasonForRejection());
                sentText(ad.getApplicant(),"Το αίτημα δεν εγκρίθηκε", message);
            }
        }
        
        tx.commit();
        em.close();
    }
    
	
    private void sentText(Applicant applicant,String subject, String message) {
    	TelephoneNumber phone  = applicant.getTel();
        if (phone == null || !phone.isValid()) {
            return;
        }
        
        TextMessage textMessage = new TextMessage();
        textMessage.setTo(phone);
        textMessage.setSubject(subject);
        textMessage.setBody(message);
        Employee.sendText(textMessage);
    }

    private String composeMessage(Ad ad, int i) {
        String message = "Η αιτηση δεν εκγριθηκε απο τον διαχειριστή για την αγγελία ";
        message += ad.getID();
        return message;
    }
}
