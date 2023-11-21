package unit_tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;

import application.Category;
import application.Group;
import application.Post;
import application.Response;

class PostTest {
	@Test
	void testAddResponse() {
		Post p = createPost();
		Response r = createResponse();
		p.addResponse(r);
		assertEquals(1, p.getNumResponses());
	}
	
	@Test
	void testGetResponse_Success() {
		Post p = createPostWithResponse();
		Response expected = createResponse();
		assertEquals(expected, p.getResponse(0));
	}
	
	@Test
	void testGetResponse_Failure() {
		Post p = createPostWithResponse();
		assertNull(p.getResponse(-1));
		assertNull(p.getResponse(1));
	}
	
	@Test
	void testGetResponseWithText_Success() {
		Post p = createPostWithResponse();
		Category c = new Category("Mathematics");
		Group g = new Group("Calculus 1", c);
		Post p2 = new Post(g, "I don't know how to do derivatives. Help!", LocalDate.now(), LocalTime.now());
		Response expected =  new Response(p, "I can help!", LocalDate.now(),LocalTime.now());
		assertEquals(expected, p.getResponseWithText("I can help!"));
	}
	
	@Test
	void testGetResponseWithText_Failure() {
		Post p = createPostWithResponse();
		assertNull(p.getResponseWithText(""));
	}
	
	@Test
	void testEquals_True() {
		Post p = createPost();
		Category c = new Category("Mathematics");
		Group g = new Group("Calculus 1", c);
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		Post p2 = new Post(g, "I don't know how to do derivatives. Help!", date, time);
		assertEquals(p,p2);
	}
	
	@Test
	void testEquals_False() {
		Post p = createPost();
		Category c = new Category("Mathematics");
		Group g = new Group("Calculus 1", c);
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		Post p2 = new Post(g, "I don't know how to do integrals. Help!", date, time);
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
		String expected = "Post in group Calculus 1:\nI don't know how to do derivatives. Help!\nOn "
				+ p.getDate() + " at " + p.getTime();
		assertEquals(expected, p.toString());
	}

	/*
	 * HELPER METHOD
	 */
	
	public Post createPost() {
		Category c = new Category("Mathematics");
		Group g = new Group("Calculus 1", c);
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		return new Post(g, "I don't know how to do derivatives. Help!", date, time);
	}
	
	public Response createResponse() {
		Category c = new Category("Mathematics");
		Group g = new Group("Calculus 1", c);
		Post p = new Post(g, "I don't know how to do derivatives. Help!", LocalDate.now(), LocalTime.now());
		return new Response(p, "I can help!", LocalDate.now(),LocalTime.now());
	}
	
	public Post createPostWithResponse() {
		Category c = new Category("Mathematics");
		Group g = new Group("Calculus 1", c);
		Post p = new Post(g, "I don't know how to do derivatives. Help!", LocalDate.now(), LocalTime.now());
		Response r =  new Response(p, "I can help!", LocalDate.now(),LocalTime.now());
		p.addResponse(r);
		return p;
	}
}
