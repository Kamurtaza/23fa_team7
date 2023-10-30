package application;

public class Response {
	private Post post;
	private String text;
	
	public Response(Post post, String text) {
		this.post = post;
		this.text = text;
	}
	
	public Post getPost() {
		return post;
	}
	
	public String getText() {
		return text;
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
		return "Response to post \"" + post.getText() + "\"\n\"" + text + "\"";
	}
}
