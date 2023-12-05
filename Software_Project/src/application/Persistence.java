package application;

import java.util.HashMap;
import java.util.Iterator;
import java.time.LocalDate;
import java.time.LocalTime;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Persistence {
	
	private UserManager userManager = new UserManager();
	private CategoryManager categoryManager = new CategoryManager();
	private GroupManager groupManager = new GroupManager();
	private PostManager postManager = new PostManager();
	private ResponseManager responseManager = new ResponseManager();
	
	private String DATA = "json/data.json";
	private JSONObject storedData;
	
	private JSONObject mainObj;
	private JSONObject secondObj;
	
	public Persistence() { }
	
	public void loadData() {
		readJsonFile();
		buildUserManager();
		buildCategoryManager();
		buildGroupManager();
		buildPostManager();
		buildResponseManager();
	}
	
	public void saveData() {
		JSONObject users = saveUserManager();
		JSONObject categories = saveCategoryManager();
		JSONObject groups = saveGroupManager();
		JSONObject posts = savePostManager();
		saveResponseManager();
		writeToJson(users, categories, groups, posts, mainObj, secondObj);
	}
	
	public void readJsonFile() {
		JSONParser jsonParser = new JSONParser();
		
		try (FileReader reader = new FileReader(DATA)) {
			Object obj = jsonParser.parse(reader);
			storedData = (JSONObject) obj;
		}
		catch (IOException | ParseException e) {
			e.printStackTrace();
		}
	}
	
	public JSONObject getJsonFile() {
		JSONParser jsonParser = new JSONParser();
		JSONObject storedData = null;
		
		try (FileReader reader = new FileReader(DATA)) {
			Object obj = jsonParser.parse(reader);
			storedData = (JSONObject) obj;
		}
		catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		return storedData;
	}
	
	@SuppressWarnings("unchecked")
	public void buildUserManager() {
		JSONArray usersArray = (JSONArray) storedData.get("users");
		
		Iterator<JSONObject> iter = usersArray.iterator();
		while (iter.hasNext()) {
			JSONObject loadedUser = iter.next();
			userManager.addUser(convertToUser(loadedUser));
		}
		
	}
	
	public void buildCategoryManager() {
		JSONArray categoriesArray = (JSONArray) storedData.get("categories");
		
		for (int i = 0; i < categoriesArray.size(); i++) {
			String loadedCategory = (String) categoriesArray.get(i);
			categoryManager.addCategory(new Category(loadedCategory));
		}
	}
	
	@SuppressWarnings("unchecked")
	public void buildGroupManager() {
		JSONArray groupsArray = (JSONArray) storedData.get("groups");
		
		Iterator<JSONObject> iter = groupsArray.iterator();
		while (iter.hasNext()) {
			JSONObject loadedGroup = iter.next();
			String parentCategory = (String)loadedGroup.get("parentCategory");
			Group group = convertToGroup(loadedGroup);
			
			categoryManager.getCategory(parentCategory).addGroup(group);
			groupManager.addGroup(group);
		}
	}
	
	@SuppressWarnings("unchecked")
	public void buildPostManager() {
		JSONArray postsArray = (JSONArray) storedData.get("posts");
		
		Iterator<JSONObject> iter = postsArray.iterator();
		while (iter.hasNext()) {
			JSONObject loadedPost = iter.next();
			String parentGroup = (String)loadedPost.get("parentGroup");
			Post post = convertToPost(loadedPost);
			
			groupManager.getGroup(parentGroup).addPost(post);
			postManager.addPost(post);
		}
	}
	
	@SuppressWarnings("unchecked")
	public void buildResponseManager() {
		JSONArray responsesArray = (JSONArray) storedData.get("responses");
		
		Iterator<JSONObject> iter = responsesArray.iterator();
		while (iter.hasNext()) {
			JSONObject loadedResponse = iter.next();
			String parentPost = (String)loadedResponse.get("parentPost");
			Response response = convertToResponse(loadedResponse);
			
			postManager.getPost(parentPost).addResponse(response);
			responseManager.addResponse(response);
			
		}
		
		responsesArray = (JSONArray) storedData.get("responseResponses");
		
		iter = responsesArray.iterator();
		while (iter.hasNext()) {
			JSONObject loadedResponse = iter.next();
			String parentResponse = (String)loadedResponse.get("parentResponse");
			Response response = convertToResponse(loadedResponse);
			
			responseManager.getResponse(parentResponse).addResponse(response);
			response.setParentResponse(responseManager.getResponse(parentResponse));
			responseManager.addResponse(response);
		}
	}
	
	public UserManager getUserManager() {
		return this.userManager;
	}
	
	public CategoryManager getCategoryManager() {
		return this.categoryManager;
	}
	
	public GroupManager getGroupManager() {
		return this.groupManager;
	}
	
	public PostManager getPostManager() {
		return this.postManager;
	}
	
	public ResponseManager getResponseManager() {
		return this.responseManager;
	}
	
	public User convertToUser(JSONObject obj) {
		String name = (String)obj.get("name");
		String username = (String)obj.get("username");
		String password = (String)obj.get("password");
		String birthday = (String)obj.get("birthday");
		String country = (String)obj.get("country");
		String city = (String)obj.get("city");
		String state = (String)obj.get("state");
		String role = (String)obj.get("role");
		User user = new User(name, username, password, birthday, city, state, country);
		user.setRole(role);
		return user;
	}
	
	public Group convertToGroup(JSONObject obj) {
		String title = (String)obj.get("title");
		String parentCategory = (String)obj.get("parentCategory");
		Group group = new Group(title, categoryManager.getCategory(parentCategory));
		return group;
	}
	
	public Post convertToPost(JSONObject obj) {
		String title = (String)obj.get("title");
		String text = (String)obj.get("text");
		String parentGroup = (String)obj.get("parentGroup");
		LocalDate date = (LocalDate)obj.get("date");
		LocalTime time = (LocalTime)obj.get("time");
		Post post = new Post(title, text, groupManager.getGroup(parentGroup), date, time);
		return post;
	}
	
	public Response convertToResponse(JSONObject obj) {
		String text = (String)obj.get("text");
		String parentPost = (String)obj.get("parentPost");
		Response response = new Response(text, postManager.getPost(parentPost), parentPost);
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject saveUserManager() {
		HashMap<String, User> users = userManager.getHashMap();
		JSONArray usersArray = new JSONArray();
		
		for (User user : users.values()) {
			JSONObject obj = new JSONObject();
			obj.put("name", user.getName());
			obj.put("username", user.getUsername());
			obj.put("password", user.getPassword());
			obj.put("birthday", user.getBirthday());
			obj.put("country", user.getCountry());
			obj.put("city", user.getCity());
			obj.put("state", user.getState());
			obj.put("role", user.getRole());
			usersArray.add(obj);
		}
		
		JSONObject mainObj = new JSONObject();
		mainObj.put("users", usersArray);
		return mainObj;
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject saveCategoryManager() {
		HashMap<String, Category> categories = categoryManager.getHashMap();
		JSONArray categoriesArray = new JSONArray();
		
		for (Category category : categories.values()) {
			categoriesArray.add(category.getTitle());
		}
		
		JSONObject mainObj = new JSONObject();
		mainObj.put("categories", categoriesArray);
		return mainObj;
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject saveGroupManager() {
		HashMap<String, Group> groups = groupManager.getHashMap();
		JSONArray groupsArray = new JSONArray();
		
		for (Group group : groups.values()) {
			JSONObject obj = new JSONObject();
			obj.put("title", group.getTitle());
			obj.put("parentCategory", group.getCategory().getTitle());
			groupsArray.add(obj);
		}
		
		JSONObject mainObj = new JSONObject();
		mainObj.put("groups", groupsArray);
		return mainObj;
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject savePostManager() {
		HashMap<String, Post> posts = postManager.getHashMap();
		JSONArray postsArray = new JSONArray();
		
		for (Post post : posts.values()) {
			JSONObject obj = new JSONObject();
			obj.put("title", post.getTitle());
			obj.put("text", post.getText());
			obj.put("parentGroup", post.getGroup().getTitle());
			obj.put("isFlagged", post.isFlagged());
			postsArray.add(obj);
		}
		
		JSONObject mainObj = new JSONObject();
		mainObj.put("posts", postsArray);
		return mainObj;
	}
	
	@SuppressWarnings("unchecked")
	public void saveResponseManager() {
		HashMap<String, Response> responses = responseManager.getHashMap();
		JSONArray responsesArray = new JSONArray();
		JSONArray responseResponsesArray = new JSONArray();
		
		for (Response response : responses.values()) {
			JSONObject obj = new JSONObject();
			obj.put("text", response.getText());
			obj.put("parentPost", response.getPost().getTitle());
			
			if (response.getParentResponse() == null) {
				responsesArray.add(obj);
			}
			else {
				obj.put("parentResponse", response.getParentResponse().getText());
				responseResponsesArray.add(obj);
			}
		}
		
		JSONObject mainObj = new JSONObject();
		mainObj.put("responses", responsesArray);
		
		JSONObject secondObj = new JSONObject();
		secondObj.put("responseResponses", responseResponsesArray);
		
		this.mainObj = mainObj;
		this.secondObj = secondObj;
	}
	
	@SuppressWarnings("unchecked")
	public void writeToJson(JSONObject users, JSONObject categories, JSONObject groups,
							JSONObject posts, JSONObject responses, JSONObject responseResponses) {
		JSONObject allData = new JSONObject();
		allData.put("users", users.get("users"));
		allData.put("categories", categories.get("categories"));
		allData.put("groups", groups.get("groups"));
		allData.put("posts", posts.get("posts"));
		allData.put("responses", responses.get("responses"));
		allData.put("responseResponses", responseResponses.get("responseResponses"));
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonData = gson.toJson(allData);
		
		try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(DATA, false))) {
			fileWriter.write(jsonData);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public void updatePostToJSON(Post post) {
		if(storedData != null) {
			JSONArray postArray = (JSONArray) storedData.get("posts");
			for(Object obj : postArray) {
				JSONObject postObject = (JSONObject) obj;
				String title = (String) postObject.get("title");
				if(title.equals(post.getTitle())) {
					postObject.put("text", post.getText());
					postObject.put("isFlagged", post.isFlagged());
					break;
				}
			}
			saveData();
		}
	}
}