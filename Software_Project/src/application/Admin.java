package application;

import java.util.ArrayList;
import java.util.List;

public class Admin {
	private List<Category> categories;
	private List<Group> groups;
	
	private String firstName;
	private String lastName;
	private String username;
	private String password;

	public Admin(String firstName, String lastName, String username, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
	}
	public Admin() {
		categories = new ArrayList<>();
		groups = new ArrayList<>();
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
	
	public void createCategory(String title) {
		Category category = new Category(title);
		categories.add(category);
	}
	
	public void createGroup(String title, Category category) {
		Group group = new Group(title, category);
		groups.add(group);
	}
	
	public List<Category> getCategories(){
		return categories;
	}
	
	public List<Group> getGroups(){
		return groups;
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
