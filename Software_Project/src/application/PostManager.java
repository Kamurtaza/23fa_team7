package application;

import java.util.HashMap;
import java.util.ArrayList;

public class PostManager {

	// String (Post Name)
	private HashMap<String, Post> posts = new HashMap<String, Post>();
  private ArrayList<Post> postsList = new ArrayList<>();
	
	public PostManager() { }
	
	public boolean addPost(Post post) {
		if (!posts.containsKey(post.getTitle())) {
			posts.put(post.getTitle(), post);
      postsList.add(post)
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
	
	public int getNumPosts() {
		return posts.size();
	}
	

	public Post getPost(String postName) {
		if (posts.containsKey(postName)) {
			return posts.get(postName);
    }
    return null;
  }
  
	public Post getPost(Group g, String text) {
		for(int i = 0; i < getNumPosts(); i++) {
			if(posts.get(i).getGroup().equals(g) && posts.get(i).getText().equals(text)) {
				return posts.get(i);
			}
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
	
	public String toString() {
		String info = "Posts: ";
		
		for (Post post : posts.values()) {
			info += post.getTitle() + ", ";
		}
		
		info += "\n";
		return info;
	}
      
	public boolean containsPost(Group g, String text) {
		for(int i = 0; i < getNumPosts(); i++) {
			if(posts.get(i).getGroup().equals(g) && posts.get(i).getText().equals(text)) {
				return true;
			}
		}
		return false;
	}
	
	//Returns list of Responses to a Post
	public ArrayList<Response> responseToPostList(Post p) {
		if(posts.contains(p)) {
			ArrayList<Response> dummy = new ArrayList<>();
			for(int i = 0; i < p.getNumResponses(); i++) {
				dummy.add(p.getResponse(i));
			}
			ResponseComparator rc = new ResponseComparator();
			Collections.sort(dummy,rc);
			return dummy;
		}
		return null;
	}
}