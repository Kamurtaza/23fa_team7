package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PostTest {
	@Test
	void testAddResponse() {
		Post p = createPost();
		Response r = new Response(p, "I can help");
		p.addResponse(r);
		assertEquals(r, p.getResponseWithText(r.getText()));
	}
	
	@Test
	void testEquals_True() {
		Post p = createPost();
		Category c = new Category("Mathematics");
		Group g = new Group("Calculus 1", c);
		Post p2 = new Post(g, "I don't know how to do derivatives. Help!");
		assertEquals(p,p2);
	}
	
	@Test
	void testEquals_False() {
		Post p = createPost();
		Category c = new Category("Mathematics");
		Group g = new Group("Calculus 1", c);
		Post p2 = new Post(g, "I don't know how to do integrals. Help!");
		assertNotEquals(p,p2);
	}
	
	@Test
	void testEquals_NotPost() {
		Post p = createPost();
		int x = 2;
		assertNotEquals(p,x);
	}
	
	@Test
	void testToString() {
		Post p = createPost();
		String expected = "Post in group Calculus 1:\nI don't know how to do derivatives. Help!";
		assertEquals(expected, p.toString());
	}

	/*
	 * HELPER METHOD
	 */
	
	public Post createPost() {
		Category c = new Category("Mathematics");
		Group g = new Group("Calculus 1", c);
		return new Post(g, "I don't know how to do derivatives. Help!");
	}
}
