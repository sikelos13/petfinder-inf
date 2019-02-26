package petfinder.domain;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Ads")
public class Ad {

	private Pet Animal;
	private String Details;
	
	public Ad(Pet pet, String details) {
		Animal = pet;
		Details = details;
	}
	
	public Pet getPet() {
		return Animal;
	}
	
	public String getDetails() {
		return Details;
	}
	
	public void setPet(Pet pet) {
		Animal = pet;
	}
	
	public void setDetails(String details) {
		Details = details;
	}

}
