package petfinder.domain;


import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Ads")
public class Ad {
    
	private int adId;
	private Pet Animal;
	private String Details;
	
	public Ad(Pet pet, String details, int id) {
		this.Animal = pet;
		this.adId = adId;
		this.Details = details;
		createID(); 
	}
	
	public Pet getPet() {
		return Animal;
	}
	
	public int getID() {
		return adId;
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
	
	public void setID(int id) {
		adId = id;
	}
	
	private void createID() {
		adId = 0; //@todo create ID
	}

}
