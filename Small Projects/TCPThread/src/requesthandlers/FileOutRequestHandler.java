/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package requesthandlers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author adooz
 */
public class FileOutRequestHandler extends AbstractRequestHandler {
    
    private File outFile;

    public FileOutRequestHandler(Socket socket, String fileName) {
        super(socket);
        this.outFile = new File(fileName);
    }

    @Override
    public void run() {
        System.out.println("RequestHandler running");
        try (Scanner scanner = new Scanner(socket.getInputStream());
                PrintWriter writeToFile = new PrintWriter(new FileWriter(outFile, true), true);
                PrintWriter writeToClient = new PrintWriter(socket.getOutputStream(), true)) {
            writeToClient.println("Server ready. Type your message: ");
            while (scanner.hasNextLine()) {
                String gotString = scanner.nextLine();
                writeToFile.println(new Date() + "\t" + socket.getInetAddress()
                + ":" + socket.getPort() + "\t" + gotString);
                
                writeToClient.println(gotString + " written to log!");
            }
            
        } catch (IOException ex) {
            Logger.getLogger(FileOutRequestHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("RequestHandler closing ");  
    }
}
