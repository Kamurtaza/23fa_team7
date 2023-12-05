package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CategoryItemController implements Initializable {

	@FXML
	private Label lblCategory;
	
	@FXML
	private HBox hBoxCategory;
	
	public CategoryItemController() { }
	
	public void setData(Category category) {
		lblCategory.setText(category.getTitle());
	}
	
	@FXML
    void categoryClicked(MouseEvent event) {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("HubHome.fxml"));
		
		try {
			fxmlLoader.load();
			HubHomeController hubController = fxmlLoader.getController();
			Persistence persistence = new Persistence();
			persistence.loadData();
			CategoryManager categoryManager = persistence.getCategoryManager();
						
			hubController.showGroups(categoryManager.getCategory(lblCategory.getText()));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
}