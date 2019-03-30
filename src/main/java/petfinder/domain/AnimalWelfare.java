/**
 * 
 */
package petfinder.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author spyros
 *
 */

@Entity
@Table(name = "AnimalWelfareList")
public class AnimalWelfare extends User {

	
	@Id
    @Column(name="animalWelfareID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer animalWelfareID;
    
	@Column(name="address", length=50, nullable = false)
	private String address;
	

	@Column(name="country", length=50, nullable = false)
	private String country;
	
	@Column(name="region", length=50, nullable = false)
	private String region;
	
	/**
	 * 
	 */


	/**
	 * @param FullName
	 * @param Telephone
	 * @param Email
	 */
	public AnimalWelfare(String FullName, String Telephone, String Email, String Address, String Country, String Region) {
		super(FullName, Telephone, Email);
		this.address = Address;
		this.country = Country;
		this.region = Region;
	}
	
	public Integer getAnimalWelfareID() {
		return animalWelfareID;
	}

	public void setAnimalWelfareID(Integer animalWelfareID) {
		this.animalWelfareID = animalWelfareID;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

}
