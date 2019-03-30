package petfinder.resource;

public class PetfinderUri {

/**
 * /Fuel
 */
public static final String Petfinder = "petfinder";

/**
 * /Import
 */
public static final String Import = "import";

/**
 * /Sale
 */
public static final String Pet = "pet";

public static final String ad_search = "ad/search";

public static final String pet_search = "pet/search";



/**
 * /Tank
 */
public static final String Ad = "ad";

public static final String Application = "application";

public static String adSearchUri(String ad) {
	return ad_search + "?ad=" + ad;
}

public static String petSearch(String pet) {
	return pet_search + "?pet=" + pet;
}


}
