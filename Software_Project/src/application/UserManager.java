package application;

import java.util.HashMap;

public class UserManager {
	
	// String (User username)
	private HashMap<String, User> users = new HashMap<String, User>();
	private User activeUser;
	
	public UserManager() { }
	
	public boolean addUser(User user) {
		if (!users.containsKey(user.getUsername())) {
			users.put(user.getUsername(), user);
			return true;
		}
		return false;
	}
	
	public boolean removeUser(User user) {
		if (users.containsKey(user.getUsername())) {
			users.remove(user.getUsername());
			return true;
		}
		return false;
	}
	
	public int getNumUsers() {
		return users.size();
	}
	
	public User getUser(String username) {
		if (users.containsKey(username)) {
			return users.get(username);
		}
		return null;
	}
	
	public boolean hasUser(String username) {
		if (users.containsKey(username)) {
			return true;
		}
		return false;
	}
	
	public void setActiveUser(User user) {
		this.activeUser = user;
	}
	
	public User getActiveUser() {
		return this.activeUser;
	}
	
	public HashMap<String, User> getHashMap() {
		return this.users;
	}
	
	public void clear() {
		users.clear();
	}
	
	public String toString() {
		String info = "Users: ";
		
		for (User user : users.values()) {
			info += user.getUsername() + ", ";
		}
		
		info += "\n";
		return info;
	}

}