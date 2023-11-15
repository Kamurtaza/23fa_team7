package application;

import java.time.LocalDate;
import java.time.LocalTime;

public class Response {
	private Post post;
	private String text;
	private LocalDate date;
	private LocalTime time;
	
	public Response(Post post, String text, LocalDate date, LocalTime time) {
		this.post = post;
		this.text = text;
		this.date = date;
		this.time = time;
	}
	
	public Post getPost() {
		return post;
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
		return "Response to post \"" + post.getText() + "\":\n\"" + text
				+ "\"\nOn " + date.toString() + " at "+ time.toString();
	}
}
