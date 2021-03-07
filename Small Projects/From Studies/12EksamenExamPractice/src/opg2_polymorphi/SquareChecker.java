
package opg2_polymorphi;

/**
 *
 * @author erso
 */
public class SquareChecker implements CheckerInterface{

    @Override
    public boolean check(int i)
    {
        double y = Math.sqrt(i);
        
        return y == (int)y;
    }

}
