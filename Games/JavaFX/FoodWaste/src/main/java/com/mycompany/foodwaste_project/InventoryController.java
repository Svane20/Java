package com.mycompany.foodwaste_project;

import com.mycompany.foodwaste_project.*;
import com.mycompany.foodwaste_project.domain.Game;
import java.net.URL;
import com.mycompany.foodwaste_project.domain.Item;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
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
 */
public class InventoryController implements Initializable {

    Game g1 = Game.getInstance();
    @FXML
    private Button closeButton;
    @FXML
    private Button donateButton;
    @FXML
    private Button throwoutButton;
    @FXML
    private Button useButton;
    @FXML
    private Button eatButton;
    @FXML
    private Button dropButton;
    @FXML
    private ChoiceBox<Item> cbItems = new ChoiceBox<>();
    @FXML
    private Label messageLabel;
    @FXML
    private Label itemStatus;
    @FXML
    private Button updateButton;
    @FXML
    private Label messageLabel3;
    @FXML
    private Label messageLabel2;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbItems.getItems().addAll(g1.getInventory());
        cbItems.getSelectionModel().select(0);

    }

    @FXML
    private void closeApp(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void donateItem(ActionEvent event) {
        g1.donate(cbItems.getValue().toString());

        if (!cbItems.getValue().isFood()) {

            messageLabel.setText("This is not food!");
        }

        if (cbItems.getValue().getSpoiledStatus()) {

            messageLabel.setText("You can't donate spoiled food.. You should");
            messageLabel2.setText("just throw the spoiled food in the trash.");

        } else {
            messageLabel.setText("Thanks! You just donated some " + cbItems.getValue().getName() + " to the foodbank.");
            messageLabel2.setText("The food will now be used to feed people in need!");
        }

    }

    @FXML
    private void throwoutItem(ActionEvent event) {
        g1.throwout(cbItems.getValue().toString());

        if (!cbItems.getValue().isFood()) {
            messageLabel.setText("You just threw some " + cbItems.getValue().getName() + " out");
            messageLabel2.setText("");
            messageLabel3.setText("");
        }

        if (cbItems.getValue().getSpoiledStatus()) {
            messageLabel.setText("You just lost 10 points, because you threw ");
            messageLabel2.setText("something spoiled in the trash.");
            messageLabel3.setText("");
        } else {
            messageLabel.setText("You just lost 10 points, because you threw");
            messageLabel2.setText("");
            messageLabel3.setText("something ediable in the trash.");
        }

    }

    @FXML
    private void useItem(ActionEvent event) {

        g1.useItem(cbItems.getValue().toString());

    }

    @FXML
    private void eatItem(ActionEvent event) {
        g1.eat(cbItems.getValue().toString());

        if (cbItems.getValue().getSpoiledStatus()) {
            messageLabel.setText("You just ate spoiled food, and lost 10 hp");
            messageLabel2.setText("");
            messageLabel3.setText("");
        } else {
            if ((g1.getHunger() + cbItems.getValue().getNutrition()) >= 100) {
                messageLabel.setText("You just ate a " + cbItems.getValue().getName() + " and refilled your hunger by " + cbItems.getValue().getNutrition());
                messageLabel2.setText("You are now more than full, and wasted ");
                messageLabel3.setText((g1.getHunger() + cbItems.getValue().getNutrition() - 100) + " nutrition");
            } else {
                messageLabel.setText("You just ate a " + cbItems.getValue().getName() + " and refilled your hunger by " + cbItems.getValue().getNutrition());
                messageLabel2.setText("");
                messageLabel3.setText("");
            }
        }
    }

    @FXML
    private void dropItem(ActionEvent event) {
        
        g1.dropItem(cbItems.getValue().toString());
        g1.getInventory().remove(cbItems.getValue());
        
        messageLabel.setText("You dropped some " + cbItems.getValue().getName());
        messageLabel2.setText("");
        messageLabel3.setText("");
        return;
    }

    @FXML
    private void onActionUpdateButton(ActionEvent event) {
        itemStatus.setText("There is: " + cbItems.getValue().getHoursToRot() + " hours before the item is rotten.");

        if (cbItems.getValue().getSpoiledStatus() == true) {
            itemStatus.setText(cbItems.getValue().getName() + " is spoiled!");
        }
    }

}
