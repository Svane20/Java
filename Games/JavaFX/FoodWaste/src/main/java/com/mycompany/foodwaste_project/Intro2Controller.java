package com.mycompany.foodwaste_project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class Intro2Controller implements Initializable {


    @FXML
    private Button Next;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    @FXML
    private void startGame(ActionEvent event) throws IOException {
        App.setRoot("intro3");
    }

}
