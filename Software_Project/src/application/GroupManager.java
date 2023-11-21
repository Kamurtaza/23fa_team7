package application;

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
	
	public void clear() {
		groups.clear();
	}
	
	//Returns list of Posts in a Group based on date
	public ArrayList<Post> postList(Group g) {
		ArrayList<Post> dummy = new ArrayList<Post>();
		if(containsGroup(g.getTitle())) {
			for(int i = 0; i < g.getNumPosts(); i++) {
				dummy.add(g.getPost(i));
			}
			PostComparator pc = new PostComparator();
			Collections.sort(dummy,pc);
			return dummy;
		}
		return null;
	}
	
	@Override
	public String toString() {
		String info = "Groups: ";
		
		for (Group group : groups.values()) {
			info += group.getTitle() + ", ";
		}
		
		info += "\n";
		return info;
	}
}