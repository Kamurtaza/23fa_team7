package application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class AdminManagerTest {
	@Test
	void testConstructor() {
		AdminManager am = new AdminManager();
		assertNotNull(am);
	}

	@Test
	void testAddAdmin() {
		AdminManager am = new AdminManager();
		Admin a1 = new Admin("Jacob", "Carlstrom", "jcstorm8","password");
		am.addAdmin(a1);
		assertEquals(1, am.getNumAdmins());
	}

	@Test
	void testGetAdminNull() {
		AdminManager am = buildAM();
		assertNull(am.getAdmin(""));
	}

	@Test
	void testGetAdminSuccess() {
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
