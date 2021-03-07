package com.mycompany.foodwaste_project;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.mycompany.foodwaste_project.domain.Game;
import com.mycompany.foodwaste_project.domain.Item;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Cavra
 */
public class RoomInventoryController implements Initializable {

    Game g1 = Game.getInstance();
    @FXML
    private Button closeButton;
    @FXML
    private ChoiceBox<Item> cbItems = new ChoiceBox<>();
    @FXML
    private Label messageLabel;
    @FXML
    private Button pickupButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbItems.getItems().addAll(g1.getRoom().getArray());
    }

    @FXML
    private void closeApp(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void onActionPickupButton(ActionEvent event) {
        g1.pickUp(cbItems.getValue().toString());
        if (!cbItems.getValue().isBuyable()) {
            messageLabel.setText("You picked up some " + cbItems.getValue().getName());
            return;
        } else {
            messageLabel.setText("Do not try to steal!");
            return;
        }
    }

}
