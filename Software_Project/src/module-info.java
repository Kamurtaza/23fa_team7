module Software_Project {
	requires javafx.controls;
	requires org.junit.jupiter.api;
	
	opens application to javafx.graphics, javafx.fxml;
}
