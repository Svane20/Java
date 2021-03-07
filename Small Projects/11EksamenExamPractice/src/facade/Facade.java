package facade;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author erso
 */
public class Facade
{

    private int[] intArray;
    private Random generator;

    public Facade()
    {
        generator = new Random();
    }

    // Opgave 2b, loops and conditions
    public int[] fillArray(int size, int max)
    {
        intArray = new int[size];
        for (int i = 0; i < intArray.length; i++)
        {
            intArray[i] = generator.nextInt(max);
        }
        return intArray;
    }

    public int sumOfDivisors(int number)
    {
        int sum = 0;
        for (int x : intArray)
        {
            if (x % number == 0)
            {
                sum += x;
            }
        }
        return sum;
    }

    public int[] fillUniqueArray(int size, int max)
    {
        if(!(size < max)){
            System.out.println("size er større end max!");
            return null;
        }
        intArray = new int[size];
        int index = 0;
        while (index < intArray.length)
        {
            int x = generator.nextInt(max);
            if (!contains(x, index))
            {
                intArray[index] = x;
                index++;
            }
        }
        Arrays.sort(intArray);
        return intArray;
    }

    private boolean contains(int x, int beforeIndex)
    {
        for (int i = 0; i < beforeIndex; i++)
        {
            if (intArray[i] == x)
            {
                return true;
            }
        }
        return false;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Facade facade = new Facade();

        System.out.println("fillArray: " + Arrays.toString(facade.fillArray(20, 10)));
        int divisor = 3;
        System.out.println("Divisors of " + divisor + " has Sum: " + facade.sumOfDivisors(divisor));

        System.out.println("fillUnique: " + Arrays.toString(facade.fillUniqueArray(20, 30)));

        System.out.println("Error: " + Arrays.toString(facade.fillUniqueArray(20, 20)));
    }

}
