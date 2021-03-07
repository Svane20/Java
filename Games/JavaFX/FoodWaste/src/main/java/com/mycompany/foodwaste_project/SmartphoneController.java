package com.mycompany.foodwaste_project;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.Window;

public class SmartphoneController {

    @FXML
    private Button smsButton;
    @FXML
    private Button exitButton;
    @FXML
    private BorderPane stageBorderPane;
   

    @FXML
    private void onActionSMS(ActionEvent event) throws IOException {
       Parent smartphoneparent = FXMLLoader.load(getClass().getResource("SmartphoneSMS.fxml"));
       Scene smartphoneScene = new Scene(smartphoneparent);
       Stage spStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       spStage.setScene(smartphoneScene);
       spStage.show();
    } 

    @FXML
    private void onActionExit(ActionEvent event) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }
    
}
