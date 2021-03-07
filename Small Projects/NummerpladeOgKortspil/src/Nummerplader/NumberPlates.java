package Nummerplader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * VOP eksamen F2014 
 * Kodeskelet til opgave 2
 *
 * @author erso
 */
public class NumberPlates {

    public static final int LENGTH = 7;         // Noejagtig laengde paa nummerplade
    
    private Map<String, String> districtMap;    // Kendingsbogstaver -> Politikreds
    
    private VehicleType[] vehicleTypes = {      // Intervaller for anvendelse
        new VehicleType("Motorcykel", 10000, 19999),
        new VehicleType("Privat personvogn", 20000, 45999),
        new VehicleType("Udlejningsvogn", 46000, 46999),
        new VehicleType("Hyrevogn", 47000, 48999),
        new VehicleType("Skolevogn", 49000, 49899),
        new VehicleType("Ambulance el. lign.", 49900, 49999),
        new VehicleType("Diverse andre ", 50000, 84999)
    };

    public NumberPlates() {
        // opg 2a) initialiser districtMap
        districtMap = new HashMap<>();
        readFile();
    }

    public void readFile() {
        // opg 2a) Indlaes filen og put i mappen
        Scanner scan = null;
        try {
            File file = new File("Nummerplader.txt");
            scan = new Scanner(file);
            String[] keyVal;
            while (scan.hasNextLine()) {
                keyVal = scan.nextLine().split(":");
                districtMap.put(keyVal[0], keyVal[1]);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            if (scan != null) {
                scan.close();
            }
        }
        System.out.println("Map: " + districtMap);
    }

    public String validate(String plate) {
        // Opg 2b) Tjek nummerpladen og returner anvendelse og politidistrikt
        if (plate.length() != LENGTH) {
            return "Illegal laengde";
        }
        //laver en district, hvor den tager bogstaver fra 0 til 2.
        String district = validateDistrict(plate.substring(0, 2).toUpperCase());
        //laver en muberpart hvor resten af nummerpladen gemmes. Fra plads 2 og frem.
        Integer numberPart = Integer.parseInt(plate.substring(2));
        //laver en vehicleType string hvor numberpart tjekkes med validateVehicleType metoden.
        String vehicleType = validateVehicleType(numberPart);
        //returner typen fra distriktet.
        return vehicleType + " fra " + district;
    }

    private String validateDistrict(String districtCode) {
        // Opg 2b) Tjek kendingsbogstaver og returner politidistrikt
        //hvis districtmap IKKE contains key som er sat ind som districtCode, return kreds findes ikke.
        //ellers return districtcode i districtmap
        if (!districtMap.containsKey(districtCode)) {
            return "Kreds findes ikke";
        } else {
            return districtMap.get(districtCode);
        }
    }

    private String validateVehicleType(int number) {
        // Opg 2b) Tjek hvilket interval number ligger i og returner anvendelse
        for (int i = 0; i < vehicleTypes.length; i++) {
            if (vehicleTypes[i].isA(number)) {
                return vehicleTypes[i].getVehicleType();
            }
        }
        return "Illegalt nummer: " + number;
    }

    public static void main(String[] arg) {
        // Opg 2) Kan benyttes til test af opgave 2a og 2b
        NumberPlates pd = new NumberPlates();

        System.out.println("KC39078: " + pd.validate("KC39078"));
        System.out.println("kc49900: " + pd.validate("kc49900"));
        System.out.println("KO47078: " + pd.validate("KO47078"));
        System.out.println("EN19022: " + pd.validate("EN19022"));
        System.out.println("EN190220: " + pd.validate("EN190220"));
    }

}
