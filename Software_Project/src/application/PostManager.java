package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class PostManager {
	
	private ArrayList<Post> posts = new ArrayList<>();
	
	public PostManager() {}
	
	public void addPost(Post p) {
		posts.add(p);
	}
	
	public int getNumPosts() {
		return posts.size();
	}
	
	public Post getPost(Group g, String text) {
		for(int i = 0; i < getNumPosts(); i++) {
			if(posts.get(i).getGroup().equals(g) && posts.get(i).getText().equals(text)) {
				return posts.get(i);
			}
		}
		return null;
	}
	
	public void clear() {
		posts.clear();
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