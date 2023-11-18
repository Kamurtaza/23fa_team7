package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

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

    }

}
