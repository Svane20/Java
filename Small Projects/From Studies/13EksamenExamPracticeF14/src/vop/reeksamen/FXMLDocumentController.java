/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vop.reeksamen;

import arrays.ArrayTester;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import poly_and_strings.*;
import urban_population.UrbanPopulationStatistics;

/**
 *
 * @author erso
 */
public class FXMLDocumentController implements Initializable {

    // Til opgave 2:
    @FXML
    private Button arraySortButton;
    @FXML
    private RadioButton upperRadio;
    @FXML
    private ToggleGroup polyStringGroup;
    @FXML
    private RadioButton lowerRadio;
    @FXML
    private TextField stringManipInput;
    @FXML
    private RadioButton flipRadio;
    @FXML
    private TextField stringManipOutput;
    
    // Til opg 3
    @FXML
    private TextArea arrayTextArea;
    @FXML
    private Button fillArrayButton;
    @FXML
    private TextField arraySizeField;
    @FXML
    private Button reverseButton;

    private ArrayTester arrayTester;
    
    // Til opg 4
    @FXML
    private Button urbanPopButton;
    @FXML
    private TextArea urbanTextField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    // ActionHandler til opg 2
    @FXML
    private void stringManipHandler(ActionEvent event) {
        StringManipulable manipper = null;
        if (event.getSource() == upperRadio) {
            manipper = new ToUpperManip(stringManipInput.getText());
        } else if (event.getSource() == lowerRadio) {
            manipper = new ToLowerManip(stringManipInput.getText());
        } else if (event.getSource() == flipRadio) {
            manipper = new FlipUpperLowerManip(stringManipInput.getText());
        }
        stringManipOutput.setText(manipper.manip());
    }

    // ActionHandler til opg 3
    @FXML
    private void arrayActionHandler(ActionEvent event) {
        if (event.getSource() == fillArrayButton) {
            arrayTester = new ArrayTester(Integer.parseInt(arraySizeField.getText()));
            arrayTester.fillArray();
            arrayTextArea.appendText("Filled:");
        }

        if (arrayTester == null) {
            arrayTextArea.setText("Array not initialized!");
        } else {
            if (event.getSource() == arraySortButton) {
                arrayTester.sort();
                arrayTextArea.appendText("Sorted:");
            }
            if (event.getSource() == reverseButton) {
                arrayTester.reverse();
                arrayTextArea.appendText("Reversed:");
            }
            arrayTextArea.appendText(arrayTester.toString());

        }

    }

    // ActionHandler til opg 4
    @FXML
    private void urbanPopHandler(ActionEvent event) {
        urbanTextField.setText(new UrbanPopulationStatistics("ByBefolkning.txt").toString());
    }

}
