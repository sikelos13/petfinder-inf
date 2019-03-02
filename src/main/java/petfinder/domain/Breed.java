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
    
    private float MinLivingArea;
    
    private boolean NeedsGarden;
    
    
    private float MinHoursPerDay;
    
    private float MinPetBudgetPerWeek;

	private List<Breed> NonCompBreed = new Vector<Breed>();

   
    public Breed() {
    	
    }

   
    public Breed(String BreedName, String Animal, float MinLivingArea, boolean NeedsGarden,
    		float MinHoursPerDay, float MinPetBudgetPerWeek) {
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

   
    public void setMinLivingArea(float MinLivingArea) {
        this.MinLivingArea = MinLivingArea;
    }

   
    public float getMinLivingArea() {
        return MinLivingArea;
    }

    public void setNeedsGarden(boolean NeedsGarden) {
        this.NeedsGarden = NeedsGarden;
    }

   
    public boolean getNeedsGarden() {
        return this.NeedsGarden;
    }
    
    public void setMinPetBudgetPerWeek(float MinPetBudgetPerWeek) {
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

    
    public float getMinPetBudgetPerWeek() {
        return this.MinPetBudgetPerWeek;
    }
    
    public void setMinHoursPerDay(float MinHoursPerDay) {
        this.MinHoursPerDay = MinHoursPerDay;
    }

  
    public float getMinHoursPerDay() {
        return this.MinHoursPerDay;
    }

}