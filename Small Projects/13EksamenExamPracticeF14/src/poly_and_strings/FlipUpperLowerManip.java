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
public class FlipUpperLowerManip extends AbstractManiplulable{

    public FlipUpperLowerManip(String originalString) {
        super(originalString);
    }

    @Override
    public String manip() {
        String flipped = "";
        for(int i = 0; i < originalString.length(); i++){
            if(Character.isUpperCase( originalString.charAt(i))){
                flipped += Character.toLowerCase(originalString.charAt(i));
            }
            else if(Character.isLowerCase(originalString.charAt(i))){
                flipped += Character.toUpperCase(originalString.charAt(i));
            }
            else{
                flipped += originalString.charAt(i);
            }
        }
        
        return flipped;
    }

}
