/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VOPFXML;

import Nummerplader.NumberPlates;
import Spillekort.DeckOfCards;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 *
 * @author adooz
 */
public class FXMLDocumentController implements Initializable {
    
    //FXID til nummerplader opgaven.
    @FXML
    private TextField inputTextField;
    @FXML
    private Button checkButton;
    @FXML
    private Label resultLabel;
    
    private NumberPlates numberPlates;
    
    // FXID til kort opgave
    
        @FXML
    private Button shuffleCardsButton;
    @FXML
    private TextArea cardTextArea;
    @FXML
    private RadioButton shuffle50;
    @FXML
    private ToggleGroup shuffleGroup;
    @FXML
    private RadioButton shuffle100;
    @FXML
    private RadioButton shuffle250;

    private DeckOfCards deckOfCards;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        numberPlates = new NumberPlates(); //Initialisere opg 2.
        deckOfCards = new DeckOfCards(); //Initialisere opg 3.
        cardTextArea.setText(deckOfCards.toString());
    }

    @FXML
    private void checkNumberplateHandler(ActionEvent event) {
        String numberPlate = inputTextField.getText();
        resultLabel.setText(numberPlates.validate(numberPlate));
    }    
        @FXML
    private void cardHandler(ActionEvent event) {

        if (shuffle50.isSelected()) {
            deckOfCards.shuffle(50);
        } else if (shuffle100.isSelected()) {
            deckOfCards.shuffle(100);
        } else {
            deckOfCards.shuffle(250);
        }

        cardTextArea.setText(deckOfCards.toString());

    }
    
}
