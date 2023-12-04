package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class GroupManager {

	// String (Group Name)
	private HashMap<String, Group> groups = new HashMap<String, Group>();
	
	public GroupManager() { }
	
	public boolean addGroup(Group group) {
		if (!groups.containsKey(group.getTitle())) {
			groups.put(group.getTitle(), group);
			return true;
		}
		return false;
	}
	
	public boolean removeGroup(Group group) {
		if (groups.containsKey(group.getTitle())) {
			groups.remove(group.getTitle());
			return true;
		}
		return false;
	}
	
	public int getNumGroups() {
		return groups.size();
	}
	
	public Group getGroup(String groupName) {
		if (groups.containsKey(groupName)) {
			return groups.get(groupName);
		}
		return null;
	}
	
	public boolean hasGroup(String groupName) {
		if (groups.containsKey(groupName)) {
			return true;
		}
		return false;
	}

	public HashMap<String, Group> getHashMap() {
		return this.groups;
	}
	
	// Managers need to be able to return hashmaps in alphabetical order
	
	public void clear() {
		groups.clear();
	}
	
	public String toString() {
		String info = "Groups: ";
		
		for (Group group : groups.values()) {
			info += group.getTitle() + ", ";
		}
		
		info += "\n";
		return info;
	}
}