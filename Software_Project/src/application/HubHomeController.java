package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
    	ArrayList<Category> filteredCategories = new ArrayList<Category>();
    	String searchText = txtFieldSearch.getText().trim().toLowerCase();
    	persistence.loadData();
    	categoryManager = persistence.getCategoryManager();
    	ArrayList<Category> allCategories = new ArrayList<Category>(categoryManager.getHashMap().values());
    	for (Category category : allCategories) {
    		String categoryTitle = category.getTitle().toLowerCase();
    		if(categoryTitle.contains(searchText)) {
				filteredCategories.add(category);
    		}
    	}
    	displayFilteredCategories(filteredCategories);
    }
    
    private void displayFilteredCategories(ArrayList<Category> filteredCategories) {
		VBox vBoxFilteredCategories = new VBox();
		for (Category category : filteredCategories) {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("CategoryItem.fxml"));
			
			try {
				VBox vBox = fxmlLoader.load();
				CategoryItemController categoryController = fxmlLoader.getController();
				categoryController.setData(category);
				vBoxFilteredCategories.getChildren().add(vBox);
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		sPaneView.setContent(vBoxFilteredCategories);
	}
    
    void createNewCategory(String name) {
		Persistence persistence = new Persistence();
		persistence.loadData();
		CategoryManager categoryManager = persistence.getCategoryManager();
		
		String newCategoryName = name.trim();
		if(!newCategoryName.isEmpty()) {
			Category newCategory = new Category(newCategoryName);
			categoryManager.addCategory(newCategory);
			persistence.saveData();
			sPaneView.setContent(null);
			refreshContent();
		}
	}
    
    @FXML
    void sortAlpha(MouseEvent event) {
    	System.out.println("We are now begining to compare");
    	persistence.loadData();
    	categoryManager = persistence.getCategoryManager();
    	ArrayList<Category> allCategories = new ArrayList<Category>(categoryManager.getHashMap().values());
    	ObjectComparator objectComparator = new ObjectComparator();
    	Collections.sort(allCategories, objectComparator);
    	
    	displaySortedCategories(allCategories);
    }

    private void displaySortedCategories(ArrayList<Category> sortedCategories) {
		VBox vBoxSortedCategories = new VBox();
		for (Category category: sortedCategories) {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("CategoryItem.fxml"));
			
			try {
				VBox vBox = fxmlLoader.load();
				CategoryItemController categoryController = fxmlLoader.getController();
				categoryController.setData(category);
				vBoxSortedCategories.getChildren().add(vBox);
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		sPaneView.setContent(vBoxSortedCategories);
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
		
		ArrayList<Group> groups = new ArrayList<>(groupManager.getHashMap().values());
		
		VBox vBoxGroups = new VBox();
		for (Group group : groups) {
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

	public void refreshContent() {
		persistence.loadData();
		CategoryManager categoryManager = persistence.getCategoryManager();
		ArrayList<Category> categories = new ArrayList<>(categoryManager.getHashMap().values());
		displayNewCategories(categories);
	}
	 private void displayNewCategories(ArrayList<Category> newCategories) {
			VBox vBoxNewCategories = new VBox();
			for (Category category: newCategories) {
				FXMLLoader fxmlLoader = new FXMLLoader();
				fxmlLoader.setLocation(getClass().getResource("CategoryItem.fxml"));
				
				try {
					VBox vBox = fxmlLoader.load();
					CategoryItemController categoryController = fxmlLoader.getController();
					categoryController.setData(category);
					vBoxNewCategories.getChildren().add(vBox);
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
			sPaneView.setContent(vBoxNewCategories);
		}
	
}