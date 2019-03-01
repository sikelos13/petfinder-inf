package petfinder.domain;


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
    @Column(name="adID")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer adID;
	
	@Embedded
	private Pet Animal;
	
	@Embedded
	private Employee author;
	

	private String Details;
	
	public Ad(Pet pet, String details, Employee author) {
		this.Animal = pet;
		this.Details = details;
		this.author = author;
	}
	
	public Pet getPet() {
		return Animal;
	}
	

	public Integer getID() {
		return adID;
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
	
	public void setID(Integer adId) {
		this.adID = adId;
	}
	
	public Employee getAuthor() {
		return author;
	}

	public void setAuthor(Employee author) {
		this.author = author;
	}
	
	/*private void createID() {
		this.id = 0; //TODO create ID
	}*/


}
