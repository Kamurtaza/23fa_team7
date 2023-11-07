package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class GroupManager {
	private HashMap<String,Group> groups = new HashMap<String,Group>();
	
	public GroupManager() {}
	
	public void addGroup(Group g) {
		groups.put(g.getTitle(), g);
	}
	
	public int getNumGroups() {
		return groups.size();
	}
	
	public Group getGroup(String title) {
		if(groups.containsKey(title)) {
			return groups.get(title);
		}
		return null;
	}
	
	public void clear() {
		groups.clear();
	}
	
	public boolean containsGroup(String title) {
		if(groups.containsKey(title)) {
			return true;
		}
		return false;
	}
	
	//Returns alphabetical list of Groups
	public ArrayList<Group> groupList() {
		ArrayList<Group> dummy = new ArrayList<Group>();
		for(Group g : groups.values()) {
			dummy.add(g);
		}
		GroupComparator gc = new GroupComparator();
		Collections.sort(dummy,gc);
		return dummy;
	}
	
	@Override
	public String toString() {
		String ret = "Groups:\n";
		for(Group g : groups.values()) {
			ret += g + "\n";
		}
		return ret;
	}
}