package application;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

public class Post {
	
	private String title, text;
	private Group group;
	HashMap<String, Response> responses = new HashMap<String, Response>();
	private LocalDate date;
	private LocalTime time;
	private Boolean flagged;
	
	public Post(String title, String text, Group group, LocalDate date, LocalTime time) {
		this.title = title;
		this.text = text;
		this.group = group;
		this.date = date;
		this.time = time;
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
	}
	
	public Group getGroup() {
		return this.group;
	}
	
	public void setGroup(Group group) {
		this.group = group;
	}
	
	public LocalDate getDate() {
		return this.date;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public LocalTime getTime() {
		return this.time;
	}
	
	public void setTime(LocalTime time) {
		this.time = time;
	}
	
	public Boolean getFlagged() {
		return this.flagged;
	}
	
	public void setFlagged(Boolean flag) {
		this.flagged = flag;
	}
	
	public Response getResponse(String text) {
		return responses.get(text);
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