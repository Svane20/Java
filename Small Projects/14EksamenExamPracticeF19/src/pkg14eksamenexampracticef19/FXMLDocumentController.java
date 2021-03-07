/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import loan.*;


/**
 *
 * @author Malte
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private ImageView imageView;
    @FXML
    private Button buttonStart;
    @FXML
    private Button buttonStop;
    @FXML
    private Slider slider;
    @FXML
    private Label label;

    private Image dogImages[];

    // Task 2C
    @FXML
    private TextField textName;
    @FXML
    private TextField textLoan;
    @FXML
    private TextArea textOutput;
    @FXML
    private ComboBox<Integer> comboTerm;
    @FXML
    private Button buttonApply;
    @FXML
    private RadioButton radioPrivate;
    @FXML
    private RadioButton radioBusiness;





    Thread t1;

    //private Loan loan = new Loan();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File[] imageFiles = new File("./HelgaPics").listFiles();
        dogImages = new Image[imageFiles.length];
        for (int i = 0; i < imageFiles.length; i++) {
            dogImages[i] = new Image(imageFiles[i].toURI().toString());
        }
        imageView.setImage(dogImages[0]);

        comboTerm.getItems().setAll(1,3,5);


    }

    @FXML
    private void handleButtonAnimation(ActionEvent event) {
        if (event.getSource() == buttonStart) {
            double slider2 = slider.getValue();


            AnimationImageView running1 = new AnimationImageView(1,slider2, imageView );
            t1 = new Thread(running1);
            t1.start();
            buttonStart.setDisable(true);

        }
        else if(event.getSource() == buttonStop){
            t1.stop();
            buttonStart.setDisable(false);
        }
    }

        @FXML
        private void handleRadioActionevent (ActionEvent event) {
            String customer = (textName.getText());
            int loanAmount = new Integer(textLoan.getText());
            LoanInterface loan = null;
            int i = 1;

            if (radioBusiness.isSelected()) {
                loan = new BusinessLoan(i, textName.getText(), loanAmount,comboTerm.getValue());
                textOutput.setText(loan.toString());

                i++;
            }
            if (radioPrivate.isSelected()) {
                loan = new PersonalLoan(i, textName.getText(), loanAmount, comboTerm.getValue());
                textOutput.setText(loan.toString());
                i++;
            }
        }





        public class AnimationImageView implements Runnable {
            private int i; //Index of current picture
            private double sleepTime;
            private boolean running;
            private ImageView iw;
            private int count;
            public AnimationImageView(int i, double sleepTime, ImageView iw) {
                this.i = i;
                this.sleepTime = sleepTime;
                this.iw = iw;
            }

            @Override
            public void run() {
                // Code the animation here....
                running = true;
                count = 0;

                System.out.println("Thread started: " + Thread.currentThread());

                while (running) {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {

                            iw.setImage(dogImages[i]);
                            i = (i + 1) % dogImages.length;
                            count++;
                            label.setText("Updates " + count);
                        }
                    });
                    synchronized (this) {
                        try {
                            Thread.sleep((long) sleepTime);
                            wait((long)sleepTime);

                        } catch (InterruptedException ex) {
                            System.out.println("Interrupted: " + Thread.currentThread());
                            running = false;

                        }

                    }
                }
            }

        }
    }



