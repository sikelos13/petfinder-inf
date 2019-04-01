package petfinder.resource;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.xml.bind.annotation.XmlRootElement;

import petfinder.domain.Breed;
import petfinder.domain.Pet;

@XmlRootElement
public class PetInfo {
	
	private Integer petId;
	private String HealthStatus;
	private Double Age, Weight;
	private boolean HasBeenAdopted;
	public Date ImportDate; 
	private Breed breed;
	
	public PetInfo() {
		
	}
	
	public PetInfo(Pet pet) {
		this.HealthStatus = pet.getHealthStatus();
		this.Age = pet.getAge();
		this.Weight = pet.getWeight();
		this.HasBeenAdopted = pet.getHasBeenAdopted();
		this.ImportDate = pet.ImportDate;
		this.breed = pet.getBreed();
	}
	
	public PetInfo(String health, Double age, Double weight,boolean hasBeenAdopted, Date importDate, Breed breed) {
		this.HealthStatus = health;
		this.Age = age;
		this.Weight = weight;
		this.HasBeenAdopted = hasBeenAdopted;
		this.ImportDate = importDate;
		this.breed = breed;
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
	
	public static PetInfo wrap(Pet b) {
		return new PetInfo(b);
	}

	public static List<PetInfo> wrap(List<Pet> pets) {

		List<PetInfo> petInfoList = new ArrayList<>();

		for (Pet b : pets) {
			petInfoList.add(new PetInfo(b));
		}

		return petInfoList;

	}

	public Pet getPet(EntityManager em) {

		Pet pet = null;

		if (petId != null) {
			pet = em.find(Pet.class, petId);
		} else {
			pet = new Pet();
		}

		return pet;
	}
	
	
}
