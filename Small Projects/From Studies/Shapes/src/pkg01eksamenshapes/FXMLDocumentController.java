package pkg01eksamenshapes;

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
import opg4_polymorphism.ShapeFacade;

public class FXMLDocumentController implements Initializable {

    @FXML
    private RadioButton ellipseRadioButton;

    @FXML
    private RadioButton rectangleRadioButton;

    @FXML
    private RadioButton circleRadioButton;

    @FXML
    private RadioButton squareRadioButton;

    @FXML
    private TextField parameter1Field;

    @FXML
    private TextField parameter2Field;

    @FXML
    private Button getInfoButton;

    @FXML
    private TextArea shapeInfoArea;

    @FXML
    private ToggleGroup shapeToggleGroup;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ellipseRadioButton.setUserData(ShapeFacade.SHAPES.ELLIPSE);
        rectangleRadioButton.setUserData(ShapeFacade.SHAPES.RECTANGLE);
        circleRadioButton.setUserData(ShapeFacade.SHAPES.CIRCLE);
        squareRadioButton.setUserData(ShapeFacade.SHAPES.SQUARE);
    }

    @FXML
    private void handleRadioButton(ActionEvent event) {
        if (ellipseRadioButton.isSelected() || rectangleRadioButton.isSelected()) {
            parameter2Field.setVisible(true);
        } else if (circleRadioButton.isSelected() || squareRadioButton.isSelected()) {
            parameter2Field.setVisible(false);
        }
    }

    @FXML
    private void handleGetInfoButton(ActionEvent event) {

        double p1 = Double.valueOf(parameter1Field.getText());
        String result = "";

        ShapeFacade.SHAPES shape = (ShapeFacade.SHAPES) shapeToggleGroup.getSelectedToggle().getUserData();

        if (shape == ShapeFacade.SHAPES.ELLIPSE || shape == ShapeFacade.SHAPES.RECTANGLE) {
            double p2 = Double.valueOf(parameter2Field.getText());
            result = ShapeFacade.getInstance().getShapeInfo(shape, new double[]{p1, p2});
            
        } else if (shape == ShapeFacade.SHAPES.CIRCLE || shape == ShapeFacade.SHAPES.SQUARE) {
            result = ShapeFacade.getInstance().getShapeInfo(shape, new double[]{p1});

        }
        
        shapeInfoArea.setText(result);

    }
}
