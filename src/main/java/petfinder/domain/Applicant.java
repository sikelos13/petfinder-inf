package petfinder.domain;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.List;
import java.util.Vector;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="applicants")
public class Applicant extends User{
	
	@Id
    @Column(name="applicantID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer applicantID;

	
	@OneToMany(mappedBy="pets",fetch=FetchType.LAZY, 
            cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	List<Pet> listOfPets = new Vector<Pet>();
	
	private Double AvailableHoursPerDay;
	private String Country, City, Region, Address;
	private Double HouseArea, PetBudgetPerWeek;
	
	
	public Applicant(String fullname, String telephone, String email, String Country, String City, String Region, String Address,
			Double HouseArea, Double PetBudgetPerWeek, Double AvailableHoursPerDay) {
		super(fullname, telephone, email);

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
	
//	public String getTelephone() {
//		return Country;
//	}
//	
//	public void setTelephone(String Telephone) {
//		this.Telephone = Telephone;
//	}

	public Integer getID() {
		return applicantID;
	}
	

	public void setID(Integer appID) {
		applicantID = appID;
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
	
	public void setHouseArea(Double HouseArea) {
		this.HouseArea = HouseArea;
	}
	
	public Double getHouseArea() {
		return this.HouseArea;
	}
	
	
	public void setAvailableHoursPerDay(Double AvailableHoursPerDay) {
		this.AvailableHoursPerDay = AvailableHoursPerDay;
	}
	
	public Double getAvailableHoursPerDay() {
		return this.AvailableHoursPerDay;
	}
	
	
	public void setPetBudgetPerWeek(Double PetBudgetPerWeek) {
		this.PetBudgetPerWeek = PetBudgetPerWeek;
	}
	
	public Double getPetBudgetPerWeek() {
		return this.PetBudgetPerWeek;
	}
}
