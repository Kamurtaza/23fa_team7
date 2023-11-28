package unit_tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import application.Category;
import application.Group;
import application.Post;

class GroupTest {
	@Test
	void testAddPost() {
		Group g = createGroup();
		Post p = createPost();
		g.addPost(p);
		Post expected = createPost();
		assertEquals(expected, g.getPost(p.getText()));
	}
	
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
	 * HELPER METHODS
	 */
	
	public Group createGroup() {
		Category c = new Category("Mathematics");
		return new Group("Calculus I", c);
	}
	
	public Post createPost() {
		Category c = new Category("Mathematics");
		Group g = new Group("Calculus 1", c);
		return new Post(g, "I don't know how to do derivatives. Help!");
	}
}