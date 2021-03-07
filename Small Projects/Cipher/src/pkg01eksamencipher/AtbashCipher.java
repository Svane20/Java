/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg01eksamencipher;

/**
 *
 * @author maimartinsen
 */
public class AtbashCipher extends AbstractCipher {

    @Override
    public String encrypt(String message) {
        StringBuilder sb = new StringBuilder();
        
        
        int index;
        for(char c : message.toCharArray()){

            index = findCharIndex(c);
            if(index > -1){
                sb.append(ALPHABETH[ALPHABETH.length - 1 - index]);
            }
            else{
                sb.append(c);
            }
        }
        return sb.toString();
    }

    @Override
    public String decrypt(String encrypted) {
        return encrypt(encrypted);
    }
    
}
