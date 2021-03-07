package opg2_polymorphi;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author erso
 */
public class NumberCheckerFacade
{

    public NumberCheckerFacade()
    {
    }

    public List<Integer> checkNumbers(int min, int max, CheckerInterface checker)
    {
        List<Integer> result = new LinkedList<>();
        for (int i = min; i < max; i++)
        {
            if (checker.check(i))
            {
                result.add(i);
            }
        }

        return result;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        NumberCheckerFacade ncf = new NumberCheckerFacade();

        CheckerInterface checker = new EvenChecker();
        System.out.println("Palindromes: " + ncf.checkNumbers(10, 100, checker));

        checker = new PrimeChecker();
        System.out.println("Primes: " + ncf.checkNumbers(10, 100, checker));

        checker = new SquareChecker();
        System.out.println("Powers of 2: " + ncf.checkNumbers(10, 100, checker));

    }

}
