
package opg2_polymorphi;

/**
 *
 * @author erso
 */
public class EvenChecker implements CheckerInterface{

    @Override
    public boolean check(int i)
    {
        return i % 2 == 0;
    }

}
