package petfinder.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Adoption")
public class Adoption {

	
	private Boolean approvedAd;
	private Date adoptionDate;
	private String Details;
	
	
	   @ManyToOne(fetch=FetchType.LAZY)
	    @JoinColumn(name="applicantId")
	    private Applicant applicant;
	   
	   @ManyToOne(fetch=FetchType.LAZY)
	    @JoinColumn(name="adId")
	    private Ad ad;

	
	public Adoption(Date adDate, String details, Boolean approved, Applicant applicant, Ad ad) {
		this.adoptionDate = adDate;
		this.applicant = applicant;
		this.Details = details;
		this.ad = ad;
		this.approvedAd = approved;
	}
	
	public Date getAdoptionDate() {
		return adoptionDate;
	}
	
	public Applicant getApplicant() {
		return applicant;
	}
	
	public Ad getAd() {
		return ad;
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

}
