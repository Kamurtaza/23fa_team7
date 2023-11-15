package unit_tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;
import java.time.LocalTime;

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
		assertEquals(1, g.getNumPosts());
	}
	
	@Test
	void testGetPost_Success() {
		Group g = createGroupWithPost();
		Post expected = createPost();
		assertEquals(expected, g.getPost(0));
	}
	
	@Test
	void testGetPostWithText_Success() {
		Group g = createGroupWithPost();
		Post expected = createPost();
		assertEquals(expected, g.getPostWithText("I don't know how to do derivatives. Help!"));
	}
	
	@Test
	void testGetPostWithText_Failure() {
		Group g = createGroup();
		assertNull(g.getPostWithText(""));
	}
	
	@Test
	void testGetPost_Failure() {
		Group g = createGroupWithPost();
		assertNull(g.getPost(-1));
		assertNull(g.getPost(1));
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
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		return new Post(g, "I don't know how to do derivatives. Help!", date, time);
	}
	
	public Group createGroupWithPost() {
		Group g = createGroup();
		Post p = createPost();
		g.addPost(p);
		return g;
	}
}
