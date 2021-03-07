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
public class CeasarCipher extends AbstractCipher {
    
    int rotFactor;

    public CeasarCipher(int rotFactor) {
        
        if (rotFactor >= 0 && rotFactor <= ALPHABETH.length) {
            this.rotFactor = rotFactor;
        }
        else {
            System.out.println("Invalid rotation factor");
        }
    }

    @Override
    public String encrypt(String message) {
        StringBuilder sb = new StringBuilder();
        
        
        int index;
        for(char c : message.toCharArray()){

            index = findCharIndex(c);
            if(index > -1){
                sb.append(ALPHABETH[(index + rotFactor) % ALPHABETH.length]);
            }
            else{
                sb.append(c);
            }
        }
        return sb.toString();
    }

    @Override
    public String decrypt(String encrypted) {
        StringBuilder sb = new StringBuilder();
        
        
        int index;
        for(char c : encrypted.toCharArray()){

            index = findCharIndex(c);
            if(index > -1){
                sb.append(ALPHABETH[(index + ALPHABETH.length - rotFactor) % ALPHABETH.length]);
            }
            else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
