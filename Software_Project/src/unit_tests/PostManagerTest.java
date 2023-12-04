package unit_tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import application.Category;
import application.Group;
import application.GroupManager;
import application.Post;
import application.PostManager;
import application.Response;

class PostManagerTest {

	@Test
	void testAddPost() {
		PostManager pm = buildPM();
		Category c1 = new Category("Science");
		Group g1 = new Group("Biology", c1);
		Post p = new Post(g1, "What are some differences between plant and animal cell structure?", LocalDate.now(), LocalTime.now());
		pm.addPost(p);
		assertEquals(3, pm.getNumPosts());
	}
	
	@Test
	void testGetPost_Success() {
		PostManager pm = buildPM();
		Category c1 = new Category("Mathematics");
		Group g1 = new Group("Calculus 1", c1);
		Post expected = new Post(g1, "I should probably study for my exam tonight.", LocalDate.now(), LocalTime.now());
		assertEquals(expected, pm.getPost(g1, "I should probably study for my exam tonight."));
	}
	
	@Test
	void testGetPost_Failure() {
		PostManager pm = buildPM();
		assertNull(pm.getPost(new Group("Calculus 1", new Category("Mathematics")), ""));
	}
	
	@Test 
	void testClear() {
		PostManager pm = buildPM();
		pm.clear();
		assertEquals(0, pm.getNumPosts());
	}
	
	@Test
	void testContainsPost_True() {
		PostManager pm = buildPM();
		assertEquals(true, pm.containsPost(new Group("Calculus 1", new Category("Mathematics")), "I don't know how to do derivatives. Help!"));
	}
	
	@Test
	void testContainsPost_False() {
		PostManager pm = buildPM();
		assertEquals(false, pm.containsPost(new Group("Calculus 1", new Category("Mathematics")), ""));
	}
	
	@Test
	void testResponsesToPostList_Success() {
		PostManager pm = buildPMWithResponses();
		Category c1 = new Category("Mathematics");
		Group g1 = new Group("Calculus 1", c1);
		Post p = new Post(g1, "I don't know how to do derivatives. Help!", LocalDate.now(), LocalTime.now());
		Response r = new Response(p, "I can help!", LocalDate.now(), LocalTime.now());
		Response r2 = new Response(p, "I am not good at derivatives...", LocalDate.now(), LocalTime.now());
		ArrayList<Response> expected = new ArrayList<>();
		expected.add(r);
		expected.add(r2);
		assertEquals(expected, pm.responseToPostList(pm.getPost(g1, "I don't know how to do derivatives. Help!")));
	}
	
	@Test
	void testResponsesToPostList_Failure() {
		PostManager pm = buildPMWithResponses();
		Category c1 = new Category("Mathematics");
		Group g1 = new Group("Calculus 1", c1);
		Post p = new Post(g1, "I failed this test. Darn.", LocalDate.now(), LocalTime.now());
		assertNull(pm.responseToPostList(p));
	}

	/*
	 *HELPER METHOD 
	 */
	
	public PostManager buildPM() {
		LocalDate date1 = LocalDate.now();
		LocalTime time1 = LocalTime.now();
		PostManager pm = new PostManager();
		Category c1 = new Category("Mathematics");
		Group g1 = new Group("Calculus 1", c1);
		Post p = new Post(g1, "I don't know how to do derivatives. Help!", date1, time1);
		pm.addPost(p);
		LocalDate date2 = LocalDate.now();
		LocalTime time2 = LocalTime.now();
		Post p2 = new Post(g1, "I should probably study for my exam tonight.", date2, time2);
		g1.addPost(p2);
		g1.addPost(p);
		pm.addPost(p2);
		return pm;
	}
	
	public PostManager buildPMWithResponses() {
		Category c1 = new Category("Mathematics");
		Group g1 = new Group("Calculus 1", c1);
		Post p = new Post(g1, "I don't know how to do derivatives. Help!", LocalDate.now(), LocalTime.now());
		p.addResponse(new Response(p, "I can help!", LocalDate.now(), LocalTime.now()));
		PostManager pm = new PostManager();
		p.addResponse(new Response(p, "I am not good at derivatives...", LocalDate.now(), LocalTime.now()));
		pm.addPost(p);
		return pm;
	}
}
