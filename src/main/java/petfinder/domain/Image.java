package petfinder.domain;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Images")
public class Image {

	private String url, description;
	
	public Image(String path, String desc) {
		url = path;
		description = desc;
	}
	
	public String getUrl() {
		return url;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String desc) {
		description = desc;
	}
	
	public void setUrl(String path) {
		url = path;
	}
	
	

}
