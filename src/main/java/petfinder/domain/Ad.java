package petfinder.domain;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Ads")
public class Ad {
    
	@Id
    @Column(name="adID")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer adID;
	
	@OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="petID")
	private Pet Animal;
	
	@ManyToMany(fetch=FetchType.LAZY, 
            cascade= {CascadeType.PERSIST, CascadeType.MERGE}    
            ) 
    @JoinColumn(name="employeeID")
	private Employee author;
	
	private boolean active;
	

	private String Details;
	
	public Ad(Pet pet, String details, Employee author) {
		this(pet, details, author, true);
	}
	
	public Ad(Pet pet, String details, Employee author, boolean status) {
		this.Animal = pet;
		this.Details = details;
		this.author = author;
		this.active = status;
	}
	
	public Ad() {
		
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
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



}
