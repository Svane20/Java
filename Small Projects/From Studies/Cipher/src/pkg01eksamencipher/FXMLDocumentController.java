/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg01eksamencipher;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;

/**
 *
 * @author maimartinsen
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField inputField;
    
    @FXML
    private TextField encryptedField;
    
    @FXML
    private TextField decryptedField;
    
    @FXML 
    private TextField ceasarText;
    
    @FXML
    private Button encryptButton;
    
    @FXML
    private Button decryptButton;
    
    @FXML
    private RadioButton atbashRadioButton;
    
    @FXML
    private RadioButton ceasarRadioButton;
    
    @FXML 
    private Spinner<Integer> ceasarSpinner;
    
    CipherInterface crypter;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ceasarSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(
                0, CipherInterface.ALPHABETH.length - 1, CipherInterface.ALPHABETH.length / 2));
    }    
    
    @FXML private void cryptHandler(ActionEvent event) {
        Object source = event.getSource();
        //Henter ID af de forskellige ting
        
        if (atbashRadioButton.isSelected()) {
            crypter = new AtbashCipher();
        } else if (ceasarRadioButton.isSelected()) {
            int keyValue = ceasarSpinner.isVisible() ? ceasarSpinner.getValue() : new Integer(ceasarText.getText());
            crypter = new CeasarCipher(keyValue); 
        }
        
        if (source == encryptButton) {
            encryptedField.setText(crypter.encrypt(inputField.getText()));
        } else if (source == decryptButton) {
            decryptedField.setText(crypter.decrypt(encryptedField.getText()));
        }
    }
    
}
