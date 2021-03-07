/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package urban_population;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author erso
 */
public class UrbanPopulationStatistics {
    private Set<UrbanPopulation> popSet;
    private File file;
    
    public UrbanPopulationStatistics(String fileName){
        this.popSet = new TreeSet<>();
        file = new File(fileName);
        readFile();
    }
    

    @Override
    public String toString() {
        String s = popSet.toString().replaceAll(", ", "");
        return "UrbanPopulationStatistics:\n"  + s.substring(1, s.length()-1) +"\n";
    }
    
    private void readFile(){
        Scanner scan = null;
        try {
            scan = new Scanner(file);
            String line;
            String[] split;
            UrbanPopulation urbanPopulation;
            while (scan.hasNextLine()) {
                line = scan.nextLine();
                System.out.println(line);
                split = line.split("/");
                urbanPopulation = new UrbanPopulation(split[0], 
                        Integer.parseInt(split[1]), 
                        Integer.parseInt(split[4]));
                popSet.add(urbanPopulation);

            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        scan.close();
        

           
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UrbanPopulationStatistics stats = new UrbanPopulationStatistics("ByBefolkning.txt");
        System.out.println(stats);
    }
    
}
