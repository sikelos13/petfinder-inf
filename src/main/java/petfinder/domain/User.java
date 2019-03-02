package petfinder.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Embeddable
public class User implements UserAccount{
	
	@Column(name="fullname", length=50, nullable = false)
	private String fullname;
	@Column(name="telephone", length=50, nullable = false)
	private String telephone;
	@Column(name="email", length=50, nullable = false)
	private String email;
	
	@Id 
    @Column(name="petId")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	
	public User() {
		this("", "", "");
	}
	
	public User(String FullName, String Telephone, String Email) {
		this.fullname = FullName;
		this.telephone = Telephone;
		this.email = Email;
	}
	
	public void setID(int id) {
		this.userId = id;
	}
	
	
	public Integer getID() {
		return this.userId;
	}
	
	public String getFullName() {
		return fullname;
	}
	
	public void setFullName(String FullName) {
		this.fullname = FullName;
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

	public boolean Login() {
		// TODO Auto-generated method stub
		return false;
	}
}
