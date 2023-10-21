package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AdminTest {

	@Test
	void testEquals_false() {
		Admin a = new Admin("Jacob","Carlstrom", "jcstorm8", "password1");
		Admin a2 = new Admin("Jacob", "Carlstrom", "asdf", "password2");
		assertNotEquals(a, a2);
	}
	
	@Test
	void testEquals_true() {
		Admin a = new Admin("Jacob","Carlstrom", "jcstorm8", "password1");
		Admin a2 = new Admin("Jacob", "Carlstrom", "jcstorm8", "password2");
		assertEquals(a, a2);
	}
	
	@Test
	void testEquals_notAdmin() {
		Admin a = new Admin("Jacob","Carlstrom", "jcstorm8", "password1");	
		int x = 2;
		assertNotEquals(a, x);
	}
	
	@Test
	void testToString() {
		Admin a = new Admin("Jacob","Carlstrom", "jcstorm8", "password1");	
		String expected = "Jacob Carlstrom, jcstorm8";
		String actual = a.toString();
		assertEquals(expected, actual);
	}
}
