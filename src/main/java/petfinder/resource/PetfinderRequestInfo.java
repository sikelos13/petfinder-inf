package petfinder.resource;

public class PetfinderRequestInfo {

	private int itemId;
	private Integer adId, adoptionId;
	private int petId;
	
	
	public PetfinderRequestInfo() {
	}
	
	public PetfinderRequestInfo(int itemId,int petId, Integer adId, Integer adoptionId) {
		
		this.itemId = itemId;
		this.petId = petId;
		this.adId = adId;
		this.adoptionId= adoptionId;
		
	}
	
	public int getItemId() {
		return itemId;
	}
	
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	
	public Integer getAdoptionId() {
		return adoptionId;
	}
	
	public void setAdoptionId(Integer adoptionId) {
		this.adoptionId = adoptionId;
	}
	
	public Integer getAdId() {
		return adId;
	}
	
	public void setAdId(Integer adId) {
		this.adId = adId;
	}
	
	public int getPetId() {
		return petId;
	}
	
	public void setPetId(int petId) {
		this.petId = petId;
	}
	
	
}
