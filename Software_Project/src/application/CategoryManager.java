package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class CategoryManager {
	
	// String (Category Name)
	private HashMap<String, Category> categories = new HashMap<String, Category>();

	public CategoryManager() { }
	
	public boolean addCategory(Category category) {
		if (!categories.containsKey(category.getTitle())) {
			categories.put(category.getTitle(), category);
			return true;
		}
		return false;
	}
	
	public boolean removeCategory(Category category) {
		if (categories.containsKey(category.getTitle())) {
			categories.remove(category.getTitle());
			return true;
		}
		return false;
	}
	
	public int getNumCategories() {
		return categories.size();
	}
	
	public Category getCategory(String categoryName) {
		if (categories.containsKey(categoryName)) {
			return categories.get(categoryName);
		}
		return null;
	}
	
	public boolean hasCategory(String categoryName) {
		if (categories.containsKey(categoryName)) {
			return true;
		}
		return false;
	}
	
	public HashMap<String, Category> getHashMap() {
		return this.categories;
	}
	
	public void clear() {
		categories.clear();
	}
	

	public String toString() {
		String info = "Categories: ";
		
		for (Category category : categories.values()) {
			info += category.getTitle() + ", ";
		}
		
		info += "\n";
		return info;
	}
	
}