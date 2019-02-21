package petfinder.domain;

public class User {
	
	private String name, telephone, email;
	
	public User() {
		this("", "", "");
	}
	
	public User(String FullName, String Telephone, String Email) {
		this.name = FullName;
		this.telephone = Telephone;
		this.email = Email;
	}
	
	public String getFullName() {
		return name;
	}
	
	public void setFullName(String FullName) {
		this.name = FullName;
	}
	
	public void setTelephone(String Telephone) {
		this.telephone = Telephone;
	}
	
	public String getTelephone() {
		return this.telephone;
	}
	
	public void setEmail(String Email) {
		this.email = Email;
	}
	
	public String getEmail() {
		return this.email;
	}
}
