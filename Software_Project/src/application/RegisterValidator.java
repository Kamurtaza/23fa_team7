package application;

public class RegisterValidator {
	
	public boolean nameVal(String name) {
		if (!name.isEmpty()) {
			return true;
		}
		return false;
	}
	
	public boolean usernameVal(String username) {
		if (!username.isEmpty()) {
			return true;
		}
		return false;
	}
	
	// Come back later to add actual password requirements
	public boolean passwordVal(String password) {
		if (!password.isEmpty()) {
			return true;
		}
		return false;
	}

	public boolean passwordMatchVal(String password, String rePassword) {
		if (password.equals(rePassword)) {
			return true;
		}
		return false;
	}
	
	// Not sure if we want to restrict to certain age
	// Come back later to add actual birthday requirements
	//	public boolean birthVal() {
	//		
	//	}
	
	public boolean locationVal(String country, String state, String city) {
		if (country.isEmpty() || state.isEmpty() || city.isEmpty()) {
			return false;
		}
		return true;
	}
	
}