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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
/**
 * FXML Controller class
 *
 * @author Cavra
 */
public class SmartphoneSMSController implements Initializable {

    Game g1 = Game.getInstance();
    
    @FXML
    private Button backButton;
    @FXML
    private Label labelQuest;
    @FXML
    private AnchorPane smsAnchorpane;
    @FXML
    private Label questDescription;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        labelQuest.setText("1");
        questDescription.setText(String.valueOf(g1.getQuestDescription()));
    }    
    
    @FXML
    private void onActionBack(ActionEvent event) throws IOException {
       Parent smartphoneSMSparent = FXMLLoader.load(getClass().getResource("Smartphone.fxml"));
       Scene smartphoneSMSScene = new Scene(smartphoneSMSparent);
       Stage stage = new Stage();
       stage.initModality(Modality.WINDOW_MODAL);
       stage.setResizable(false);
       Stage spSMSStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       spSMSStage.setScene(smartphoneSMSScene);
       spSMSStage.show();
    }

}
