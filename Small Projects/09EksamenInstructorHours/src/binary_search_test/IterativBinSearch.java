package binary_search_test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author erso
 */
public class IterativBinSearch {
    public static int find(int[] numbers, int target) {
        int min = 0, max = numbers.length-1;
 
        while (min <= max) {
            int pos = (min+max) / 2;
            if (numbers[pos] == target) {
                return pos;
            }
            if (numbers[pos] < target) {
                min = pos + 1;
            } else {
                max = pos - 1;
            }
        }
 
        // +1, because 0 belongs to positive indices
        return -(min+1);
    }    
}
