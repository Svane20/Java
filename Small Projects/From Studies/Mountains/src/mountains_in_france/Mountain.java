package mountains_in_france;

import java.util.Arrays;

public class Mountain implements Comparable<Mountain> {
    String name;
    String height;
    String prominence;
    String latitude;
    String longitude;
    String range;
    String getRange;

    public Mountain(String name, String height, String prominence, String latitude, String longitude, String range) {
        this.name = name;
        this.height = height;
        this.prominence = prominence;
        this.latitude = latitude;
        this.longitude = longitude;
        this.range = range;
    }

    @Override
    public String toString() {
        return name + " height = " + height + ", prominence = " + prominence +
                ", latitude = " + latitude + ", longitude = " + longitude + ", range = " + range;
    }

    @Override
    public int compareTo(Mountain o) {
        int r = this.prominence.compareTo(o.prominence);
        if (r == 0) {
            r = this.height.compareTo(o.height);
        }
        return r;
    }
    
    public String getRange() {
        return range;
    }

    
    public static void main(String[] args) {
        Mountain m = new Mountain("Mont Ventoux", "1909", "1148", "44\u00B010'26\"", "05\u00B016'42\"", "Alps");
        System.out.println(m);

        Mountain[] testArray = new Mountain[4];
        testArray[0] = new Mountain("Pica d'Estats", "3143", "1281", "42\u00B042'43\"", "00\u00B057'23\"", "Pyrenees\n");
        testArray[1] = new Mountain("Mont Chaberton", "3131", "1281", "44\u00B057'53\"", "06\u00B045'06\"", "Alps\n");
        testArray[2] = new Mountain("Pic de Bure", "2709", "1268", "44\u00B037'38\"", "05\u00B056'07\"", "Alps\n");
        testArray[3] = new Mountain("Pic du Midi d'Ossau", "2886", "1092", "42\u00B048'22\"", "-00\u00B025'05\"", "Pyrenees\n");

        System.out.println("Usorteret: ");
        System.out.println(Arrays.toString(testArray));

        System.out.println("Sorteret: ");
        Arrays.sort(testArray);
        System.out.println(Arrays.toString(testArray));

    }



}
