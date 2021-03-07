/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package population;

import java.io.Serializable;

/**
 *
 * @author erso
 */
public class DanishTown implements Comparable<DanishTown>{
    private String name;
    private int pop2012;
    private int pop2018;

    public DanishTown(String name, int population12, int population18) {
        this.name = name;
        this.pop2012 = population12;
        this.pop2018 = population18;
    }
    
    private int getDiff(){
        return pop2018 - pop2012;
    }

    @Override
    public String toString() {
        return "\n"+ name + " dif: " + getDiff();
    }
    
    


    @Override
    public int compareTo(DanishTown o) {
        int i = this.getDiff() - o.getDiff();
        if(i == 0){
            i = this.name.compareTo(o.name);
        }
        return i;
    }

        /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

}
