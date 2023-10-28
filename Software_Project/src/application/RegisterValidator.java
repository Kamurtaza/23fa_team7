package application;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class RegisterValidator {
	private static final String USERS = "src/User.json";
	private JSONObject users;
	private boolean userValid;
	private boolean registerSuccess;
	
	public RegisterValidator() {
		users = readJsonFile(USERS);
	}
	
	private JSONObject readJsonFile(String filePath) {
        JSONParser parser = new JSONParser();
        JSONObject users = null;

        try (FileReader reader = new FileReader(filePath)) {
            Object user = parser.parse(reader);
            users = (JSONObject) user;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return users;
    }
		
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
	
	public boolean isNewUser() {
	
}