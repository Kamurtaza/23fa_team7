package application;

import javafx.fxml.FXML;

import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

public class HubHomeController {
	
	private Persistence persistence = new Persistence();
	private CategoryManager categoryManager = new CategoryManager();
	private GroupManager groupManager = new GroupManager();
	private PostManager postManager = new PostManager();
	private ResponseManager responseManager = new ResponseManager();

	// First show categories
	// Second show groups
	//		Ability to request groups
	// Third show posts
	//		Ability to create posts
	// Fourth show responses
	//		Ability to create responses
	
	@FXML
	void showCategories() {
		persistence.loadData();
		categoryManager = persistence.getCategoryManager();
		
		ArrayList<Category> categories = new ArrayList<>(categoryManager.getHashMap().values());
		for (Category category : categories) {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("CategoryItem.fxml"));
			
			try {
				VBox vBox = (VBox) fxmlLoader.load();
				CategoryItemController categoryController = fxmlLoader.getController();
				categoryController.setData(category);
				sPaneView.setContent(vBox);
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@FXML
	void showGroups() {
		persistence.loadData();
		groupManager = persistence.getGroupManager();
		
		ArrayList<Group> groups = new ArrayList<>(groupManager.getHashMap().values());
		for (Group group : groups) {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("GroupItem.fxml"));
			
			try {
				VBox vBox = (VBox) fxmlLoader.load();
				GroupItemController groupController = fxmlLoader.getController();
				groupController.setData(group);
				sPaneView.setContent(vBox);
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@FXML
	void requestGroup() {
		
	}
	
	@FXML
	void showPosts() {
		persistence.loadData();
		postManager = persistence.getPostManager();
		
		ArrayList<Post> posts = new ArrayList<>(postManager.getHashMap().values());
		for (Post post : posts) {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("PostItem.fxml"));
			
			try {
				VBox vBox = (VBox) fxmlLoader.load();
				PostItemController postController = fxmlLoader.getController();
				postController.setData(post);
				sPaneView.setContent(vBox);
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@FXML
	void createPost() {
		
	}
	
	@FXML
	void flagPost() {
		
	}
	
	// ADD
	// Ability to upvote/downvote post other than own
	
	@FXML
	void showResponses() {
		persistence.loadData();
		responseManager = persistence.getResponseManager();
		
		ArrayList<Response> responses = new ArrayList<>(responseManager.getHashMap().values());
		for (Response response : responses) {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("ResponseItem.fxml"));
			
			try {
				VBox vBox = (VBox) fxmlLoader.load();
				ResponseItemController responseController = fxmlLoader.getController();
				responseController.setData(response);
				sPaneView.setContent(vBox);
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@FXML
	void createResponse() {
		
	}
	
	@FXML
	void flagResponse() {
		
	}
	
	// ADD
	// Ability to upvote/downvote response other than own
	
}