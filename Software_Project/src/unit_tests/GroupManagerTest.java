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

class GroupManagerTest {

	@Test
	void testAddGroup() {
		GroupManager gm = buildGM();
		Category c = new Category("History");
		Group g = new Group("American History", c);
		gm.addGroup(g);
		assertEquals(3, gm.getNumGroups());
	}
	
	@Test
	void testGetGroup_Success() {
		GroupManager gm = buildGM();
		Category c = new Category("Mathematics");
		Group expected = new Group("Calculus 1", c);
		assertEquals(expected, gm.getGroup("Calculus 1"));
	}
	
	@Test
	void testGetGroup_Failure() {
		GroupManager gm = buildGM();
		assertNull(gm.getGroup(""));
	}
	
	@Test 
	void testClear() {
		GroupManager gm = buildGM();
		gm.clear();
		assertEquals(0, gm.getNumGroups());
	}
	
	@Test
	void testContainsGroup_True() {
		GroupManager gm = buildGM();
		assertEquals(true, gm.containsGroup("Biology"));
	}
	
	@Test
	void testContainsGroup_False() {
		GroupManager gm = buildGM();
		assertEquals(false, gm.containsGroup(""));
	}
	
	@Test
	void testGroupList() {
		GroupManager gm = buildGM();
		Category c1 = new Category("Mathematics");
		Category c2 = new Category("Science");
		Group g1 = new Group("Calculus 1", c1);
		Group g2 = new Group("Biology", c2);
		ArrayList<Group> expected = new ArrayList<Group>();
		expected.add(g2);
		expected.add(g1);
		assertEquals(expected, gm.groupList());
	}
	
	@Test
	void testPostList_Success() {
		GroupManager gm = buildGMWithPosts();
		Category c1 = new Category("Mathematics");
		Group g1 = new Group("Calculus 1", c1);
		Post p1 = new Post(g1, "I don't know how to do derivatives. Help!", 
				gm.getGroup("Calculus 1").getPost(1).getDate(), gm.getGroup("Calculus 1").getPost(0).getTime());
		Post p2 = new Post(g1, "I should probably study for my exam tonight.", 
				gm.getGroup("Calculus 1").getPost(0).getDate(), gm.getGroup("Calculus 1").getPost(0).getTime());
		g1.addPost(p1);
		g1.addPost(p2);
		ArrayList<Post> expected = new ArrayList<>();
		expected.add(p1);
		expected.add(p2);
		assertEquals(expected, gm.postList(g1));
	}
	
	@Test
	void testPostList_Failure() {
		GroupManager gm = buildGMWithPosts();
		Category c1 = new Category("Mathematics");
		Group g1 = new Group("Linear Algebra", c1);
		assertNull(gm.postList(g1));
	}
	
	@Test
	void testToString() {
		GroupManager gm = buildGM();
		String expected = "Groups:\nCalculus 1\nBiology\n";
		assertEquals(expected, gm.toString());
	}

	/*
	 * HELPER METHODS
	 */
	
	public GroupManager buildGM() {
		GroupManager gm = new GroupManager();
		Category c1 = new Category("Mathematics");
		Category c2 = new Category("Science");
		Group g1 = new Group("Calculus 1", c1);
		Group g2 = new Group("Biology", c2);
		gm.addGroup(g1);
		gm.addGroup(g2);
		return gm;
	}
	
	public GroupManager buildGMWithPosts() {
		LocalDate date1 = LocalDate.now();
		LocalTime time1 = LocalTime.now();
		GroupManager gm = new GroupManager();
		Category c1 = new Category("Mathematics");
		Group g1 = new Group("Calculus 1", c1);
		Post p = new Post(g1, "I don't know how to do derivatives. Help!", date1, time1);
		LocalDate date2 = LocalDate.now();
		LocalTime time2 = LocalTime.now();
		Post p2 = new Post(g1, "I should probably study for my exam tonight.", date2, time2);
		g1.addPost(p2);
		g1.addPost(p);
		gm.addGroup(g1);
		return gm;
	}
}
