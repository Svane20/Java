package pkg02eksamensearch.replace;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

public class FXMLDocumentController implements Initializable {

    @FXML
    private Label searchLabel;

    @FXML
    private Label replaceLabel;

    @FXML
    private TextField searchTextField;

    @FXML
    private TextField replaceTextField;

    @FXML
    private Button replaceAllButton;

    @FXML
    private Button openFileButton;

    @FXML
    private Button saveAsButton;

    @FXML
    private TextArea textArea;

    private FileChooser fileChooser;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("."));
    }

    @FXML
    private void handleReplaceAllButton(ActionEvent event) {
        textArea.setText(textArea.getText().replaceAll(
                searchTextField.getText(),
                replaceTextField.getText()));
    }

    @FXML
    private void handleOpenFileButton(ActionEvent event) {
        textArea.clear();
        File inFile = fileChooser.showOpenDialog(null);
        textArea.setText(readFile(inFile));
    }

    @FXML
    private void handleSaveAsButton(ActionEvent event) {
        File outFile = fileChooser.showSaveDialog(null);

        writeFile(textArea.getText(), outFile);
    }

    private String readFile(File inFile) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = null;

        try {
            sc = new Scanner(inFile);
            while (sc.hasNext()) {
                sb.append(sc.nextLine() + "\n");
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            sc.close();
        }
        return sb.toString();
    }

    private void writeFile(String text, File outFile) {
        try (FileWriter fw = new FileWriter(outFile)) {
            fw.write(text);
            fw.flush();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
