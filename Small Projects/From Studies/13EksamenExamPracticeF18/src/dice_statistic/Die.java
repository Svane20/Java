package dice_statistic;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.Random;

/**
 *
 * @author erso Created on 09-08-2010, 07:58:49
 */
public class Die {
    private Random generator;

    public Die(){
        generator = new Random();

    }

    public int roll(){
        return generator.nextInt(6)+1;
    }

}
