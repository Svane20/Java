package arrays;

import java.util.Arrays;
import java.util.Random;

/**
 * Standard løsning
 *
 * @author erso
 */
public class ArrayTester {
    private static Random generator = new Random();
    private static final int MAX = 100;

    private int[] intArray;

    // Opg 3a: Initialiser arrayet, så det får længden 'size'
    public ArrayTester(int size) {
        intArray = new int[size];
        fillArray();
    }

    // Opg 3a fortsat: Udfyld arrayet med tilfældige tal mellem 0 og MAX
    public void fillArray() {
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = generator.nextInt(MAX);
        }
    }

    // Opg 3b: Implementer metoden så der returneres en String indeholdende
    // arrayets elementer adskilt af et komma efterfulgt af et mellemrum
    // Fx '23, 97, 02, '..osv
    // Der skal indsættes et linjeskifte ("\n") for hvert 8. element og
    // værdier som er mindre end 10 skal indsættes med et foranstillet '0'
    // fx '04', '07' osv...
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < intArray.length; i++) {
            if (i % 8 == 0) {
                sb.append("\n");
            } else {
                sb.append(", ");
            }

            if (intArray[i] < 10) {
                sb.append("0");
            }
            sb.append(intArray[i]);
        }
        sb.append("\n---------------------\n");
        return sb.toString();
    }

    // Opg 3c: Benyt en sorterings algoritme fra java.util.Arrays til at sortere
    // arrayet med.
    public void sort() {
        Arrays.sort(intArray);
    }

    // Udleveret metode, som bytter om på 2 elementer i arrayet.
    // Skal benyttes ved løsning af opg 3d
    public void swap(int fromIndex, int toIndex) {
        int temp = intArray[fromIndex];
        intArray[fromIndex] = intArray[toIndex];
        intArray[toIndex] = temp;

    }

    // Opg 3d: Benyt den udleverede 'swap'-metode så rækkefølgen
    // af arrayets elementer bliver omvendt.
    public void reverse() {
        int i = 0;
        int j = intArray.length - 1;
        while (i < j) {
            swap(i, j);
            i++;
            j--;
        }
    }

    /**
     * Udleveret test metode.
     */
    public static void main(String[] args) {
        int size = 30;
        ArrayTester arrayTester = new ArrayTester(size);
        System.out.println("fillArray: " + arrayTester);

        arrayTester.sort();
        System.out.println("sorted: " + arrayTester);

        arrayTester.reverse();
        System.out.println("reverse: " + arrayTester);

    }

}
