package petfinder.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Η υιοθεσία ενός κατοικιδίου
 * Καταγράφει το γεγονός της υιοθεσίας.
 *
 */

@Entity
@Table(name = "adoptions")
public class Adoption {

	@Id 
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	
	private Boolean approvedAd;
	
	@Column(name="adoptionDate")
	private Date adoptionDate = new Date();
	private String Details;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="petId")
    private Pet pet;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="applicantId")
    private Applicant applicant;
	
	
	public Adoption(Date adDate, String details, Applicant applicant, Pet pet) {
		this.adoptionDate = adDate;
		this.Details = details;
		this.setApprovement(true);
		this.applicant = applicant;
		this.pet = pet;
	}
	
	public Integer getId() {
        return id;
    }
	
	public Date getAdoptionDate() {
		return adoptionDate;
	}
	
	public String getDetails() {
		return Details;
	}
	
	public Boolean getApprovement() {
		return approvedAd;
	}

	public void setApprovement(Boolean approved) {
		approvedAd = approved;
	}
	
	public void setAdoptionDate(Date adDate) {
		adoptionDate = adDate;
	}
	
	public void setDetails(String details) {
		Details = details;
	}

	
	 /**
     * Θέτει τo applicant της υιοθεσίας.
     * @param applicant Ο applicant της υιοθεσίας
     * @see Borrower#getLoans()
     */
    protected void setApplicant(Applicant applicant) {
        if (this.applicant != null) {
            this.applicant.listOfPets.remove(pet);
        }
        this.applicant = applicant;
        if (applicant != null) {
            this.applicant.PetAdoption(pet);
        }
    }

	public Pet getPet() {
		return pet;
	}

	public Applicant getApplicant() {
		return applicant;
	}

}
