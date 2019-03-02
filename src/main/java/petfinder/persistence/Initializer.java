package petfinder.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import petfinder.domain.Ad;
import petfinder.domain.Adoption;
import petfinder.domain.AnimalWelfare;
import petfinder.domain.Applicant;
import petfinder.domain.Breed;
import petfinder.domain.Employee;
import petfinder.domain.Pet;

public class Initializer {

	public static final int SPYROS_ID = 1;
    public static final int STEFANOS_ID = 2;
    public static final int MANOLIS_ID = 3;
    
    
    //διαγράφουμε όλα τα δεδομένα στη βάση δεδομένων
    public void  eraseData() {
        EntityManager em = JPAUtil.getCurrentEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        Query query = em.createNativeQuery("delete from Ads");
        query.executeUpdate();
        
        query = em.createNativeQuery("delete from adoptions");
        query.executeUpdate();
        
        query = em.createNativeQuery("delete from AnimalWelfareList");
        query.executeUpdate();

        query = em.createNativeQuery("delete from applicants");
        query.executeUpdate();

        query = em.createNativeQuery("delete from breedsList");
        query.executeUpdate();

        query = em.createNativeQuery("delete from employees");
        query.executeUpdate();

        query = em.createNativeQuery("delete from Images");
        query.executeUpdate();
        
        query = em.createNativeQuery("delete from Pets");
        query.executeUpdate();
        
        tx.commit();
        em.close();
    }
    
    
  
    
    public void prepareData() {

        // πριν εισάγουμε τα δεδομένα διαγράφουμε ότι υπάρχει
        eraseData();                      
        
        Employee manolis = new Employee("Manolis Linardakis", "6988899001", "manolislinardakis@gmail.com", "Manager 01");
        Employee stefanos = new Employee("Stefanos Athanasoylias", "6988899002", "stef.athanasoulias@gmail.com", "Manager 02");
        Employee spyros = new Employee("Spyros Diamantis", "6988899003", "spyrosdiam@gmail.com", "Manager 03");
        
        
        AnimalWelfare zeil = new AnimalWelfare("Zeil Pets", "2109988123", "zeil@yahoo.gr", "Alekou Keta 10 TK 12999", "Greece", "Ilioupoli");
        AnimalWelfare pet4u = new AnimalWelfare("Pet For you", "2109988233", "pet4u@yahoo.gr", "Zaxou 99 TK 14839", "Greece", "Thessaloniki");
        
        Applicant aplcant01 = new Applicant("Maria Athanasiou", "6978899111", "mariaath@gmail.com", "Greece", "Larissa", "Larissa", "Mitropoleos 23 TK 43211", 86, 200, 6);
        Applicant aplcant02 = new Applicant("Elena Papadea", "6943899111", "elena@gmail.com", "Greece", "Volos", "Nea Ionia", "Iolkou 100 TK 23211", 120, 130, 10);
        
        Breed labrator = new Breed("Labrator", "Dog", 20, true, 2, 100);
        Pet labratorPet = new Pet(labrator, "Ygeiestato", 4, 10, false);
        Breed lykoskylo = new Breed("Lykoskylo", "Dog", 20, false, 3, 150);
        Pet lykoskyloPet = new Pet(lykoskylo, "Ygeiestato", 3, 7, false);
        Breed persias = new Breed("Persias", "Cat", 5, false, 2, 40);
        Pet persiasPet = new Pet(persias, "Xtyphmeno", 2, 2, false);
        Breed kaukasou = new Breed("Kaukasou", "Cat", 6, true, 6, 60);
        Pet kaukasouPet = new Pet(kaukasou, "Ygeiestato", 3, 4, false);
        
        labrator.addNonCompBreed(persias);
        labrator.addNonCompBreed(kaukasou);
        lykoskylo.addNonCompBreed(kaukasou);
        lykoskylo.addNonCompBreed(persias);
        persias.addNonCompBreed(lykoskylo);
        persias.addNonCompBreed(labrator);
        kaukasou.addNonCompBreed(labrator);
        
        Ad ad01 = new Ad(labratorPet, "Filiko Zwo. Fylakas spitiou", manolis);
        Ad ad02 = new Ad(lykoskyloPet, "Filiko Zwo. Trwei arketa. Fylakas spitiou", stefanos);
        Ad ad03 = new Ad(persiasPet, "Trwei arketa.", spyros);
        Ad ad04 = new Ad(kaukasouPet, "Madaei trixes.", spyros);
        
        lykoskyloPet.addImage("https://imagebank.gr/dog01.png", "Profile");
        lykoskyloPet.addImage("https://imagebank.gr/dog02.png", "Profile");
        labratorPet.addImage("https://imagebank.gr/dog03.png", "Profile");
        persiasPet.addImage("https://imagebank.gr/dog04.png", "Profile");
        persiasPet.addImage("https://imagebank.gr/dog05.png", "Profile");
        kaukasouPet.addImage("https://imagebank.gr/dog06.png", "Profile");
        
        Adoption adopt01 = new Adoption();
        adopt01.setDetails("Me epoptia");
        adopt01.setPet(lykoskyloPet);
        if(!adopt01.isRejected()) {
        	adopt01.setApplicant(aplcant01);
        }
        
        Adoption adopt02 = new Adoption();
        adopt02.setDetails("Teleia!");
        adopt02.setPet(labratorPet);
        if(!adopt02.isRejected()) {
        	adopt02.setApplicant(aplcant02);
        }
        
        
        /*Book umlUserGuide = new Book("The Unified Modeling Language User Guide", 
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
