/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg02eksamencamelwriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author erso
 */
public class CamelWriter {

    private File inFile;

    public CamelWriter(String fName) {
        //Initialiser inFile med fName
        inFile = new File(fName);
    }

    public void readLines() {
        // Benyt en Scanner til at læse inFile én linje ad gangen
        // Kald convert2camel med hver linje.

        try (Scanner sc = new Scanner(inFile, "UTF-8")) {

            String line;
            //makes a line String variable
            while (sc.hasNext()) {
                line = sc.next();
                convert2camel(line);
                //while the scanner has a next line, store that next line in line variable.
                //convert that line stored in line, with convert2camel.
                //while loops keeps going untill no more lines.
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    private void convert2camel(String line) {
        // Split line til et String[] af de enkelte ord i linjen
        // Konverter 1. ord til små og resten til stort begyndelsesbogstav
        // Sammensæt ordene til ét langt ord og udskriv.
        String[] words = line.split("[ ']");
        String camelLine = words[0].toLowerCase();
        for (int i = 1; i < words.length; i++) {
            camelLine += words[i].substring(0, 1).toUpperCase()
                    + words[i].substring(1).toLowerCase();  
        }
    }
    
    private void printToFile(String line) {
        File f = new File("Camel Output.txt");
        try (FileWriter fw = new FileWriter(f, true)) {
            fw.append(line);
            fw.append("\n");
            
        } catch (IOException ex) {
            Logger.getLogger(CamelWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CamelWriter cw = new CamelWriter("DryLips.txt");
        cw.readLines();
        System.out.println("\n**************\n");
        cw = new CamelWriter("DryLips.txt");
        cw.readLines();
        System.out.println("\n**************\n");
        cw = new CamelWriter("MaryAnn.txt");
        cw.readLines();
    }

}
