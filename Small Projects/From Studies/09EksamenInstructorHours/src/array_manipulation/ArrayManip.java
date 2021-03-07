/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array_manipulation;

/**
 *
 * @author erso
 */

import java.util.Arrays;
import java.util.Random;

/**
 * OOP test eksamen f09 opg 1
 * @author erso
 */
public class ArrayManip {


    public int[] evenOdd(int [] array){
        int odd = 0;
        int even = array.length -1;
        int[] temp = new int[array.length];

        for(int i = 0; i < array.length; i++){
            if(array[i]%2 != 0){
                temp[odd] = array[i];
                odd++;
            }
            else{
                temp[even]= array[i];
                even--;
            }
        }
        System.out.println ("odd: " + odd +" even: " + even);
        System.out.println("EvenOdd: " +
                Arrays.toString(temp));
        sort(temp, odd);
        return temp;
    }

    public void sort(int [] array, int splitIndex){
        Arrays.sort(array, 0, splitIndex);
        for(int i = splitIndex; i < array.length; i++){
            array[i] = -array[i];
        }
        Arrays.sort(array, splitIndex, array.length);
        for(int i = splitIndex; i < array.length; i++){
            array[i] = -array[i];
        }
    }
    
    public static void main(String [] arg){
        Random generator = new Random(222); //The seed gives same sequense every time
        int array[] = new int [10];
        for(int i = 0; i < array.length; i++){
            array[i] = generator.nextInt(100);
        }
        System.out.println("Input:  "+Arrays.toString(array));

        ArrayManip arrMani = new ArrayManip();
    
        int result[] = arrMani.evenOdd(array);
        System.out.println("Output: " +Arrays.toString(result));

    }

}

    
