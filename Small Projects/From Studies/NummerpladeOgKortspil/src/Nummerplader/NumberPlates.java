package Nummerplader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NumberPlates {

    public static final int LENGTH = 7;         
    
    private Map<String, String> districtMap;    
    
    private VehicleType[] vehicleTypes = { 
        new VehicleType("Motorcykel", 10000, 19999),
        new VehicleType("Privat personvogn", 20000, 45999),
        new VehicleType("Udlejningsvogn", 46000, 46999),
        new VehicleType("Hyrevogn", 47000, 48999),
        new VehicleType("Skolevogn", 49000, 49899),
        new VehicleType("Ambulance el. lign.", 49900, 49999),
        new VehicleType("Diverse andre ", 50000, 84999)
    };

    public NumberPlates() {
        districtMap = new HashMap<>();
        readFile();
    }

    public void readFile() {
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
        if (plate.length() != LENGTH) {
            return "Illegal laengde";
        }

        String district = validateDistrict(plate.substring(0, 2).toUpperCase());
        Integer numberPart = Integer.parseInt(plate.substring(2));
        String vehicleType = validateVehicleType(numberPart);
        return vehicleType + " fra " + district;
    }

    private String validateDistrict(String districtCode) {
        if (!districtMap.containsKey(districtCode)) {
            return "Kreds findes ikke";
        } else {
            return districtMap.get(districtCode);
        }
    }

    private String validateVehicleType(int number) {
        for (int i = 0; i < vehicleTypes.length; i++) {
            if (vehicleTypes[i].isA(number)) {
                return vehicleTypes[i].getVehicleType();
            }
        }
        return "Illegalt nummer: " + number;
    }

    public static void main(String[] arg) {
        NumberPlates pd = new NumberPlates();

        System.out.println("KC39078: " + pd.validate("KC39078"));
        System.out.println("kc49900: " + pd.validate("kc49900"));
        System.out.println("KO47078: " + pd.validate("KO47078"));
        System.out.println("EN19022: " + pd.validate("EN19022"));
        System.out.println("EN190220: " + pd.validate("EN190220"));
    }

}
