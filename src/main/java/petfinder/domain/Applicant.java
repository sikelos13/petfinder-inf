package petfinder.domain;

public class Applicant {
	
	private String Country, City, Region, Address;
	
	private Float HouseArea, PetBudgetPerWeek;
	
	private Integer AvailableHoursPerDay, Tel;
	
	
	public Applicant() {
		this("", "", "", "",null, null,null,null);
	}
	
	public Applicant(String Country, String City, String Region, String Address, Integer Tel,
			Float HouseArea, Float PetBudgetPerWeek, Integer AvailableHoursPerDay) {
		this.Country = Country;
		this.City = City;
		this.Region = Region;
		this.Tel = Tel;
		this.Address = Address;
		this.HouseArea = HouseArea;
		this.PetBudgetPerWeek = PetBudgetPerWeek;
		this.AvailableHoursPerDay = AvailableHoursPerDay;

	}

	
	public String getCountry() {
		return Country;
	}
	
	public void setCountry(String Country) {
		this.Country = Country;
	}
	
	public Integer getTel() {
		return Tel;
	}
	
	public boolean isValid() {
        return true;
    }

	
	public void setTel(Integer Tel) {
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
	
	public void setHouseArea(Float HouseArea) {
		this.HouseArea = HouseArea;
	}
	
	public Float getHouseArea() {
		return this.HouseArea;
	}
	
	
	public void setAvailableHoursPerDay(Integer AvailableHoursPerDay) {
		this.AvailableHoursPerDay = AvailableHoursPerDay;
	}
	
	public Integer getAvailableHoursPerDay() {
		return this.AvailableHoursPerDay;
	}
	
	
	public void setPetBudgetPerWeek(Float PetBudgetPerWeek) {
		this.PetBudgetPerWeek = PetBudgetPerWeek;
	}
	
	public Float getPetBudgetPerWeek() {
		return this.PetBudgetPerWeek;
	}
}
