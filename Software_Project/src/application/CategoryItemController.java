package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CategoryItemController implements Initializable {

	@FXML
	private Label lblCategory;
	
	@FXML
	private HBox hBoxCategory;
	
	@FXML 
	private Button btnNewCategory;
	@FXML
	private TextField newCategoryTextField;
		
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
	
	@FXML
	void createNewCategory(ActionEvent event) {
		Persistence persistence = new Persistence();
		persistence.loadData();
		CategoryManager categoryManager = persistence.getCategoryManager();
		
		String newCategoryName = newCategoryTextField.getText().trim();
		if(!newCategoryName.isEmpty()) {
			Category newCategory = new Category(newCategoryName);
			categoryManager.addCategory(newCategory);
			persistence.saveData();
			newCategoryTextField.clear();
		}
	}
	
//	private void refreshCategoriesView() {
//		ArrayList<Category> updatedCategories = new ArrayList<>(categoryManager.getHashMap().values());
//		VBox vBoxCategories = new VBox();
//		for (Category category : updatedCategories) {
//			FXMLLoader fxmlLoader = new FXMLLoader();
//			fxmlLoader.setLocation(getClass().getResource("CategoryItem.fxml"));
//			
//			try {
//				VBox vBox = fxmlLoader.load();
//				CategoryItemController categoryController = fxmlLoader.getController();
//				categoryController.setData(category);
//				vBoxCategories.getChildren().add(vBox);
//			}
//			catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
}