package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class HubPostHistoryController implements Initializable {

	private Persistence persistence = new Persistence();
	private PostManager postManager = new PostManager();
	
	@FXML
	private VBox suspendedDashboard;
	
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

    public HubPostHistoryController() { }

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
    	persistence.loadData();
    	postManager = persistence.getPostManager();
    	VBox vBoxPosts = new VBox();
    	
    	ArrayList<Post> posts = new ArrayList<>(postManager.getHashMap().values());
    	for (Post post : posts) {
    		FXMLLoader fxmlLoader = new FXMLLoader();
    		fxmlLoader.setLocation(getClass().getResource("PostHistoryItem.fxml"));
    		
    		try {
    			VBox vBox = (VBox) fxmlLoader.load();
    			PostHistoryItemController postController = fxmlLoader.getController();
    			postController.setData(post);
    			vBoxPosts.getChildren().add(vBox);
    		}
    		catch (IOException e) {
    			e.printStackTrace();
    		}
    	}
    	
    	sPaneView.setContent(vBoxPosts);
    }
}