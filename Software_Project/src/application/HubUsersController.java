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

public class HubUsersController implements Initializable {
	
	private Persistence persistence = new Persistence();
	private UserManager userManager = new UserManager();
	
	@FXML
    private VBox bannedDashboard;

    @FXML
    private ImageView imgSearch;

    @FXML
    private ImageView imgSortAlpha;

    @FXML
    private ImageView imgSortBans;

    @FXML
    private ScrollPane sPaneView;

    @FXML
    private TextField txtFieldSearch;

    @FXML
    void searchUsers(MouseEvent event) {

    }

    @FXML
    void sortAlpha(MouseEvent event) {

    }

    @FXML
    void sortBans(MouseEvent event) {

    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	persistence.loadData();
    	userManager = persistence.getUserManager();
    	VBox vBoxUsers = new VBox();
    	
    	ArrayList<User> users = new ArrayList<>(userManager.getHashMap().values());
    	for (User user : users) {
    		FXMLLoader fxmlLoader = new FXMLLoader();
    		fxmlLoader.setLocation(getClass().getResource("UserItem.fxml"));
    		
    		try {
    			VBox vBox = (VBox) fxmlLoader.load();
    			UserItemController userController = fxmlLoader.getController();
    			userController.setData(user);
    			vBoxUsers.getChildren().add(vBox);
    		}
    		catch (IOException e) {
    			e.printStackTrace();
    		}
    	}
    	
    	sPaneView.setContent(vBoxUsers);
    }

}