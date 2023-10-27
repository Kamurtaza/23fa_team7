package application;

import java.util.HashMap;

public class CategoryManager {
	private HashMap<String, Category> categories = new HashMap<String,Category>();
	
	public CategoryManager() {}
	
	public void addCategory(Category c) {
		categories.put(c.getTitle(), c);
	}
	
	public int getNumCategories() {
		return categories.size();
	}
	
	public Category getCategory(String title) {
		if(containsCategory(title)) {
			return categories.get(title);
		}
		return null;
	}
	
	public void clear() {
		categories.clear();
	}
	
	public boolean containsCategory(String title) {
		return categories.containsKey(title);
	}
	
	@Override
	public String toString() {
		String ret = "Categories:\n";
		for(Category c : categories.values()) {
			ret += c + "\n";
		}
		return ret;
	}
}
