package application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class GroupTest {

	@Test
	void testEquals_True() {
		Group g = createGroup();
		Category c = new Category("Science");
		Group g2 = new Group("Calculus I", c);
		assertEquals(g,g2);
	}
	
	@Test
	void testEquals_False() {
		Group g = createGroup();
		Category c = new Category("Science");
		Group g2 = new Group("Biology", c);
		assertNotEquals(g,g2);
	}
	
	@Test
	void testEquals_notGroup() {
		Group g = createGroup();
		int x = 2;
		assertNotEquals(g,x);
	}
	
	@Test
	void testToString() {
		Group g = createGroup();
		String expected = "Calculus I";
		assertEquals(expected, g.toString());
	}
	
	/*
	 * HELPER METHOD
	 */
	
	public Group createGroup() {
		Category c = new Category("Mathematics");
		return new Group("Calculus I", c);
	}
}
