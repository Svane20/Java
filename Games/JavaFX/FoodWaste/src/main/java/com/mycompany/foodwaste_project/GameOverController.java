/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.foodwaste_project;

import com.mycompany.foodwaste_project.domain.Game;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
/**
 * FXML Controller class
 *
 * @author svane
 */
public class GameOverController implements Initializable {
    Game g1 = Game.getInstance();

    @FXML
    private Label pointLabel;
    @FXML
    private Button quitButton;
    @FXML
    private Label labelFact;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pointLabel.setText("Point:" + g1.getPoint());
        
        String msg = "";
        
        if(g1.getPoint() <= 249)
        {
            msg = "In Denmark, 700,000 tonnes of food are waste or lost each year equating to more than DKK 11 bn annually. The food industry is responsible for 133,000 tonnes of this food waste, with Danish households wasting more than 260,000 tonnes per year";
        } else
        if(g1.getPoint() >= 250 && g1.getPoint() <= 500)
        {
            msg = "Did you know? With each passing day, more and more food is thrown out. When unnecessary food is thrown out, commodities have been wasted that could otherwise be used. According to Miljøstyrelsen, 247,000 tonnes of food were wasted in 2017 in households in Denmark";
        } else
        if(g1.getPoint() >= 501)
        {
            msg = "Several food banks and other nonprofits in Denmark get their supplies through donations from local supermarkets or restaurants. One supermarket in Copenhagen, Wefood, only sells food that would have otherwise been wasted. Typically, this is food that has reached its sell-by date or has not been used up at the end of restaurant business hours. Sometimes, this food consists of perfectly healthy fruits and vegetables that simply appear too misshapen and unattractive to reach market shelves.";
        } 
        
        labelFact.setText(msg);
    }    
    
    @FXML
    private void quitGame(ActionEvent event) {
        quitButton.setOnAction(e -> AlertBox.display("Alert!", "Thanks for playing"));
    }

}
