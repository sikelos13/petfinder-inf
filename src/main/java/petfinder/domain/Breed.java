package petfinder.domain;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import javax.persistence.*;


/**
 * Η λίστα με τις ράτσες.
 *
 */
@Entity
@Table(name="breedsList")
public class Breed {
  
	private String BreedName;
    
    private String Animal;
    
    private Float MinLivingArea;
    
    private Boolean NeedsGarden;
    
    
    private Integer MinHoursPerDay;
    
    private Float MinPetBudgetPerWeek;

	private List<Breed> NonCompBreed;

   
    public Breed() { }

   
    public Breed(String BreedName, String Animal, Float MinLivingArea, Boolean NeedsGarden,
    		List<Breed> NonCompBreed, Integer MinHoursPerDay, Float MinPetBudgetPerWeek) {
        this.BreedName = BreedName;
        this.Animal = Animal;
        this.MinLivingArea = MinLivingArea;
        this.NeedsGarden = NeedsGarden;
        this.NonCompBreed = NonCompBreed;
        this.MinPetBudgetPerWeek = MinPetBudgetPerWeek;
        this.MinHoursPerDay = MinHoursPerDay;

    }

    
    public void setBreedName(String BreedName) {
        this.BreedName = BreedName;
    }
    
    public String getBreedName() {
        return BreedName;
    }
   
   
    public void setAnimal(String Animal) {
        this.Animal = Animal;
    }

   
    public String getAnimal() {
        return Animal;
    }

   
    public void setMinLivingArea(Float MinLivingArea) {
        this.MinLivingArea = MinLivingArea;
    }

   
    public Float getMinLivingArea() {
        return MinLivingArea;
    }

    public void setNeedsGarden(Boolean NeedsGarden) {
        this.NeedsGarden = NeedsGarden;
    }

   
    public Boolean getNeedsGarden() {
        return this.NeedsGarden;
    }
    
    public void setMinPetBudgetPerWeek(Float MinPetBudgetPerWeek) {
        this.MinPetBudgetPerWeek = MinPetBudgetPerWeek;
    }
    
    public Set<Breed> getBreed() {
    	return new HashSet<Breed>(NonCompBreed);
    }

    
    public Float getMinPetBudgetPerWeek() {
        return this.MinPetBudgetPerWeek;
    }
    
    public void setMinHoursPerDay(Integer MinHoursPerDay) {
        this.MinHoursPerDay = MinHoursPerDay;
    }

  
    public Integer getMinHoursPerDay() {
        return this.MinHoursPerDay;
    }

}