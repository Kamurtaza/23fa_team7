package unit_tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;

import application.Category;
import application.Group;
import application.Post;
import application.Response;

class ResponseTest {

	@Test
	void testEquals_True() {
		Response r = createResponse();
		Category c = new Category("Science");
		Group g = new Group("Biology", c);
		Post p = new Post(g, "Somebody help me study plant cell structure?", r.getPost().getDate(), r.getPost().getTime());
		Response r2 = new Response(p, "I can help!", LocalDate.now(), LocalTime.now());
		assertEquals(true, r.equals(r2));
	}
	
	@Test
	void testEquals_False() {
		Response r = createResponse();
		Category c = new Category("Science");
		Group g = new Group("Biology", c);
		Post p = new Post(g, "What is the mitochondria?", r.getPost().getDate(), r.getPost().getTime());
		Response r2 = new Response(p, "The powerhouse of the cell", LocalDate.now(), LocalTime.now());
		assertEquals(false, r.equals(r2));
	}
	
	@Test
	void testEquals_notResponse() {
		Response r = createResponse();
		int x = 2;
		assertEquals(false, r.equals(x));
	}
	
	@Test
	void testToString() {
		Response r = createResponse();
		String expected = "Response to post \"I don't know how to do derivatives. Help!\":\n\"I can help!\"\nOn "
				+ r.getDate() + " at " + r.getTime();
		assertEquals(expected, r.toString());
	}

	/*
	 * HELPER METHOD
	 */
	
	public Response createResponse() {
		Category c = new Category("Mathematics");
		Group g = new Group("Calculus 1", c);
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		Post p = new Post(g, "I don't know how to do derivatives. Help!", date, time);
		LocalDate d2 = LocalDate.now();
		LocalTime t2 = LocalTime.now();
		return new Response(p, "I can help!", d2,t2);
	}
}
