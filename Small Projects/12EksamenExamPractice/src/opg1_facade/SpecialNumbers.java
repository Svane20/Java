package opg1_facade;

/**
 *
 * @author erso
 */
public class SpecialNumbers
{

    
    public boolean isEven(int x){
        return x % 2 == 0;
    }
    
    public boolean isPrime(int x){
        int sqrt = (int) Math.sqrt(x) + 1;
        for (int i = 2; i < sqrt; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public boolean isSquare(int x){
        double y = Math.sqrt(x);
        
        return y == (int)y;    }
    
   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {

        SpecialNumbers sn = new SpecialNumbers();
        int x = 1024;
        int y = 1021;
        System.out.println("Even\t" + x +": " + sn.isEven(x) + "\t" + y + ": " + sn.isEven(y));
        System.out.println("Prime\t" + x +": " + sn.isPrime(x) + "\t" + y + ": " + sn.isPrime(y));
        System.out.println("Pow 2\t" + x +": " + sn.isSquare(x) + "\t" + y + ": " + sn.isSquare(y));

    }
    
}
