package com.mycompany.foodwaste_project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import com.mycompany.foodwaste_project.AlertBox;

public class IntroController implements Initializable {

    @FXML
    private Button yes;
    @FXML
    private Button no;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    @FXML
    private void ifYes(ActionEvent event) throws IOException {
        App.setRoot("Intro2");
    }

    @FXML
    private void ifNo(ActionEvent event) {
        no.setOnAction(e -> AlertBox.display("Alert!", "Are you sure you want to leave?"));
    }

}
