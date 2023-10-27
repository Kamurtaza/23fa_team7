package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

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
	void testToString() {
		GroupManager gm = buildGM();
		String expected = "Groups:\nCalculus 1\nBiology\n";
		assertEquals(expected, gm.toString());
	}

	/*
	 * HELPER METHOD
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
}
