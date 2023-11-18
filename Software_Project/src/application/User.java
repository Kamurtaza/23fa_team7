package application;

public class User {
	
	private String name, username, password, birthday, country, city, state, role;
	
	public User (String name, String username, String password, String birthday, 
				 String city, String state, String country) {
		this.name = name;
		this.username = username;
		this.password = password;
		this.birthday = birthday;
		this.city = city;
		this.state = state;
		this.country = country;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getBirthday() {
		return this.birthday;
	}
	
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public String getCity() {
		return this.city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return this.state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getCountry() {
		return this.country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getRole() {
		return this.role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof User) {
			User user = (User)obj;
			if (user.username.equals(user.username)) {
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		String info = String.format("Name: %s, Username: %s, Password: %s, Birthday: %s\n"
								  + "City: %s, State: %s, Country: %s, Role: %s\n",
								  	 name, username, password, birthday,
								  	 city, state, country, role);
		return info;
	}

}