/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saviich_10_9;

import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author adooz
 */
public class SpeciesClient {
        public static void main(String[] args) {

        try (Socket clientSocket = new Socket("localhost", 3333);
                Scanner inputStream = new Scanner(clientSocket.getInputStream());
                ObjectOutputStream outputStream = new ObjectOutputStream(clientSocket.getOutputStream())) {

            // Start massage from server:
            System.out.println(inputStream.nextLine());
            // Read a line from the keyboard:
            outputStream.writeObject(new Species("Human", 7700000, 1.09));

            // Read answer from the server and output it to the screen
        } catch (Exception e) {
            // If any exception occurs, display it
            System.err.println("Error " + e);

            // TODO code application logic here
        }
    }
}
