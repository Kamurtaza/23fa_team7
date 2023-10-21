package application;

public class Admin {
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	
	public Admin (String firstName, String lastName, String username, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Admin) {
			Admin a = (Admin)o;
			if(this.username.equals(a.username)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return firstName + " " + lastName + ", " + username;
	}
}
