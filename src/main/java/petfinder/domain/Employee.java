package petfinder.domain;

import petfinder.contacts.TextMessage;

public class Employee extends User {

	private String jobTitle, message;
	
	public Employee() {
		super();
		setJobTitle("UnKnown");
	}

	public Employee(String FullName, String Telephone, String Email, String JobTitle) {
		super(FullName, Telephone, Email);
		this.jobTitle = JobTitle;
	}
	
	public void setJobTitle(String JobTitle) {
		this.jobTitle = JobTitle;
	}
	
	public String getJobTitle() {
		return this.jobTitle;
	}
	
	public static void sendText(TextMessage message) {
		
	}

}
