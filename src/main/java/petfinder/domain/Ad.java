package petfinder.domain;


import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Ads")
public class Ad {
    
	private int Id;
	private Pet Animal;
	private String Details;
	
	public Ad(Pet pet, String details) {
		Animal = pet;
		Details = details;
		createID(); 
	}
	
	public Pet getPet() {
		return Animal;
	}
	
	public int getID() {
		return Id;
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
		Id = id;
	}
	
	private void createID() {
		Id = 0; //@todo create ID
	}

}
