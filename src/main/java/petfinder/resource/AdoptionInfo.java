package petfinder.resource;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.xml.bind.annotation.XmlRootElement;

import petfinder.domain.Adoption;
import petfinder.domain.Applicant;
import petfinder.domain.Pet;

/**
 * Value object for transferring adoption data over the wire ...
 * 
 *
 */
@XmlRootElement
public class AdoptionInfo {

    private Integer adoptionID;
	private Date adoptionDate = new Date();
	private String Details;
    private Pet pet;
    private Applicant applicant;
	private boolean approved = false;
	
    
    public AdoptionInfo() {
    	
    }
    
    public AdoptionInfo(Adoption ad) {
    	this.adoptionID = ad.getId();
    	this.adoptionDate = ad.getAdoptionDate();
    	this.Details = ad.getDetails();
    	this.pet = ad.getPet();
    	this.applicant = ad.getApplicant();
    	this.approved = !ad.isRejected(); //negative
    }
	
	public AdoptionInfo(Date adDate, String details, Applicant applicant, Pet pet) {
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


	public Pet getPet() {
		return pet;
	}

	public Applicant getApplicant() {
		return applicant;
	}

	
	public boolean isRejected() {
		return approved;
	}
	
	public boolean approve() {
		approved = true;
		return approved;
	}

	public static AdoptionInfo wrap(Adoption b) {
		return new AdoptionInfo(b);
	}

	public static List<AdoptionInfo> wrap(List<Adoption> adoptions) {

		List<AdoptionInfo> adoptionInfoList = new ArrayList<>();

		for (Adoption b : adoptions) {
			adoptionInfoList.add(new AdoptionInfo(b));
		}

		return adoptionInfoList;

	}

	public Adoption getAdoption(EntityManager em) {

		Adoption adoption = null;

		if (adoptionID != null) {
			adoption = em.find(Adoption.class, adoptionID);
		} else {
			adoption = new Adoption();
		}

		return adoption;
	}
}