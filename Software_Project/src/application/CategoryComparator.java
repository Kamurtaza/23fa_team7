package application;

import java.util.Comparator;

public class CategoryComparator implements Comparator<Category>{

	public int compare(Category c1, Category c2) {
		return c1.getTitle().compareTo(c2.getTitle());
	}
}