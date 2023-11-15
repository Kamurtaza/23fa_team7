package application;

import java.util.ArrayList;
import java.util.HashMap;

public class Group {
	ArrayList<Post> posts = new ArrayList<>();
	private String title;
	private Category category;
	
	public Group(String name, Category category) {
		this.title = name;
		this.category = category;
	}
	
	public String getTitle() {
		return title;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public void addPost(Post p) {
		posts.add(p);
	}
	
	public Post getPost(int index) {
		if(index >= 0 && index < posts.size()) { 
			return posts.get(index);
		}
		return null;
	}
	
	public Post getPostWithText(String text) {
		for(Post p : posts) {
			if(p.getText().equals(text)) {
				return p;
			}
		}
		return null;
	}
	
	public int getNumPosts() {
		return posts.size();
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Group) {
			Group g = (Group)o;
			if(this.title.equals(g.title)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return title;
	}
}
