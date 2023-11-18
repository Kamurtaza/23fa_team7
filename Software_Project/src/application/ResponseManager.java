package application;

import java.util.HashMap;

public class ResponseManager {

	// String (Response text)
	private HashMap<String, Response> responses = new HashMap<String, Response>();
	
	public ResponseManager() { }
	
	public boolean addResponse(Response response) {
		if (!responses.containsKey(response.getText())) {
			responses.put(response.getText(), response);
			return true;
		}
		return false;
	}
	
	public boolean removeResponse(Response response) {
		if (responses.containsKey(response.getText())) {
			responses.remove(response.getText());
			return true;
		}
		return false;
	}
	
	public int getNumResponses() {
		return responses.size();
	}
	
	public Response getResponse(String responseText) {
		if (responses.containsKey(responseText)) {
			return responses.get(responseText);
		}
		return null;
	}
	
	public boolean hasResponse(String responseText) {
		if (responses.containsKey(responseText)) {
			return true;
		}
		return false;
	}
	
	public HashMap<String, Response> getHashMap() {
		return this.responses;
	}
	
	public void clear() {
		responses.clear();
	}
	
	public String toString() {
		String info = "Responses:\n";
		
		for (Response response : responses.values()) {
			info += response.getText() + "\n";
		}
		
		return info;
	}
	
}