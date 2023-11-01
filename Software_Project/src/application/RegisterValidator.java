package application;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class RegisterValidator {
	private static final String USERS = "C:\\Users\\mdami\\git\\Team7New\\23fa_team7\\Software_Project\\json\\users.json";

	private boolean userValid;
	private List<String> errorMessages = new ArrayList<>();



	public RegisterValidator() {
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

	private void writeToJsonFile(JSONObject users) {
		try (FileWriter file = new FileWriter(USERS)){
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String jsonString = gson.toJson(users);
			file.write(jsonString);
			file.flush();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean nameVal(String name) {
		if (!name.isEmpty()) {
			return true;
		}
		return false;
	}

	public boolean usernameVal(String username) {
		if (username.isEmpty()) {
			return false;
		}
		JSONObject users = readJsonFile(USERS);
		JSONArray usersArray = (JSONArray)users.get("users");
		for (Object userObj : usersArray) {
			JSONObject user = (JSONObject) userObj;
			String existUsername = (String) user.get("username");
			if(existUsername.equals(username)) {
				System.out.println("Username taken");
				return false;
			}
		}
		return true;
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

	public boolean locationVal(String country, String state, String city) {
		if (country.isEmpty() || state.isEmpty() || city.isEmpty()) {
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public boolean validateRegistration(String username, String password, String rePassword, String name, String birthday, String country, String state, String city) {
		errorMessages.clear();
		userValid = true;
		if (!nameVal(name)) {
	        errorMessages.add("Name field cannot be empty");
	        userValid = false;
	    }

	    if (!usernameVal(username)) {
	        errorMessages.add("Username field cannot be empty or username is taken");
	        userValid = false;
	    }

	    if (!passwordVal(password) || !passwordMatchVal(password, rePassword)) {
	    	errorMessages.add("Passwords do not match or are invalid.");
	        userValid = false;
	    }

	    if (!locationVal(country, state, city)) {
	    	errorMessages.add("One or more location entries are empty.");
	        userValid = false;
	    }
	    if(userValid) {
	    	JSONObject location = new JSONObject();
            location.put("country", country);
            location.put("state", state);
            location.put("city", city);

	    	JSONObject newUser = new JSONObject();
	    	newUser.put("username", username);
	    	newUser.put("password", password); // Hash the password before saving it
            newUser.put("name", name);
            newUser.put("birthday", birthday);
            newUser.put("location", location);

            JSONObject users = readJsonFile(USERS);
            JSONArray usersArray = (JSONArray)users.get("users");
            usersArray.add(newUser);
            users.put("users", usersArray);

            writeToJsonFile(users);
	    }
	    return userValid;
	}

	public List<String> getErrorMessages(){
		return errorMessages;
	}
}