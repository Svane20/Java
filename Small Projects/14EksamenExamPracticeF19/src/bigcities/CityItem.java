package bigcities;

import java.util.Arrays;

/**
 * Udleveret kodeskelet til eksamen VOP F19 opg 3
 *
 * @author erso
 */
public class CityItem implements Comparable<CityItem> {

    private String city;
    private int population;
    private int range;

    public CityItem(String city, String pop, String ran) {
        this.city = city;
        this.population = Integer.parseInt(pop);
        this.range = Integer.parseInt(ran);
    }

    public CityItem(String city, int population, int range) {
        this.city = city;
        this.population = population;
        this.range = range;
    }

    @Override
    public String toString() {
        // Opg 3a. Implementer toString() metoden
        return city + ": " + " population: " + population + " range: " + range;
    }

    @Override
    public int compareTo(CityItem o) {
        // Opg 3b. implementer compareTo() metoden
        int i = this.city.compareTo(o.city);
        return i;
    }

    public static void main(String[] args) {
        // Til test af opgave 3a:
        CityItem ci = new CityItem("KOBENHAVN (Copenhagen)", "499000", "99");
        System.out.println(ci);

        // Til test af opgave 3b
        CityItem[] testArray = new CityItem[3];
        testArray[0] = new CityItem("OSLO", "505000", "97");
        testArray[1] = new CityItem("STOCKHOLM", "744000", "51");
        testArray[2] = new CityItem("KOBENHAVN (Copenhagen)", "499000", "99");

        System.out.println("Usorteret:");
        System.out.println(Arrays.toString(testArray));

        Arrays.sort(testArray);
        System.out.println("Sorteret:");
        System.out.println(Arrays.toString(testArray));
    }

}
