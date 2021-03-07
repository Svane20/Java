package reeksamen3;

import java.net.URL;
import java.util.List;
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
import opg1_facade.SpecialNumbers;
import opg2_polymorphi.CheckerInterface;
import opg2_polymorphi.EvenChecker;
import opg2_polymorphi.NumberCheckerFacade;
import opg2_polymorphi.SquareChecker;
import opg2_polymorphi.PrimeChecker;

/**
 *
 * @author erso
 */
public class FXMLDocumentController implements Initializable
{

    //Opg 1 stuff:

    @FXML
    private TextField numberField;
    @FXML
    private TextField resultField;
    @FXML
    private Button isEvenButton;
    @FXML
    private Button isPrimeButton;
    @FXML
    private Button isPowerOf2Button;

    private SpecialNumbers specialNumberFacade;
    
    
    // Opg 2 stuff:
    @FXML
    private TextField minNumField;
    @FXML
    private TextField maxNumField;
    @FXML
    private ToggleGroup numbersGroup;
    @FXML
    private RadioButton evenRadio;
    @FXML
    private RadioButton primeRadio;
    @FXML
    private TextArea checkNumbersArea;
    @FXML
    private RadioButton power2Radio;
    @FXML
    private Button clearNumbersButton;
    
    private NumberCheckerFacade numChecker;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        specialNumberFacade = new SpecialNumbers();
        
        numChecker = new NumberCheckerFacade();
    }

    @FXML
    private void isEvenHandler(ActionEvent event)
    {
        int x = new Integer(numberField.getText());
        if (specialNumberFacade.isEven(x))
        {
            resultField.setText(x + " er et lige tal");
        } else
        {
            resultField.setText(x + " er et ulige tal");
        }
    }

    @FXML
    private void isPrimeHandler(ActionEvent event)
    {
        int x = new Integer(numberField.getText());
        if (specialNumberFacade.isPrime(x))
        {
            resultField.setText(x + " er et primtal");
        } else
        {
            resultField.setText(x + " er ikke et primtal");

        }

    }

    @FXML
    private void isPowerOf2Handler(ActionEvent event)
    {
        int x = new Integer(numberField.getText());
        if (specialNumberFacade.isSquare(x))
        {
            resultField.setText(x + " er en potens af 2");
        } else
        {
            resultField.setText(x + " er ikke en potens af 2");

        }
    }

    @FXML
    private void handleCheckNumbers(ActionEvent event)
    {
        int min = new Integer(minNumField.getText());
        int max = new Integer(maxNumField.getText());
        String check;

        CheckerInterface checker = null;
        if (evenRadio.isSelected())
        {
            checker = new EvenChecker();
            check = "Lige tal: ";
        } else if (primeRadio.isSelected())
        {
            checker = new PrimeChecker();
            check = "Primtal: ";
        } else
        {
            checker = new SquareChecker();
            check = "Potenser af 2: ";
        }

        List<?> numberList = numChecker.checkNumbers(min, max, checker);
        checkNumbersArea.appendText(numberList.toString() + "\n");
        checkNumbersArea.appendText(check + numberList.size() + "\n");
    }

    @FXML
    private void handleClearNumbers(ActionEvent event)
    {
        minNumField.clear();
        maxNumField.clear();
        checkNumbersArea.clear();
    }

}
