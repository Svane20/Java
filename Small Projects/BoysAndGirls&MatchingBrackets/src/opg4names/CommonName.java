/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opg4names;

import java.util.Arrays;

/**
 *
 * @author erso
 */
public class CommonName implements Comparable<CommonName>{
    private String name;
    private int girls;
    private int boys;

    public CommonName(String name, int girls, int boys) {
        this.name = name;
        this.girls = girls;
        this.boys = boys;
    }

    @Override
    public String toString() {
        return String.format("%-12s Girls:%6d Boys:%6d Total:%6d\n", name, girls, boys, getTotal());

    }
    
    private int getTotal(){
        return girls+boys;
    }

    public String getName(){
        return name;
    }

    @Override
    public int compareTo(CommonName o) {

        int r = o.getTotal() - this.getTotal();
        if(r == 0){
            r = this.name.compareTo(o.name);
        }
        return r;
    }
    
    public static void main(String[] a){
        CommonName[] testArray = new CommonName[4];
        
        testArray[0] = new CommonName("Ibi", 10, 20);
        testArray[1] = new CommonName("Ib", 20, 10);
        testArray[2] = new CommonName("Ea", 20, 20);
        testArray[3] = new CommonName("Eva", 20, 5);
        System.out.println("Usorteret:\n" + Arrays.toString(testArray));
        
        Arrays.sort(testArray);
        System.out.println("Sorteret:\n" + Arrays.toString(testArray));
    }

    
}
