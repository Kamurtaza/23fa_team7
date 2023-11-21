package application;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Post {
	private Group group;
	private String text;
	private LocalDate date;
	private LocalTime time;
	private ArrayList<Response> responses = new ArrayList<>();
	
	public Post(Group group, String text, LocalDate date, LocalTime time) {
		this.group = group;
		this.text = text;
		this.date = date;
		this.time = time;
	}
	
	public Group getGroup() {
		return group;
	}
	
	public String getText() {
		return text;
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
	
	public Response getResponseWithText(String text) {
		for(Response r: responses) {
			if(r.getText().equals(text)) {
				return r;
			}
		}
		return null;
	}
	
	public int getNumResponses() {
		return responses.size();
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
		return "Post in group " + group + ":\n" + text
				+ "\nOn " + date.toString() + " at "+ time.toString();
	}
}
