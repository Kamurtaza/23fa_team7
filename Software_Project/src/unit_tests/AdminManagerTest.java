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
		Admin a1 = new Admin("Bill Gates", "billgates123", "qwertyuiop", "10/28/1955", "Medina", "WA", "USA");
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
		Admin expected = new Admin("Jacob Carlstrom", "jcstorm8", "password123", "06/30/2003", "Valdosta", "GA", "USA");
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
		//String expected = "Admins:\nJacob Carlstrom, jcstorm8\nBob Smith, ilikedogs7\nDave Gibson, dgibson\n";
//		String ret = String.format("%s\nUsername: %s\nPassword: %s\nBirthday: %s\nLocation: %s, %s, %s\n",
//				name, username, password, birthday, city, state, country);
		String expected = "Admins:\nJacob Carlstrom\nUsername: jcstorm8\nPassword: password123\nBirthday: 06/30/2003\nLocation: Valdosta, GA, USA\n"
				+ "Bob Smith\nUsername: asdf\nPassword: password\nBirthday: 01/01/2000\nLocation: Atlanta, GA, USA\n";
		assertEquals(expected, am.toString());
	}
	
	/*
	 * HELPER METHODS
	 */
	
	public AdminManager buildAM() {
		Admin a1 = new Admin("Jacob Carlstrom", "jcstorm8", "password123", "06/30/2003", "Valdosta", "GA", "USA");
		//Admin a2 = new Admin("Dave", "Gibson", "dgibson","password2");
		Admin a3 = new Admin("Bob Smith", "asdf", "password", "01/01/2000", "Atlanta", "GA", "USA");
		AdminManager am = new AdminManager();
		am.addAdmin(a1);
		//am.addAdmin(a2);
		am.addAdmin(a3);
		return am;
	}
}
