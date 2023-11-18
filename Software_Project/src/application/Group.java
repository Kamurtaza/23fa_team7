package application;

import java.util.ArrayList;
import java.util.HashMap;


public class Group {
	
	private String title;
	private Category category;
	HashMap<String, Post> posts = new HashMap<String, Post>();
	
	public Group(String title, Category category) {
		this.title = title;
		this.category = category;
	}

	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public Category getCategory() {
		return this.category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public Post getPost(String title) {
		return posts.get(title);
	}
	
	public boolean addPost(Post post) {
		if (!posts.containsKey(post.getTitle())) {
			posts.put(post.getTitle(), post);
			return true;
		}
		return false;
	}
	
	public ArrayList<Post> getPosts() {
		ArrayList<Post> postList = new ArrayList<Post>();
		
		for (Post post : posts.values()) {
			postList.add(post);
		}
		
		return postList;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Group) {
			Group group = (Group)obj;
			if (this.title.equals(group.title)) {

				return true;
			}
		}
		return false;
	}

	public String toString() {
		String info = "Group: " + title + "\nPosts: ";
		
		for (Post post : posts.values()) {
			info += post.toString() + ", ";
		}
		
		return info;
	}
	
}