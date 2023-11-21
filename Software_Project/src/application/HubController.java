package application;

import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class HubController {

	@FXML
	private AnchorPane mainView;
	@FXML
	private Button HubPostHistory;
	@FXML
	private Button HubResponseHistory;
	@FXML
	private Button HubFlaggedPosts;
	@FXML
	private Button HubFlaggedResponses;
	@FXML
	private Button HubSuspended;
	@FXML
	private Button HubBanned;
	@FXML
	private Button HubUsers;
	
	//how do you initialize the CategoryManager?
	private CategoryManager categoryManager;
	
	//how do you initialize the GroupManager?
	private GroupManager groupManager;
	
	//how do you initialize the PostManager?
	private PostManager postManager;
	
	@FXML
	private void handleChangeView(ActionEvent event) {
		try {
			String requestedPage = ((Button) event.getSource()).getId();
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource(requestedPage + ".fxml"));
			loader.setController(this);
			
			mainView.getChildren().add(loader.load());
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Initially, all categories are shown
	private ArrayList<Category> displayCategories() {
		return categoryManager.categoryList();
	}
	
	//Clicking a category will replace all shown categories with all groups within clicked category
	private ArrayList<Group> displayGroupsInCategory(Category c) {
		return categoryManager.groupsInCategoryList(c);
	}
	
	//Clicking a group will replace all shown groups with all posts within clicked group
	private ArrayList<Post> displayPostsInGroup(Group g) {
		return groupManager.postList(g);
	}
	
	//Clicking a post will replace all shown posts with the initial post followed by all responses within clicked post
	private ArrayList<Response> displayResponsesToPost(Post p) {
		return postManager.responseToPostList(p);
	}
}
