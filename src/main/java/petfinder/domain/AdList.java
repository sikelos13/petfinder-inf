package petfinder.domain;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import javax.persistence.*;
import petfinder.domain.Ad;


/**
 * Η λίστα με τις ράτσες.
 *
 */
@Entity
@Table(name="adList")
public class AdList {
  
//	private Ad;    

   
    public AdList() { }

   
    public AdList(String BreedName, String Animal, Float MinLivingArea, Boolean NeedsGarden,
    		List<Breed> NonCompBreed, Integer MinHoursPerDay, Float MinPetBudgetPerWeek) {
//        this.BreedName = BreedName;
//        this.Animal = Animal;
//       

    }

    
//    public void setBreedName(String BreedName) {
//        this.BreedName = BreedName;
//    }
//    
//    public String getBreedName() {
//        return BreedName;
//    }
//   
//   
//    public void setAnimal(String Animal) {
//        this.Animal = Animal;
//    }
//
//   
//    public String getAnimal() {
//        return Animal;
//    }
//
//   
//    public void setMinLivingArea(Float MinLivingArea) {
//        this.MinLivingArea = MinLivingArea;
//    }
//
//   
//    public Float getMinLivingArea() {
//        return MinLivingArea;
//    }
//
//    public void setNeedsGarden(Boolean NeedsGarden) {
//        this.NeedsGarden = NeedsGarden;
//    }
//
//   
//    public Boolean getNeedsGarden() {
//        return this.NeedsGarden;
//    }
//    
//    public void setMinPetBudgetPerWeek(Float MinPetBudgetPerWeek) {
//        this.MinPetBudgetPerWeek = MinPetBudgetPerWeek;
//    }
//    
//    public Set<Breed> getBreed() {
//    	return new HashSet<Breed>(NonCompBreed);
//    }
//
//    
//    public Float getMinPetBudgetPerWeek() {
//        return this.MinPetBudgetPerWeek;
//    }
//    
//    public void setMinHoursPerDay(Integer MinHoursPerDay) {
//        this.MinHoursPerDay = MinHoursPerDay;
//    }
//
//  
//    public Integer getMinHoursPerDay() {
//        return this.MinHoursPerDay;
//    }

}