package petfinder.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
    @Column(name="adoptionID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer adoptionID;
	
	
	@Column(name="adoptionDate")
	private Date adoptionDate = new Date();
	private String Details;
	
	
	@OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="petID")
    private Pet pet;
    

	@OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="applicantID")
    private Applicant applicant;
	
	private boolean approved = false;
	
    
    public Adoption() {
    	
    }
	
	public Adoption(Date adDate, String details, Applicant applicant, Pet pet) {
		this.adoptionDate = adDate;
		this.Details = details;
		this.applicant = applicant;
		this.pet = pet;
	}
	
	public Integer getId() {
        return adoptionID;
    }
	
	public Date getAdoptionDate() {
		return adoptionDate;
	}
	
	public String getDetails() {
		return Details;
	}
	
	public void setPet(Pet pet) {
		this.pet = pet;
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
     */
    public void setApplicant(Applicant applicant) {
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

	public int reasonForRejection() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public boolean isRejected() {
		return approved;
	}
	
	public boolean approve() {
		approved = true;
		return approved;
	}

	

}
