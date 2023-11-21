package application;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

public class Post {
	
	private String title, text;
	private Group group;
	HashMap<String, Response> responses = new HashMap<String, Response>();
	
	public Post(String title, String text, Group group) {
		this.title = title;
		this.text = text;
  }
	private String text;
	private LocalDate date;
	private LocalTime time;
	private ArrayList<Response> responses = new ArrayList<>();
	
	public Post(Group group, String text, LocalDate date, LocalTime time) {
		this.group = group;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getText() {
		return this.text;
	}
	
	public void setText(String text) {
		this.text = text;
		this.date = date;
		this.time = time;
	}
	
	public Group getGroup() {
		return this.group;
	}
	
	public void setGroup(Group group) {
		this.group = group;
	}
	
	public Response getResponse(String text) {
		return responses.get(text);
}
	public LocalDate getDate() {
		return date;
	}
	
	public LocalTime getTime() {
		return time;
	}
	
	public void addResponse(Response r) {
		responses.add(r);
	}
	
	public Response getResponse(int index) {
		if(index >= 0 && index < responses.size()) {
			return responses.get(index);

		}
		return null;
	}
	
	public boolean addResponse(Response response) {
		if (!responses.containsKey(response.getText())) {
			responses.put(response.getText(), response);
			return true;
		}
		return false;
	}
	
	public ArrayList<Response> getResponses() {
		ArrayList<Response> responseList = new ArrayList<Response>();
		
		for (Response response : responses.values()) {
			responseList.add(response);
		}
		
		return responseList;
}
	public int getNumResponses() {
		return responses.size();
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Post) {
			Post post = (Post)obj;
			if (this.title.equals(post.title)) {
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		String info = "Post: " + title + "\nResponses: ";
		
		for (Response response : responses.values()) {
			info += response.toString() + ", ";
		}
		
		return info;
	}
	
}