package petfinder.domain;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.hibernate.annotations.Generated;

import petfinder.contacts.TelephoneNumber;


import java.util.List;
import java.util.Vector;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="applicants")
public class Applicant extends User{
	
	private String Country, City, Region, Address;
	
	private float HouseArea, PetBudgetPerWeek;
	
	@Id
    @Column(name="applicantId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long applicantId;

	
	@OneToOne(mappedBy="pets",fetch=FetchType.LAZY, 
            cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	List<Pet> listOfPets = new Vector<Pet>();
	
	private Integer AvailableHoursPerDay;
	
	 @org.hibernate.annotations.Type(
	            type="petfinder.persistence.TelphoneNumberCustomType")
	    @Column(name="Tel")
	    private TelephoneNumber Tel;
	 
	
		public Applicant() {}
	
	public Applicant(String fullname, TelephoneNumber Tel, Long applicantId, String email, String Country, String City, String Region, String Address,
			float HouseArea, Float PetBudgetPerWeek, Integer AvailableHoursPerDay) {
//		super(fullname, Tel, email);

		this.Country = Country;
		this.City = City;
		this.Region = Region;
		this.Address = Address;
		this.HouseArea = HouseArea;
		this.PetBudgetPerWeek = PetBudgetPerWeek;
		this.AvailableHoursPerDay = AvailableHoursPerDay;

	}
	
	/**
     * Προσθέτει νέο ζώο στη λίστα του Applicant και θέτει
     * τo ζώο ως υιοθετημένο
     * @param pet Το ζώο
     */
	public void PetAdoption(Pet pet) {
		//@TODO: Exception
		pet.setHasBeenAdopted(true);
		listOfPets.add(pet);
	}

	
	public String getCountry() {
		return Country;
	}
	
	public void setCountry(String Country) {
		this.Country = Country;
	}
	
	public TelephoneNumber getTel() {
		return Tel;
	}
	
	public Long getId() {
		return applicantId;
	}
	
	public boolean isValid() {
        return true;
    }

	
	public void setTel(TelephoneNumber Tel) {
		this.Tel = Tel;
	}
	
	
	public void setCity(String City) {
		this.City = City;
	}
	
	public String getCity() {
		return this.City;
	}
	
	public void setRegion(String Region) {
		this.Region = Region;
	}
	
	public String getRegion() {
		return this.Region;
	}
	
	public void setAddress(String Address) {
		this.Address = Address;
	}
	
	public String getAddress() {
		return this.Address;
	}
	
	public void setHouseArea(float HouseArea) {
		this.HouseArea = HouseArea;
	}
	
	public float getHouseArea() {
		return this.HouseArea;
	}
	
	
	public void setAvailableHoursPerDay(Integer AvailableHoursPerDay) {
		this.AvailableHoursPerDay = AvailableHoursPerDay;
	}
	
	public float getAvailableHoursPerDay() {
		return this.AvailableHoursPerDay;
	}
	
	
	public void setPetBudgetPerWeek(float PetBudgetPerWeek) {
		this.PetBudgetPerWeek = PetBudgetPerWeek;
	}
	
	public float getPetBudgetPerWeek() {
		return this.PetBudgetPerWeek;
	}
}
