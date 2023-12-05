package application;

import javafx.fxml.FXML;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class HubHomeController implements Initializable {
	
	private Persistence persistence = new Persistence();
	private CategoryManager categoryManager = new CategoryManager();
	private GroupManager groupManager = new GroupManager();
	private PostManager postManager = new PostManager();
	private ResponseManager responseManager = new ResponseManager();
	
	private Category selectedCategory;
	private Group selectedGroup;
	private Post selectedPost;

	// First show categories
	// Second show groups
	//		Ability to request groups
	// Third show posts
	//		Ability to create posts
	// Fourth show responses
	//		Ability to create responses
	
	@FXML
    private ImageView imgSearch;

    @FXML
    private ImageView imgSortAlpha;

    @FXML
    private ImageView imgSortLike;

    @FXML
    private ScrollPane sPaneView;

    @FXML
    private TextField txtFieldSearch;
    
    public HubHomeController() { }

    @FXML
    void searchUsers(MouseEvent event) {

    }

    @FXML
    void sortAlpha(MouseEvent event) {

    }

    @FXML
    void sortSuspensions(MouseEvent event) {

    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	showCategories();
    }
	
	@FXML
	void showCategories() {
		persistence.loadData();
		categoryManager = persistence.getCategoryManager();
		VBox vBoxCategories = new VBox();
				
		ArrayList<Category> categories = new ArrayList<>(categoryManager.getHashMap().values());
		System.out.println(categories);
		for (Category category : categories) {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("CategoryItem.fxml"));
			
			try {
				VBox vBox = fxmlLoader.load();
				CategoryItemController categoryController = fxmlLoader.getController();
				categoryController.setData(category);
				vBoxCategories.getChildren().add(vBox);
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		sPaneView.setContent(vBoxCategories);
	}
	
	void showGroups(Category category) {
		selectedCategory = category;
		persistence.loadData();
		groupManager = persistence.getGroupManager();
		System.out.println(groupManager.getNumGroups());
		System.out.println(selectedCategory.getTitle());
		
		ArrayList<Group> groups = new ArrayList<>(groupManager.getHashMap().values());
		
		VBox vBoxGroups = new VBox();
		for (Group group : groups) {
	        System.out.println(group.getTitle());
	        System.out.println(selectedCategory.getTitle());
	        if (group.getCategory().getTitle().equals(selectedCategory.getTitle())) {
	            FXMLLoader fxmlLoader = new FXMLLoader();
	            fxmlLoader.setLocation(getClass().getResource("GroupItem.fxml"));

	            try {
	                VBox singleGroup = (VBox) fxmlLoader.load(); // Load GroupItem.fxml into a VBox
	                GroupItemController groupController = fxmlLoader.getController();
	                groupController.setData(group);
	                vBoxGroups.getChildren().add(singleGroup); // Add singleGroup to vBoxGroups
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
		sPaneView.setContent(vBoxGroups);
	}
	
	@FXML
	void requestGroup() {
		
	}
	
	void showPosts(Group group) {
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
	
	void showResponses(Post post) {
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