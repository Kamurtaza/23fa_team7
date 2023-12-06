package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.time.LocalDate;
import java.time.LocalTime;

public class Response {
	
	private String text;
	private Post post;
	private User author;
	private LocalDate date;
	private LocalTime time;
	
	HashMap<String, Response> responses = new HashMap<String, Response>();
	private Response parentResponse;
	
	public Response(String text, Post post) {
		this.text = text;
  }
	public Response(String text, Post post, User author) {
		this.text = text;
		this.post = post;
		this.author = author;
	}
	
	public Response(Post post, String text, User author, LocalDate date, LocalTime time) {
		this.post = post;
		this.text = text;
		this.author = author;
		this.date = date;
		this.time = time;
	}
	
	public String getText() {
		return this.text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public Post getPost() {
		return this.post;
	}
	
	public void setPost(Post post) {
		this.post = post;
	}

	public User getAuthor() {
		return author;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public LocalTime getTime() {
		return time;
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
	
	public Response getParentResponse() {
		return this.parentResponse;
	}
	
	public void setParentResponse (Response parentResponse) {
		this.parentResponse = parentResponse;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Response) {
			Response r = (Response)o;
			if(this.text.equals(r.text)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		String info = "Response: " + text + "\nResponses: ";
		
		for (Response response : responses.values()) {
			info += response.getText() + ", ";
		}
		
		return info;
	}
	
}