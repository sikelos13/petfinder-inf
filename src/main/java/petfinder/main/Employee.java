package petfinder.main;

public class Employee extends User {

	private String jobTitle;
	
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

}
