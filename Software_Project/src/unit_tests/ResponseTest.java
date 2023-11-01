package unit_tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import application.Category;
import application.Group;
import application.Post;
import application.Response;

class ResponseTest {

	@Test
	void testEquals_True() {
		Response r = buildResponse();
		Category c = new Category("Science");
		Group g = new Group("Biology", c);
		Post p = new Post(g, "Somebody help me study plant cell structure?");
		Response r2 = new Response(p, "I can help!");
		assertEquals(true, r.equals(r2));
	}
	
	@Test
	void testEquals_False() {
		Response r = buildResponse();
		Category c = new Category("Science");
		Group g = new Group("Biology", c);
		Post p = new Post(g, "What is the mitochondria?");
		Response r2 = new Response(p, "The powerhouse of the cell");
		assertEquals(false, r.equals(r2));
	}
	
	@Test
	void testEquals_notResponse() {
		Response r = buildResponse();
		int x = 2;
		assertEquals(false, r.equals(x));
	}
	
	@Test
	void testToString() {
		Response r = buildResponse();
		String expected = "Response to post \"I need help with integrals!\"\n\"I can help!\"";
		assertEquals(expected, r.toString());
	}

	/*
	 * HELPER METHOD
	 */
	
	public Response buildResponse() {
		Category c = new Category("Mathematics");
		Group g = new Group("Calculus 1", c);
		Post p = new Post(g, "I need help with integrals!");
		Response r = new Response(p, "I can help!");
		return r;
	}
}
