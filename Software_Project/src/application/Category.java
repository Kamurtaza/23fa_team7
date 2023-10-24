package application;

import java.util.HashMap;

public class Category {
	private String title;
	private HashMap<String, Group> groups = new HashMap<String, Group>();
	
	public Category(String name) {
		this.title = name;
	}
	
	public String getTitle() {
		return title;
	}
	
	public boolean addGroup(Group g) {
		if(!groups.containsKey(g.getTitle())) {
			groups.put(g.getTitle(), g);
			return true;
		}
		return false;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Category) {
			Category c = (Category)o;
			if(this.title.equals(c.title)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		String msg = "Category: " + title + ". Groups in this category:\n";
		for(Group g : groups.values()) {
			msg += g.toString() + "\n";
		}
		return msg;
	}
}
