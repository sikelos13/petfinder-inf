package petfinder.domain;


import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Ads")
public class Ad {
    
	@Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Embedded
	private Pet Animal;
	
	private String Details;
	
	public Ad(Pet pet, String details, int id) {
		this.Animal = pet;
		this.id = id;
		this.Details = details;
		//createID(); 
	}
	
	public Pet getPet() {
		return Animal;
	}
	
	public int getID() {
		return id;
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
		this.id = id;
	}
	
	/*private void createID() {
		this.id = 0; //TODO create ID
	}*/

}
