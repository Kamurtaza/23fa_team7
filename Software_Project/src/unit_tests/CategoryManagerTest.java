package unit_tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import application.Category;
import application.CategoryManager;
import application.Group;

class CategoryManagerTest {

	@Test
	void testAddCategory() {
		CategoryManager cm = buildCM();
		cm.addCategory(new Category("Science"));
		assertEquals(2, cm.getNumCategories());
	}
	
	@Test
	void testGetCategory_Success() {
		CategoryManager cm = buildCM();
		Category expected = new Category("Mathematics");
		assertEquals(expected,cm.getCategory("Mathematics"));
	}
	
	@Test
	void testGetCategory_Failure() {
		CategoryManager cm = buildCM();
		assertNull(cm.getCategory(""));
	}
	
	@Test
	void testClear() {
		CategoryManager cm = buildCM();
		cm.clear();
		assertEquals(0, cm.getNumCategories());
	}
	
	@Test
	void testContainsCategory_True() {
		CategoryManager cm = buildCM();
		assertTrue(cm.containsCategory("Mathematics"));
	}
	
	@Test
	void testContainsCategory_False() {
		CategoryManager cm = buildCM();
		assertFalse(cm.containsCategory(""));
	}
	
	@Test
	void testCategoryList() {
		CategoryManager cm = buildCM_MultipleCategories();
		Category c = new Category("Mathematics");
		Group g = new Group("Calculus I", c);
		c.addGroup(g);
		Category c2 = new Category("Art");
		ArrayList<Category> expected = new ArrayList<Category>();
		expected.add(c2);
		expected.add(c);
		assertEquals(expected, cm.categoryList());
	}
	
	@Test
	void testGroupsInCategoryList_CategoryExists() {
		Category c = new Category("Mathematics");
		Group g = new Group("Linear Algebra", c);
		Group g2 = new Group("Calculus I", c);
		c.addGroup(g);
		c.addGroup(g2);
		CategoryManager cm = new CategoryManager();
		cm.addCategory(c);
		ArrayList<Group> expected = new ArrayList<Group>();
		expected.add(g2);
		expected.add(g);
		assertEquals(expected, cm.groupsInCategoryList(c));
	}
	
	@Test
	void testGroupsInCategoryList_CategoryNotExists() {
		Category c = new Category("Art");
		CategoryManager cm = new CategoryManager();
		assertEquals(null, cm.groupsInCategoryList(c));
	}
	
	@Test
	void testToString() {
		CategoryManager cm = buildCM();
		String expected = "Categories:\nCategory: Mathematics. Groups in this category:\nCalculus I\nLinear Algebra\n\n";
		assertEquals(expected, cm.toString());
	}
	
	/*
	 * HELPER METHOD
	 */

	public CategoryManager buildCM() {
		Category c = new Category("Mathematics");
		Group g = new Group("Calculus I", c);
		Group g2 = new Group("Linear Algebra", c);
		CategoryManager cm = new CategoryManager();
		c.addGroup(g);
		c.addGroup(g2);
		cm.addCategory(c);
		return cm;
	}
	
	public CategoryManager buildCM_MultipleCategories() {
		Category c = new Category("Mathematics");
		Group g = new Group("Calculus I", c);
		Category c2 = new Category("Art");
		CategoryManager cm = new CategoryManager();
		c.addGroup(g);
		cm.addCategory(c);
		cm.addCategory(c2);
		return cm;
	}
}
