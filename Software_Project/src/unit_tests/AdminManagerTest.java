package unit_tests;

import application.AdminManager;
import application.Admin;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class AdminManagerTest {
	
	@Test
	void testAddAdmin() {
		AdminManager am = new AdminManager();
		Admin a1 = new Admin("Jacob", "Carlstrom", "jcstorm8","password");
		am.addAdmin(a1);
		assertEquals(1, am.getNumAdmins());
	}
	
	@Test
	void testGetAdmin_Fail() {
		AdminManager am = buildAM();
		assertNull(am.getAdmin(""));
	}
	
	@Test
	void testGetAdmin_Success() {
		AdminManager am = buildAM();
		Admin expected = new Admin("Jacob", "Carlstrom", "jcstorm8", "password1");
		assertEquals(expected, am.getAdmin("jcstorm8"));
	}
	
	@Test
	void testClear() {
		AdminManager am = buildAM();
		am.clear();
		assertEquals(0, am.getNumAdmins());
	}
	
	@Test
	void testContainsAdmin_False() {
		AdminManager am = buildAM();
		assertFalse(am.containsAdmin(""));
	}
	
	@Test
	void testContainsAdmin_True() {
		AdminManager am = buildAM();
		assertTrue(am.containsAdmin("jcstorm8"));
	}
	
	@Test
	void testToString() {
		AdminManager am = buildAM();
		String expected = "Admins:\nJacob Carlstrom, jcstorm8\nBob Smith, ilikedogs7\nDave Gibson, dgibson\n";
		assertEquals(expected, am.toString());
	}
	
	/*
	 * HELPER METHODS
	 */
	
	public AdminManager buildAM() {
		Admin a1 = new Admin("Jacob", "Carlstrom", "jcstorm8","password1");
		Admin a2 = new Admin("Dave", "Gibson", "dgibson","password2");
		Admin a3 = new Admin("Bob", "Smith", "ilikedogs7", "password3");
		AdminManager am = new AdminManager();
		am.addAdmin(a1);
		am.addAdmin(a2);
		am.addAdmin(a3);
		return am;
	}
}
