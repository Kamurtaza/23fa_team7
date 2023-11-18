package unit_tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import application.Category;
import application.Group;

class CategoryTest {

	@Test
	void testAddGroup_Success() {
		Category c = createCategory();
		Group g = new Group("Calculus I", c);
		assertEquals(true, c.addGroup(g));
	}
	
	@Test
	void testAddGroup_Fail() {
		Category c = createCategory();
		Group g = new Group("Calculus I", c);
		Group g2 = new Group("Calculus I", c);
		c.addGroup(g);
		assertEquals(false, c.addGroup(g2));
	}
	
	@Test
	void testGetGroups() {
		Category c = createCategoryWithGroups();
		ArrayList<Group> expected = new ArrayList<Group>();
		Group g = new Group("Linear Algebra", c);
		Group g2 = new Group("Calculus I", c);
		expected.add(g2);
		expected.add(g);
		assertEquals(expected, c.getGroups());
	}
	
	@Test
	void testEquals_True() {
		Category c = createCategory();
		Category c2 = new Category("Mathematics");
		assertEquals(c,c2);
	}
	
	@Test
	void testEquals_False() {
		Category c = createCategory();
		Category c2 = new Category("Science");
		assertNotEquals(c,c2);
	}
	
	@Test
	void testEquals_NotCategory() {
		Category c = createCategory();
		int x = 2;
		assertNotEquals(c,x);
	}
	
	@Test
	void testToString() {
		Category c = createCategory();
		String expected = "Category: Mathematics. Groups in this category:\n";
		assertEquals(expected,c.toString());
	}
	
	/*
	 * HELPER METHODS
	 */
	
	public Category createCategory() {
		return new Category("Mathematics");
	}
	
	public Category createCategoryWithGroups() {
		Category c = new Category("Mathematics");
		Group g = new Group("Linear Algebra", c);
		c.addGroup(g);
		Group g2 = new Group("Calculus I", c);
		c.addGroup(g2);
		return c;
	}
}
