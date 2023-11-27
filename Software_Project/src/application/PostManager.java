package application;

import java.util.HashMap;
import java.util.Map;

public class PostManager {

	// String (Post Name)
	private HashMap<String, Post> posts = new HashMap<String, Post>();
	
	public PostManager() { }
	
	public void flagPost(Post post) {
		post.setFlag();
	}
	
	public void removeFlag(Post post) {
		post.removeFlag();	
	}
	
	public boolean addPost(Post post) {
		if (!posts.containsKey(post.getTitle())) {
			posts.put(post.getTitle(), post);
			return true;
		}
		return false;
	}
	
	public boolean removePost(Post post) {
		if (posts.containsKey(post.getTitle())) {
			posts.remove(post.getTitle());
			return true;
		}
		return false;
	}
	
	public int getNumPosts() {
		return posts.size();
	}
	
	public Post getPost(String postName) {
		if (posts.containsKey(postName)) {
			return posts.get(postName);
		}
		return null;
	}
	
	public boolean hasPost(String postName) {
		if (posts.containsKey(postName)) {
			return true;
		}
		return false;
	}
	
	public HashMap<String, Post> getHashMap() {
		return this.posts;
	}
	
	public void clear() {
		posts.clear();
	}
	
	public HashMap<String, Post> getFlaggedPosts(){
		HashMap<String, Post> flaggedPosts= new HashMap<>();
		for (Map.Entry<String, Post> entry : posts.entrySet()) {
	        String postId = entry.getKey();
	        Post post = entry.getValue();
	        if(post.isFlagged()) {
				flaggedPosts.put(postId, post);
			}
		}
		return flaggedPosts;
	}
	
	public String toString() {
		String info = "Posts: ";
		
		for (Post post : posts.values()) {
			info += post.getTitle() + ", ";
		}
		
		info += "\n";
		return info;
	}
	
}