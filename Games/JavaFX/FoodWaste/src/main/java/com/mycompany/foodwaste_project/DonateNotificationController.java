/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.foodwaste_project;

import com.mycompany.foodwaste_project.domain.Game;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
/**
 * FXML Controller class
 *
 * @author sebas
 */
public class DonateNotificationController implements Initializable {

    Game g1 = Game.getInstance();
    
    @FXML
    private Label labelMessage;
    @FXML
    private Button closeButton;
    @FXML
    private Label labelTitel;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        if(g1.checkTimeIsZero() )
        {
            labelTitel.setText("Sleep alert");
            labelMessage.setText("You are too tired to keep going, use sleep to continue to the next day. It is better to sleep in your bedroom."); 
        }
        else
        {
            labelTitel.setText("Locked alert");
            labelMessage.setText("The door is locked, find a key to open the door. Check your phone for extra information."); 
        }
    }    
 
    
    
    public void makeNotification() throws IOException
    {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DonateNotification.fxml"));
        Parent parent = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(parent, 800, 400));
        stage.show();
    }
    
    @FXML
    private void closeApp(ActionEvent event) {
        
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

}
