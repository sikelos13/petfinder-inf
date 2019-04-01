package petfinder.resource;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.xml.bind.annotation.XmlRootElement;

import petfinder.domain.Ad;
import petfinder.domain.Employee;
import petfinder.domain.Pet;

@XmlRootElement
public class AdInfo {

	private Integer adID;
	private Pet Animal;
	private Employee author;
	private boolean active;
	private String Details;
	
	public AdInfo() {
		
	}
	
	public AdInfo(Ad ad) {
		this(ad.getPet(), ad.getDetails(), ad.getAuthor(), ad.isActive());
		this.setID(ad.getID());
	}
	
	public AdInfo(Pet pet, String details, Employee author) {
		this(pet, details, author, true);
	}
	
	public AdInfo(Pet pet, String details, Employee author, boolean status) {
		this.Animal = pet;
		this.Details = details;
		this.author = author;
		this.active = status;
	}
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Pet getPet() {
		return Animal;
	}
	

	public Integer getID() {
		return adID;
	}
	
	public String getDetails() {
		return Details;
	}
	
	public void setPet(Pet pet) {
		Animal = pet;
	}
	
	public void setDetails(String details) {
		Details = details;
	}
	
	public void setID(Integer adId) {
		this.adID = adId;
	}
	
	public Employee getAuthor() {
		return author;
	}

	public void setAuthor(Employee author) {
		this.author = author;
	}
	
	public static AdInfo wrap(Ad ad) {
		return new AdInfo(ad);
	}

	public static List<AdInfo> wrap(List<Ad> ads) {

		List<AdInfo> adInfoList = new ArrayList<>();

		for (Ad b : ads) {
			adInfoList.add(new AdInfo(b));
		}

		return adInfoList;

	}

	public Ad getAd(EntityManager em) {

		Ad ad = null;

		if (adID != null) {
			ad = em.find(Ad.class, adID);
		} else {
			ad = new Ad();
		}

		return ad;
	}
	
}
