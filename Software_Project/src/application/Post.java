package application;

import java.util.ArrayList;

public class Post {
	private Group group;
	private String text;
	private ArrayList<Response> responses = new ArrayList<>();
	
	public Post(Group group, String text) {
		this.group = group;
		this.text = text;
	}
	
	public Group getGroup() {
		return group;
	}
	
	public String getText() {
		return text;
	}
	
	public Response getResponse(int index) {
		return responses.get(index);
	}
	
	public Response getResponseWithText(String text) {
		for(Response r: responses) {
			if(r.getText().equals(text)) {
				return r;
			}
		}
		return null;
	}
	
	public void addResponse(Response r) {
		responses.add(r);
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Post) {
			Post p = (Post)o;
			if(this.text.equals(p.text)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Post in group " + group + ":\n" + text;
	}
}
