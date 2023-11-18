package unit_tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import application.Admin;

class AdminTest {

	@Test
	void testEquals_false() {
		Admin a = createAdmin();
		Admin a2 = new Admin("Bob Smith", "asdf", "password", "01/01/2000", "Atlanta", "GA", "USA");
		assertNotEquals(a, a2);
	}
	
	@Test
	void testEquals_true() {
		Admin a = createAdmin();
		Admin a2 = new Admin("Bob Smith", "jcstorm8", "password", "01/01/2000", "Atlanta", "GA", "USA");
		assertEquals(a, a2);
	}
	
	@Test
	void testEquals_notAdmin() {
		Admin a = createAdmin();
		int x = 2;
		assertNotEquals(a, x);
	}
	
	@Test
	void testToString() {
		Admin a = createAdmin();
		String expected = "Jacob Carlstrom\nUsername: jcstorm8\nPassword: password123\nBirthday: 06/30/2003\nLocation: Valdosta, GA, USA";
		String actual = a.toString();
		assertEquals(expected, actual);
	}
	
	/*
	 * HELPER METHOD
	 */
	
	public Admin createAdmin() {
		return new Admin("Jacob Carlstrom", "jcstorm8", "password123", "06/30/2003", "Valdosta", "GA", "USA");
	}
}
