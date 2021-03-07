package com.mycompany.foodwaste_project;

import com.mycompany.foodwaste_project.domain.Game;
import com.mycompany.foodwaste_project.domain.Item;
import com.mycompany.foodwaste_project.domain.monetarySystem;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
/**
 * FXML Controller class
 *
 * @author Cavra
 */
public class OrderTableController implements Initializable {

    Game g1 = Game.getInstance();

    @FXML
    private ChoiceBox<Item> cbItems = new ChoiceBox<>();
    
    @FXML
    private Label labelBalance;
    @FXML
    private Label labelHealth;
    @FXML
    private Label labelHunger;
    @FXML
    private Button buyButton;
    @FXML
    private Label labelPrice;
    @FXML
    private Label labelnoMoney;
    @FXML
    private Button updateButton;
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        labelHealth.setText(String.valueOf(g1.getHealth()));
        labelHunger.setText(String.valueOf(g1.getHunger()));
        labelBalance.setText(String.valueOf(g1.getMoney()));

        System.out.println(String.valueOf(g1.getRoom().getArray()));
        
        cbItems.getItems().addAll(g1.getRoom().getArray());
        
        //System.out.println(cbItems.getItems().addAll( g1.supermarkedItems() ));

        //cbItems.getSelectionModel().selectedItemProperty().addListener( e -> System.out.println(g1.getPrice()));
        cbItems.getSelectionModel().select(0); //.addListener( e -> labelPrice.setText(String.valueOf(g1.getRoom().getArray().get(1).getPrice())));

        
    }   
    
  

    @FXML
    private void onActionBuyButton(ActionEvent event) {
        
        
        
        if(g1.getMoney() < cbItems.getValue().getPrice()) {
            labelnoMoney.setText("You do not have enough money.");
            return;
        }
        if (!cbItems.getValue().isBuyable()) {
               labelnoMoney.setText("The item is not for sale");
            return;
        }
        
        if(g1.getMoney() > cbItems.getValue().getPrice()) {
            labelnoMoney.setText("Bought.");
            cbItems.getValue().setBuyable(false);
            g1.Buy(cbItems.getValue().getPrice());
            g1.getRoom().getArray().remove(cbItems.getValue());
            g1.getInventory().add(cbItems.getValue());
            System.out.println(String.valueOf(g1.getInventory()));
            
            return;
        }
        
    }

    @FXML
    private void onActionUpdateButton(ActionEvent event) {
        labelPrice.setText(String.valueOf(cbItems.getValue().getPrice()));
        labelBalance.setText(String.valueOf(g1.getMoney()));
    }
    
}
