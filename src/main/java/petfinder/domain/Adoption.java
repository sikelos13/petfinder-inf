package petfinder.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Adoption")
public class Adoption {

	
	private Boolean approvedAd;
	private Date adoptionDate;
	private String Details;
	
	
	public Adoption(Date adDate, String details, Boolean approved) {
		this.adoptionDate = adDate;
		this.Details = details;
		this.approvedAd = approved;
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

	public boolean isRejected() {
		// TODO Auto-generated method stub
		return false;
	}

	public int reasonForRejection() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Ad getPet() {
		// TODO Auto-generated method stub
		return null;
	}

	public Applicant getApplicant() {
		// TODO Auto-generated method stub
		return null;
	}

}
