package bigcities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Udleveret kodeskelet til eksamen VOP F19 opg 3c
 *
 * @author erso
 */
public class BigCities {

    private Map<String, Set<CityItem>> countryMap;

    public BigCities(String fileName) {
        countryMap = new TreeMap<>();
        readFile(fileName);
    }

    private void readFile(String fileName) {
        // Opg 3c implementeres her.
        String line = null;
        try {
            FileReader fileReader = new FileReader(fileName);

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String previousCountry = "";
            Set<CityItem> sci = new TreeSet<>();

            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split(";");
                if (values[2].equals(previousCountry)) {
                    sci.add(new CityItem(values[1], values[3], values[0]));
                } else {
                    previousCountry = values[2];
                    sci = new TreeSet<>();
                    countryMap.put(values[2], sci);
                    sci.add(new CityItem(values[1], values[3], values[0]));
                }
            }

            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BigCities.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BigCities.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String toString() {
        return countryMap.toString();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        //Vaelg ANSI eller UTF8 afhaengig af hvad der virker bedst paa din computer:
        BigCities bc = new BigCities("EuroCities ANSI.txt");
//        BigCities bc = new BigCities("EuroCities UTF8.txt");
        System.out.println(bc);
    }

}
