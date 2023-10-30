package application;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LoginValidator {
	
	private static final String USERS = "C:\\\\Users\\\\mdami\\\\git\\\\Team7New\\\\23fa_team7\\\\Software_Project\\\\json\\\\users.json";
	private JSONObject users;
	private List<String> errorMessages = new ArrayList<String>();
	private JSONObject currentUser;
	
	public LoginValidator() {
		this.users = readJsonFile(USERS);
	}
	
	public boolean validateLogin(String username, String password) {
		errorMessages.clear();
		if(userExists(username)) {
			String storedPassword = (String)currentUser.get("password");
			if(storedPassword.equals(password)) {
				return true;
			}
			else {
		errorMessages.add("Invalid password. Please try again.");
		return false;
			}
		}
		else {
			errorMessages.add("Invalid username. Please try again or register an account.");
			return false;
		}
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
	
	public boolean userExists(String username) {
		JSONArray usersArray = (JSONArray)users.get("users");	
		@SuppressWarnings("unchecked")
		Iterator<JSONObject> iter = usersArray.iterator();
		while(iter.hasNext()){
			JSONObject user = iter.next();
			String storedUsername = (String)user.get("username");
			if (storedUsername.equals(username)) {
				currentUser = user;
				return true;
			}
		}
		return false;
	}

	public List<String> getErrorMessages() {
		return errorMessages;
	}
}
