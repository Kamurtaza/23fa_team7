package application;

public class Admin {
	//private String firstName;
	//private String lastName;
	private String name;
	private String username;
	private String password;
	private String birthday;
	private String country;
	private String city;
	private String state;
	
//	public Admin (String firstName, String lastName, String username, String password) {
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.username = username;
//		this.password = password;
//	}
	
	public Admin (String name, String username, String password, String birthday, String city, String state, String country) {
		this.name = name;
		this.username = username;
		this.password = password;
		this.birthday = birthday;
		this.country = country;
		this.city = city;
		this.state = state;
	}
	
//	public String getFirstName() {
//		return firstName;
//	}
//	
//	public String getLastName() {
//		return lastName;
//	}
	
	public String getName() {
		return name;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getBirthday() {
		return birthday;
	}
	
	public String getCountry() {
		return country;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getState() {
		return state;
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
	
//	@Override
//	public String toString() {
//		return firstName + " " + lastName + ", " + username;
//	}
	
	@Override
	public String toString() {
		String ret = String.format("%s\nUsername: %s\nPassword: %s\nBirthday: %s\nLocation: %s, %s, %s",
				name, username, password, birthday, city, state, country);
		return ret;
	}
}
