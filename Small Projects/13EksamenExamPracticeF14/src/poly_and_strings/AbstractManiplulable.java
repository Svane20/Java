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
public abstract class AbstractManiplulable implements StringManipulable{

    protected String originalString;

    public AbstractManiplulable(String originalString) {
        this.originalString = originalString;
    }

    @Override
    public String toString() {
        return getClass().getName() + ":\n"
                +originalString + " -> " + manip();
    }
    
    
    
    

}
