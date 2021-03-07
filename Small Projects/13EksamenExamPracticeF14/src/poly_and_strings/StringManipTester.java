/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package poly_and_strings;

/**
 *
 * @author erso
 */
public class StringManipTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Test af String manipulation
        StringManipulable manip;
        String input = "Test AF PolyMORPHISM!";
        
        manip = new ToLowerManip(input);
        System.out.println(manip);
       
        manip = new ToUpperManip(input);
        System.out.println(manip);
       
        manip = new FlipUpperLowerManip(input);
        System.out.println(manip);
       
    }
    
}
