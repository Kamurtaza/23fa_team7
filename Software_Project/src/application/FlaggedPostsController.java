package application;

import javafx.fxml.Initializable;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class FlaggedPostsController implements Initializable {
    Persistence p = new Persistence();
    UserManager uM = p.getUserManager();
    PostManager pM = p.getPostManager();
    User currentUser = uM.getActiveUser();
    @FXML
    private BorderPane borderView;

    @FXML
    private VBox flaggedPostsBox; // VBox from FXML file

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        displayFlaggedPosts();
    }

    // Method to display flagged posts in the flaggedPostsBox
    private void displayFlaggedPosts() {
    	HashMap<String, Post> flaggedPosts = pM.getFlaggedPosts();
        for (Post post : flaggedPosts.values()) {
            String title = post.getTitle();
            String text = post.getText();
            
            Label titleLabel = new Label("Title: " + title);
            Label textLabel = new Label("Text: " + text);
            Button removeFlagButton = new Button("Remove Flag");

            removeFlagButton.setOnAction(e -> {
            	pM.removeFlag(post);
				p.updatePostToJSON(post);
				flaggedPostsBox.getChildren().removeAll(titleLabel, textLabel, removeFlagButton);
            });

            flaggedPostsBox.getChildren().addAll(titleLabel, textLabel, removeFlagButton);
        }
		borderView.getChildren().clear();
		
		BorderPane.setTopAnchor(flaggedPostsBox, 0.0);
        AnchorPane.setBottomAnchor(flaggedPostsBox, 0.0);
        AnchorPane.setLeftAnchor(flaggedPostsBox, 0.0);
        AnchorPane.setRightAnchor(flaggedPostsBox, 0.0);
        
        mainView.getChildren().add(flaggedPostsBox);
    }

    // Other methods and functionalities related to handling flagged posts
}
