package petfinder.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class Initializer {

	public static final int SPYROS_ID = 1;
    public static final int STEFANOS_ID = 2;
    public static final int MANOLIS_ID = 3;
    
    
    //διαγράφουμε όλα τα δεδομένα στη βάση δεδομένων
    public void  eraseData() {
        EntityManager em = JPAUtil.getCurrentEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        Query query = em.createNativeQuery("delete from ");
        query.executeUpdate();
        
        tx.commit();
        em.close();
    }
    
    
  
    
    public void prepareData() {

        // πριν εισάγουμε τα δεδομένα διαγράφουμε ότι υπάρχει
        eraseData();                      
        /*Author booch = new Author("Booch", "Grady");
        Author rumbaugh = new Author("Rumbaugh", "James");
        Author jacobson = new Author("Jacobson", "Ivar");
        Author fowler = new Author("Martin", "Fowler");
        
        Publisher addisonWesley = new Publisher("Addison Wesley", null, null, null);
        
        Book umlUserGuide = new Book("The Unified Modeling Language User Guide", 
                new ISBN("1"), "2", 2005, addisonWesley);
        umlUserGuide.addAuthor(booch);
        umlUserGuide.addAuthor(rumbaugh);
        umlUserGuide.addAuthor(jacobson);
        
        
        Book umlDistilled = new Book("UML Distilled", new ISBN("2"), "3", 2004, addisonWesley);
        umlDistilled.addAuthor(fowler);
        
        Book refactoring = new Book("Refactoring: Improving the Design of Existing Code", 
                new ISBN("3"), "1", 1999, addisonWesley);
        
        
        Item umlUserGuideItem1 = new Item(UML_USER_GUIDE_ID1);
        umlUserGuideItem1.setBook(umlUserGuide);
        umlUserGuideItem1.available();
        
        
        Item umlDistilledItem2 = new Item(UML_DISTILLED_ID1);
        umlDistilledItem2.setBook(umlDistilled);
        umlDistilledItem2.available();
        
        Item refactoringItem3 = new Item(UML_REFACTORING_ID);
        refactoringItem3.setBook(refactoring);
        refactoringItem3.available();
        
        Item umlUserGuideItem4 = new Item(UML_USER_GUIDE_ID2);
        umlUserGuideItem4.setBook(umlUserGuide);
        umlUserGuideItem4.available();
        
        Item umlDistilledItem5 = new Item(UML_DISTILLED_ID2);
        umlDistilledItem5.setBook(umlDistilled);
        umlDistilledItem5.available();
        
        EntityManager em = JPAUtil.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        em.persist(umlUserGuideItem1);
        em.persist(umlDistilledItem2);
        em.persist(refactoringItem3);
        em.persist(umlUserGuideItem4);
        em.persist(umlDistilledItem5);
        
        
        BorrowerCategory professor = new BorrowerCategory("Καθηγητής", 180 , 6, Money.euros(0));
        BorrowerCategory undergraduate = new BorrowerCategory("Φοιτητής", 7 , 4, Money.euros(5));
        
        Borrower mgia = new Borrower(GIAKOUMAKIS_ID,"Μανόλης", "Γιακουμάκης", null, new EmailAddress("mgia@aueb.gr"), null);
        mgia.setCategory(professor);
        
        Borrower ndia = new Borrower(DIAMANTIDIS_ID, "Νίκος", "Διαμαντίδης",null, new EmailAddress("nad@aueb.gr"), null);
        ndia.setCategory(undergraduate);*/
        
        //em.persist(mgia);
        //em.persist(ndia);
        //tx.commit();
        //em.close();
    }    

}
