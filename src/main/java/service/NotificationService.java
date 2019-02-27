package service;

import java.util.List;
import petfinder.domain.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


public class NotificationService {
//    private String provider;
//    
//    
//    public void setProvider(String provider) {
//        this.employee = employee;
//    }

    /**
     * Ενημερώνει όσους.
     * η αίτηση δεν έχει εγκριθεί.
     */
    @SuppressWarnings("unchecked")
	public void notifyApplicants() {
//        if (provider == null) {
////            throw new LibraryException();
//        }

//        EntityManager em  = JPAUtil.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        List<Adoption> allApplications = em.createQuery("select a from Application List a where a.approvedAd is false")
        	.getResultList();
        
        for (Adoption ad : allApplications) {
            if (ad.isRejected() && Applicant.getApprovement()!=null &&
            		ad.getApprovement().getTel().isValid()) {
                String message = composeMessage(ad.getPet(),
                        -ad.reasonForRejection());
                sentText(ad.getApprovement(),
                        "Το αίτημα δεν εγκρίθηκε", message);
            }
        }
        
        tx.commit();
        em.close();
    }
    
	

    private void sentText(Applicant applicant,
            String subject, String message) {
        Integer phone  = applicant.getTel();
        if (phone == null || !phone.isValid()) {
            return;
        }
        
        String textMessage = new textMessage();
        textMessage.setTo(eMail);
        textMessage.setSubject(subject);
        textMessage.setBody(message);
        Employee.sendText(textMessage);
    }

    private String composeMessage(Ad ad) {
        String message = "Η αιτηση δεν εκγριθηκε απο τον διαχειριστή για την αγγελία ";
        message += ad.getID();
        return message;
    }
}
