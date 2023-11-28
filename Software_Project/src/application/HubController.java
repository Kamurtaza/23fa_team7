package application;

import java.util.HashMap;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class HubController {

    @FXML
    private Button HubBanned;

    @FXML
    private Button HubFlaggedPosts;

    @FXML
    private Button HubFlaggedResponses;

    @FXML
    private Button HubPostHistory;

    @FXML
    private Button HubResponseHistory;

    @FXML
    private Button HubSuspended;

    @FXML
    private Button HubUsers;

    @FXML
    private AnchorPane mainView;

    @FXML
    void handleChangeView(ActionEvent event) {
    	Persistence p = new Persistence();
		p.loadData();
		PostManager pM = p.getPostManager();
		
    	if(event.getSource() instanceof Button) {
    		
    		Button clickedButton = (Button) event.getSource();
    		System.out.println(clickedButton.getId());
    		switch (clickedButton.getId()) {
    		
    		case"HubPostHistory":
    			if (pM != null) {
    				HashMap<String,Post> allPosts = pM.getAllPosts();
    				
    				VBox allPostsBox = new VBox();
    				allPostsBox.setSpacing(10);
    				
    				for (Post post : allPosts.values()) {
    					String title = post.getTitle();
    					String text = post.getText();
    				
    				Label titleLabel = new Label("Title: " + title);
    				Label textLabel = new Label("Text: " + text);
    				Button addFlagButton = new Button("Flag Post");
    				
    				addFlagButton.setOnAction(e -> {
    					pM.flagPost(post);
    					p.updatePostToJSON(post);
    				});
    				
    				VBox postBox = new VBox(titleLabel, textLabel, addFlagButton);
    				postBox.setSpacing(5);
    				allPostsBox.getChildren().add(postBox);
    				}
    				mainView.getChildren().clear();
    				mainView.getChildren().add(allPostsBox);	
    			}
    			break;
    			
    		
    		case "HubFlaggedPosts":
    			System.out.println("We are in case Hub Flagged Posts");
    			if (pM != null) {
    				System.out.println("pM not null");
    				HashMap<String, Post> flaggedPosts = pM.getFlaggedPosts();
    				System.out.println(flaggedPosts.values());
    				    				
    				VBox flaggedPostsBox = new VBox();
    				flaggedPostsBox.setSpacing(10);
    				
    				for(Post post : flaggedPosts.values()) {
    					String title = post.getTitle();
    					String text = post.getText();
    					
    					Label titleLabel = new Label("Title: " + title);
    					Label textLabel = new Label("Text: " + text);
    					Button removeFlagButton = new Button("Remove Flag");
    					
    					removeFlagButton.setOnAction(e ->{
    						pM.removeFlag(post);
    						p.updatePostToJSON(post);
    						flaggedPostsBox.getChildren().removeAll(titleLabel, textLabel, removeFlagButton);
    					});
    					
    					flaggedPostsBox.getChildren().addAll(titleLabel, textLabel, removeFlagButton);
    				}
    				mainView.getChildren().clear();
    				
    				AnchorPane.setTopAnchor(flaggedPostsBox, 0.0);
                    AnchorPane.setBottomAnchor(flaggedPostsBox, 0.0);
                    AnchorPane.setLeftAnchor(flaggedPostsBox, 0.0);
                    AnchorPane.setRightAnchor(flaggedPostsBox, 0.0);
                    
                    mainView.getChildren().add(flaggedPostsBox);
    			}
    			break;
    		}
    	}
    }

}
