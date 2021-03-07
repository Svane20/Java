/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vop.reeksamen.f18.solutions;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import population.TownStatistics;

/**
 *
 * @author erso
 */
public class FXMLDocumentController implements Initializable {

    // Til opgave 1:
    
    @FXML
    private TextField scrollField;
    @FXML
    private Button startScrollButton;
    @FXML
    private Button stopScrollButton;
    @FXML
    private RadioButton charRadioButton;
    @FXML
    private ToggleGroup scrollGroup;
    @FXML
    private RadioButton wordRadioButton;
    @FXML
    private Label scrollUpdatesLabel;

    private Thread thread;
    private long waitTime;
    private int scrollUpdates;
    
//private ScrollInterface scroller;

    // Til opgave 2:
    @FXML
    private Button readPopulationFileButton;
    @FXML
    private Button sortButton;
    @FXML
    private Button clearPopulation;
    @FXML
    private TextArea populationTextArea;
    
    private TownStatistics townStat;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        waitTime = 200;   // Opg 1
        townStat = new TownStatistics(); // Opg 2
    }

    @FXML
    private void scrollHandler(ActionEvent event) {
        if (event.getSource() == startScrollButton) {
            scrollUpdates = 0;
            Runnable runner = charRadioButton.isSelected()
                    ? new  CharacterScroller()
                    : new WordScroller();
            
    
            thread = new Thread(runner);
            thread.setDaemon(true);
            thread.start();
        } else if (event.getSource() == stopScrollButton) {
            thread.interrupt();
        }

    }
    
    private class CharacterScroller implements Runnable {

        @Override
        public void run() {
            try {
                while (!Thread.interrupted()) {
                    scrollUpdates++;
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            scrollField.setText(scrollField.getText()
                                    .substring(1, scrollField.getText().length())
                                    + scrollField.getText().charAt(0));
                            scrollUpdatesLabel.setText("Updates: " + scrollUpdates);
                        }
                    });
                    Thread.sleep(waitTime);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private class WordScroller implements Runnable {

        @Override
        public void run() {
            try {
                while (!Thread.interrupted()) {
                    String[] words = scrollField.getText().split(" ");
                    scrollField.clear();
                    scrollUpdates++;
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            for (int i = 1; i < words.length; i++) {
                                scrollField.appendText(words[i]);
                                scrollField.appendText(" ");
                            }
                            scrollField.appendText(words[0] + " ");

                            scrollUpdatesLabel.setText("Updates: " + scrollUpdates);
                        }
                    });

                    Thread.sleep(waitTime);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }


    // Opgave 2:
    @FXML
    private void populationHandler(ActionEvent event) {
        if (event.getSource() == readPopulationFileButton) {
            townStat.readFile("Danske Byer.txt");
            populationTextArea.setText(townStat.toString());

        } else if (event.getSource() == clearPopulation) {
            populationTextArea.setText(null);
        } else if (event.getSource() == sortButton) {
            townStat.sort();
            populationTextArea.appendText(townStat.toString());
        }
    }
}
