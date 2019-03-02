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
        adopt01.setPet(ad01.getPet());
        if(!adopt01.isRejected()) {
        	adopt01.setApplicant(aplcant01);
        	ad01.setActive(false);
        }
        
        Adoption adopt02 = new Adoption();
        adopt02.setDetails("Teleia!");
        adopt02.setPet(ad02.getPet());
        if(!adopt02.isRejected()) {
        	adopt02.setApplicant(aplcant02);
        	ad02.setActive(false);
        }
        
        Adoption adopt03 = new Adoption();
        adopt03.setDetails("Einai dyskolos anthropos. Megali prosoxi!");
        adopt03.setPet(ad03.getPet());
        if(!adopt03.isRejected()) {
        	adopt03.setApplicant(aplcant02);
        	ad03.setActive(false);
        }
        
        
        
        
        EntityManager em = JPAUtil.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        em.persist(manolis);
        em.persist(stefanos);
        em.persist(spyros);
        
        em.persist(zeil);
        em.persist(pet4u);
        
        em.persist(aplcant01);
        em.persist(aplcant02);
        
        
        em.persist(lykoskylo);
        em.persist(labrator);
        em.persist(persias);
        em.persist(kaukasou);
        
        em.persist(lykoskyloPet);
        em.persist(labratorPet);
        em.persist(persiasPet);
        em.persist(kaukasouPet);
        
        em.persist(ad01);
        em.persist(ad02);
        em.persist(ad03);
        em.persist(ad04);
        
        em.persist(adopt01);
        em.persist(adopt02);
        em.persist(adopt03);
        
        
        tx.commit();
        em.close();
    }    

}
