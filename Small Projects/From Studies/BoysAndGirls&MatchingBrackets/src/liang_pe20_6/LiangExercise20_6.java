package liang_pe20_6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LiangExercise20_6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {


//        List<Integer> list = new ArrayList<>();
//        int numbers = 10000000; //10m

        List<Integer> list = new LinkedList<>(); // Just put 100000 in. Else you'll get old before it's finish
        int numbers = 100000;

        for (int i = 0; i < numbers; i++) {
            list.add(i);
        }

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Travese time using index is " + (endTime - startTime));

        int x;
        startTime = System.currentTimeMillis();
        for (int i : list) {
            x = i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("Travese time using iterator is " + (endTime - startTime));
    }

}
