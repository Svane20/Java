/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package danish_towns;

/**
 *
 * @author erso
 */
public class DanishTown implements Comparable<DanishTown>{
    private String name;
    private int population11;
    private int population12;

    public DanishTown(String name, int population11, int population12) {
        this.name = name;
        this.population11 = population11;
        this.population12 = population12;
    }
    
    private int getDiff(){
        return population12 - population11;
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


}
