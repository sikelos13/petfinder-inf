package petfinder.domain;

import java.util.List;
import java.util.Date;

public class Pet {
	
	private int petId;

	private String HealthStatus;
	
	private Float Age, Weight;
	
	private Boolean HasBeenAdopted;
	
	private Date ImportDate;
	
	private List Image, Breed;

	public Pet(String healthStatus, Float age, Float weight, Boolean hasBeenAdopted, int id) {
		this.petId = id;
		this.HealthStatus = healthStatus;
		this.HasBeenAdopted = hasBeenAdopted;
		this.Weight = weight;
		this.Age = age;
		createID(); 
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
		this.petId = 0; //@todo create ID
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
