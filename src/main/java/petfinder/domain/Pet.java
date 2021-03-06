package petfinder.domain;

import java.util.List;

import java.util.Vector;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import petfinder.resource.AdoptionInfo;

import java.util.ArrayList;
import java.util.Date;


@Entity
@Table(name = "Pets")
public class Pet {
	
	@Id 
    @Column(name="petId")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int petId;

	private String HealthStatus;
	
	private Double Age, Weight;
	
	private boolean HasBeenAdopted;
	
	public final Date ImportDate;
	
	private List<Image> images; 
	
	@ManyToMany(fetch=FetchType.LAZY)
    @JoinColumn(name="breedID")
	private Breed breed;

	public Pet() {
		ImportDate = new Date(); //current date
	}

	public Pet(Breed breed, String healthStatus, Double age, Double weight, boolean hasBeenAdopted) {
		
		this.HealthStatus = healthStatus;
		this.HasBeenAdopted = hasBeenAdopted;
		this.Weight = weight;
		this.Age = age;
		images = new Vector<Image>(); 
		ImportDate = new Date(); //current date
		this.setBreed(breed);
	 
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
	
	public void setAge(Double age) {
		this.Age = age;
	}
	
	public Double getAge() {
		return Age;
	}
	
	public void setWeight(Double weight) {
		this.Weight = weight;
	}
	
	public Double getWeight() {
		return Weight;
	}
	
	public void setID(int id) {
		this.petId = id;
	}
	
	
	public int getID() {
		return this.petId;
	}
	
	public void setHasBeenAdopted(boolean hasBeenAdopted) {
		this.HasBeenAdopted = hasBeenAdopted;
	}
	
	public boolean getHasBeenAdopted() {
		return this.HasBeenAdopted;
	}

	public Breed getBreed() {
		return breed;
	}

	public void setBreed(Breed breed) {
		this.breed = breed;
	}


}
