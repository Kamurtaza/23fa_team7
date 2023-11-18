package application;

import java.time.LocalDate;

public class RegisterValidator {
	
	private static Persistence persistence = new Persistence();
	private static UserManager userManager;
	
	public static boolean isRegistrationValid(String username, String password, String rePassword, String name,
									  LocalDate birthday, String country, String state, String city) {
		persistence.loadData();
		userManager = persistence.getUserManager();
		
		if (usernameValid(username) && passwordValid(password, rePassword) && nameValid(name)
			&& birthdayValid(birthday) && locationValid(country, state, city)) {
			return true;
		}
		
		return false;
	}
	
	public static boolean usernameValid(String username) {
		if (!username.isEmpty() && !userManager.hasUser(username)) {
			return true;
		}
		return false;
	}
	
	public static boolean passwordValid(String password, String rePassword) {
		if (!password.isEmpty() && password.equals(rePassword)) {
			return true;
		}
		return false;
	}
	
	public static boolean nameValid(String name) {
		if (name != null) {
			return true;
		}
		return false;
	}
	
	public static boolean birthdayValid(LocalDate birthday) {
		if (birthday != null) {
			return true;
		}
		return false;
	}
	
	public static boolean locationValid(String country, String state, String city) {
		if ((country != null) && (state != null) && (city != null)) {
			return true;
		}
		return false;
	}
}