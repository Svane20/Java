
package opg2_polymorphi;

/**
 *
 * @author erso
 */
public class PrimeChecker implements CheckerInterface{

    @Override
    public boolean check(int i)
    {
        return isPrime(i);
    }

    private boolean isPrime(int number)
    {
        int sqrt = (int) Math.sqrt(number) + 1;
        for (int i = 2; i < sqrt; i++) {
            if (number % i == 0) {
                // number is perfectly divisible - no prime
                return false;
            }
        }
        return true;
    }

}
