/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dice_statistic;

import java.util.Arrays;

/**
 *
 * @author erso   Created on 09-08-2010, 08:04:13
 */
public class RollingDice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int rolls = 100000;
        Die d1 = new Die();
        Die d2 = new Die();
        int arr[] = new int[11];//{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        int a, b, sum;
        for (int i = 0; i < rolls; i++) {
            a = d1.roll();
            b = d2.roll();
            sum = a + b;
            arr[sum - 2]++;

//            System.out.println("d1: "+a+" d2: "+b +" sum: "+sum);
        }
        System.out.println(Arrays.toString(arr));
//
        //Opg c. Fordeling udskrevet med printf
        for (int i = 0; i < arr.length; i++) {
            double r = (double) arr[i] / rolls * 100;
            System.out.printf("Sum %1$2d in %2$6.2f %%\n", (i + 2), r);
        }

//        //Opg b. Alternativt udskrevet med NumberFormat
//        NumberFormat nf = new DecimalFormat("00.00");
//        String prefix;
//        for(int i = 0; i < arr.length; i++ ){
//            prefix = (i+2)<10?"Sum  "+(i+2)+" found in ":"Sum "+(i+2)+" found in ";
//            double r = (double)arr[i]/rolls*100;
//            System.out.println(prefix+nf.format(r)+"%");
//        }

    }
}
