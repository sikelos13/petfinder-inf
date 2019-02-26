package petfinder.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Adoption")
public class Adoption {

	
	
	private Date adoptionDate;
	private String Details;
	
	public Adoption(Date adDate) {
		this(adDate, "");
	}
	
	public Adoption(Date adDate, String details) {
		adoptionDate = adDate;
		Details = details;
	}
	
	public Date getAdoptionDate() {
		return adoptionDate;
	}
	
	public String getDetails() {
		return Details;
	}
	
	public void setAdoptionDate(Date adDate) {
		adoptionDate = adDate;
	}
	
	public void setDetails(String details) {
		Details = details;
	}

}
