package com.mycompany.foodwaste_project;

import com.mycompany.foodwaste_project.domain.Game;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.util.Scanner;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class StartmenuController implements Initializable {
    Game g1 = Game.getInstance();
    
    @FXML
    public TextField name;
    @FXML
    private Button begin;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    @FXML
    private void setName(ActionEvent event) {
         
         
    }

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        g1.setName(name.getText());
        App.setRoot("Intro");
        
        
    }

}
