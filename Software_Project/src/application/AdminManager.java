package application;

import java.util.HashMap;

public class AdminManager {
	private HashMap<String, Admin> admins = new HashMap<String, Admin>();
	
	public AdminManager() {}
	
	public void addAdmin(Admin a) {
		admins.put(a.getUsername(), a);
	}	
	
	public int getNumAdmins() {
		return admins.size();
	}
	
	public Admin getAdmin(String username) {
		if(containsAdmin(username)) {
			return admins.get(username);
		}
		return null;
	}
	
	public void clear() {
		admins.clear();
	}
	
	public boolean containsAdmin(String username) {
		return admins.containsKey(username);
	}
	
	@Override
	public String toString() {
		String ret = "Admins:\n";
		for(Admin a : admins.values()) {
			ret += a + "\n";
		}
		return ret;
	}
}
