package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.ArrayList;

public class Category {

	private String title;
	private HashMap<String, Group> groups = new HashMap<String, Group>();
	
	public Category(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public boolean addGroup(Group group) {
		if (!groups.containsKey(group.getTitle())) {
			groups.put(group.getTitle(), group);

			return true;
		}
		return false;
	}
	
	public ArrayList<Group> getGroups() {

		ArrayList<Group> groupList = new ArrayList<Group>();
		
		for (Group group : groups.values()) {
			groupList.add(group);
		}
		
		return groupList;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Category) {
			Category category = (Category)obj;
			if (this.title.equals(category.title)) {

				return true;
			}
		}
		return false;
	}

	public String toString() {
		String info = "Category: " + title + "\nGroups: ";
		
		for (Group group : groups.values()) {
			info += group.toString() + ", ";
		}
		
		return info;
	}
	
}