
package com.mycompany.foodwaste_project;

import com.mycompany.foodwaste_project.domain.Game;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class SleepController implements Initializable {
    
    Game g1 = Game.getInstance();
    
    @FXML
    private Button closeButton;
    @FXML
    private Label labelDay;
    @FXML
    private Label labelMessage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        g1.sleep(); 
        
        labelDay.setText(String.valueOf(g1.getDay()));
        labelMessage.setText(String.valueOf(g1.getEventMessage()));
        
    }    

    @FXML
    private void closeApp(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
    
    
    
}
