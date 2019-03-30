package petfinder.domain;

import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.HashSet;
import javax.persistence.*;


/**
 *  Ράτσα ζώου.
 *
 */
@Entity
@Table(name="breedsList")
public class Breed {
	
	@Id
    @Column(name="breedID")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer breedID;
  
	@Column(name="BreedName", length=50, nullable = false)
	private String BreedName;
	@Column(name="Animal", length=50, nullable = false)
    private String Animal;
    
    private Double MinLivingArea;
    
    private boolean NeedsGarden;
    
    
    private Double MinHoursPerDay;
    
    private Double MinPetBudgetPerWeek;

	private List<Breed> NonCompBreed = new Vector<Breed>();

   
    public Breed() {
    	
    }

   
    public Breed(String BreedName, String Animal, Double MinLivingArea, boolean NeedsGarden,
    		Double MinHoursPerDay, Double MinPetBudgetPerWeek) {
        this.BreedName = BreedName;
        this.Animal = Animal;
        this.MinLivingArea = MinLivingArea;
        this.NeedsGarden = NeedsGarden;
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

   
    public void setMinLivingArea(Double MinLivingArea) {
        this.MinLivingArea = MinLivingArea;
    }

   
    public Double getMinLivingArea() {
        return MinLivingArea;
    }

    public void setNeedsGarden(boolean NeedsGarden) {
        this.NeedsGarden = NeedsGarden;
    }

   
    public boolean getNeedsGarden() {
        return this.NeedsGarden;
    }
    
    public void setMinPetBudgetPerWeek(Double MinPetBudgetPerWeek) {
        this.MinPetBudgetPerWeek = MinPetBudgetPerWeek;
    }
    
    /*public Set<Breed> getBreed() {
    	return new HashSet<Breed>(NonCompBreed);
    }*/
    
    public void addNonCompBreed(Breed breed) {
    	NonCompBreed.add(breed);
    }
    
    public void removeNonCompBreed(Breed breed) {
    	NonCompBreed.remove(breed);
    }
    
    public List<Breed> getNonCompBreed() {
    	return NonCompBreed;
    }

    
    public Double getMinPetBudgetPerWeek() {
        return this.MinPetBudgetPerWeek;
    }
    
    public void setMinHoursPerDay(Double MinHoursPerDay) {
        this.MinHoursPerDay = MinHoursPerDay;
    }

  
    public Double getMinHoursPerDay() {
        return this.MinHoursPerDay;
    }

}