package petfinder.resource;

public class PetfinderUri {

	/**
	 * Adoptions
	 */
	public static final String ADOPTION = "adoptions";
	
	public static String adoptionUri(String itemid) {
		return ADOPTION + "/" + itemid;
	}
	
	/**
	 * Ads
	 */
	public static final String AD = "ads";
	
	public static String adUri(String itemid) {
		return AD + "/" + itemid;
	}
	
	/**
	 * AnimalWelfare
	 */
	/*public static final String ANIMALWELFARE = "animalwelfare";
	
	public static String animalwelfareUri(String itemid) {
		return ANIMALWELFARE + "/" + itemid;
	}*/
	
	/**
	 * Adoptions
	 */
	/*public static final String APPLICANT = "applicants";
	
	public static String applicantUri(String itemid) {
		return APPLICANT + "/" + itemid;
	}*/
	
	
	/**
	 * Breed
	 */
	public static final String BREED = "breeds";
	
	public static String breedUri(String itemid) {
		return BREED + "/" + itemid;
	}
	
	/**
	 * Employee
	 */
	/*public static final String EMPLOYEE = "employees";
	
	public static String employeeUri(String itemid) {
		return EMPLOYEE + "/" + itemid;
	}*/
	
	/**
	 * Pet
	 */
	public static final String PET = "pets";
	
	public static String petUri(String itemid) {
		return PET + "/" + itemid;
	}
	
	
	public static final String petSearch = PET + "/search";
	
	public static final String adoptionSearch = ADOPTION + "/search";
	
	public static final String adSearch = AD + "/search";
	
	
	
	public static String petSearch(String breedName) {
		return petSearch + "?breedName=" + breedName;
	}
	
	public static String adoptionSearch(boolean approved) {
		return adoptionSearch + "?approved=" + approved;
	}
	
	public static String adSearch(String breedName) {
		return adSearch + "?breedName=" + breedName;
	}


}
