package application;

// COME BACK TO ME
// Each method should return a status rather than a boolean
// Expand upon each function
public class Validator {

	public boolean isUserValid(String username) {
		if (username.isBlank()) {
			return false;
		}
		return true;
	}
	
	public boolean isCategoryValid(String title) {
		if (title.isBlank()) {
			return false;
		}
		return true;
	}
	
	public boolean isGroupValid(String title) {
		if (title.isBlank()) {
			return false;
		}
		return true;
	}
	
	public boolean isPostValid(String title, String text) {
		if (title.isBlank() || text.isBlank()) {
			return false;
		}
		return true;
	}
	
	public boolean isResponseValid(String text) {
		if (text.isBlank()) {
			return false;
		}
		return true;
	}
	
	public static boolean isLoginValid(String username, String password) {
		Persistence persistence = new Persistence();
		persistence.loadData();
		UserManager userManager = persistence.getUserManager();
		
		if (userManager.getUser(username) != null) {
			if (userManager.getUser(username).getPassword().equals(password)) {
				return true;
			}
		}
		
		return false;
	}
	
}