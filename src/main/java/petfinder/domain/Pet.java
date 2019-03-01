package petfinder.domain;

import java.util.List;
import java.util.Vector;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.awt.Image;
import java.util.Date;


@Entity
@Table(name = "Pets")
public class Pet {
	
	private int petId;

	private String HealthStatus;
	
	private Float Age, Weight;
	
	private Boolean HasBeenAdopted;
	
	public final Date ImportDate;
	
	private List<Image> images; 
	private Breed breed;

	public Pet(String healthStatus, Float age, Float weight, Boolean hasBeenAdopted, int id) {
		this.petId = id;
		this.HealthStatus = healthStatus;
		this.HasBeenAdopted = hasBeenAdopted;
		this.Weight = weight;
		this.Age = age;
		images = new Vector<Image>(); 
		ImportDate = new Date(); //current date
		createID(); 
	}

	public void addImage(String url, String description) {
		images.add(new Image(url, description));
	}
	
	public List<Image> getImages() {
		return images;
	}
	
	public void setHealthStatus(String healthStatus) {
		this.HealthStatus = healthStatus;
	}
	
	public String getHealthStatus() {
		return HealthStatus;
	}
	
	public void setAge(Float age) {
		this.Age = age;
	}
	
	public Float getAge() {
		return Age;
	}
	
	public void setWeight(Float weight) {
		this.Weight = weight;
	}
	
	public Float getWeight() {
		return Weight;
	}
	
	public void setID(int id) {
		this.petId = id;
	}
	
	private void createID() {
		this.petId = 0; //TODO create ID
	}
	
	public int getID() {
		return this.petId;
	}
	
	public void setHasBeenAdopted(Boolean hasBeenAdopted) {
		this.HasBeenAdopted = hasBeenAdopted;
	}
	
	public Boolean getHasBeenAdopted() {
		return this.HasBeenAdopted;
	}


}
