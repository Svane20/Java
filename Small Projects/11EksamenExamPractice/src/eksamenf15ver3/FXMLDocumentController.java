package eksamenf15ver3;

import facade.Facade;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import laundry_facade.LaundryConstants;
import laundry_facade.LaundrySingleton;

/**
 *
 * @author erso
 */
public class FXMLDocumentController implements Initializable
{

    // FXML komponenter til opgave 2: Tjek Facade
    @FXML
    private TextField sizeField;
    @FXML
    private TextField maxField;
    @FXML
    private Button fillArrayButton;
    @FXML
    private TextArea checkFacadeTextArea;
    @FXML
    private TextField divisorTextField;
    @FXML
    private Button sumDivButton;
    @FXML
    private Button fillUniqueButton;

    private Facade facade;

    // FXML komponenter til opgave 3: Vaskeri
    @FXML
    private Button wash6Button;
    @FXML
    private TextField price6wash;
    @FXML
    private Button wash12Button;
    @FXML
    private Button tumbleButton;
    @FXML
    private TextField price12wash;
    @FXML
    private TextField tumblerMinutesField;
    @FXML
    private TextField priceTumbler;

    @FXML
    private ChoiceBox<String> wash6Choice;
    @FXML
    private ChoiceBox<String> wash12Choice;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {

        facade = new Facade();

        LaundrySingleton.getInstance().buildLaundry();
        ObservableList<String> progList = FXCollections.observableArrayList(LaundryConstants.PROGS);
        wash6Choice.setItems(progList);
        wash6Choice.getSelectionModel().select(2);
        wash12Choice.setItems(progList);
        wash12Choice.getSelectionModel().select(2);

    }


    @FXML
    private void checkFacadeHandler(ActionEvent event)
    {
        int size = new Integer(sizeField.getText());
        int max = new Integer(maxField.getText());
        if (event.getSource() == fillArrayButton)
        {
            checkFacadeTextArea.appendText(Arrays.toString(facade.fillArray(size, max)));
        } else if (event.getSource() == fillUniqueButton)
        {
            if (!(size < max))
            {
                checkFacadeTextArea.appendText("size skal være mindre end max!");
            } else
            {
                checkFacadeTextArea.appendText(Arrays.toString(facade.fillUniqueArray(size, max)));
            }
        } else
        {
            int div = new Integer(divisorTextField.getText());
            checkFacadeTextArea.appendText("\tSum af divisor " + div + ":\t" + facade.sumOfDivisors(div));
        }
            checkFacadeTextArea.appendText("\n");
    }

    @FXML
    private void laundryButtonAction(ActionEvent event)
    {
        int machineId;
        int prog;
        if (event.getSource() == wash6Button)
        {
            machineId = 0;
            prog = wash6Choice.getSelectionModel().getSelectedIndex() + 1;

            price6wash.setText(Double.toString(LaundrySingleton.getInstance().getPrice(machineId, prog)));
        } else if (event.getSource() == wash12Button)
        {
            machineId = 1;
            prog = wash12Choice.getSelectionModel().getSelectedIndex() + 1;
            price12wash.setText(Double.toString(LaundrySingleton.getInstance().getPrice(machineId, prog)));
        } else
        {
            machineId = 2;
            try
            {
                prog = new Integer(tumblerMinutesField.getText());
                priceTumbler.setText(Double.toString(LaundrySingleton.getInstance().getPrice(machineId, prog)));
            } catch (Exception e)
            {
                e.printStackTrace();
                priceTumbler.setText("Fejl ved læsning af minutter!");
            }
        }
    }

}
