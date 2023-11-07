package application;

import java.util.ArrayList;
import java.util.Collections;
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
	
	//Returns alphabetical list of Categories
		public ArrayList<Category> categoryList() {
			ArrayList<Category> dummy = new ArrayList<Category>();
			for(Category c : categories.values()) {
				dummy.add(c);
			}
			CategoryComparator cc = new CategoryComparator();
			Collections.sort(dummy,cc);
			return dummy;
		}

		//Returns alphabetical lists of Groups in a Category
		public ArrayList<Group> groupsInCategoryList(Category c) {
			ArrayList<Group> dummy = c.getGroups();
			GroupComparator gc = new GroupComparator();
			Collections.sort(dummy,gc);
			return dummy;
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
