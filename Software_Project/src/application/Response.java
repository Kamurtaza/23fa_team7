package application;

import java.util.ArrayList;
import java.util.HashMap;

public class Response {
	
	private String text;
	private Post post;
	HashMap<String, Response> responses = new HashMap<String, Response>();
	private Response parentResponse;
	private String author;
	
	public Response(String text, Post post, String author) {
        this.text = text;
        this.post = post;
        this.author = author;
    }
	
	public String getText() {
		return this.text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	public String getAuthor() {
		return this.author;
	}
	
	public Post getPost() {
		return this.post;
	}
	
	public void setPost(Post post) {
		this.post = post;
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
	
	public boolean equals(Object obj) {
		if (obj instanceof Response) {
			Response response = (Response)obj;
			if (this.text.equals(response.text)) {
				return true;
			}
		}
		return false;
	}
	
	  
	
	public String toString() {
		String info = "Response: " + text + "\nResponses: ";
		
		for (Response response : responses.values()) {
			info += response.toString() + ", ";
		}
		
		return info;
	}
	
}