/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opg4names;

import java.util.Comparator;

/**
 *
 * @author erso
 */
public class CommonNamesComparator implements Comparator<CommonName>{

    @Override
    public int compare(CommonName o1, CommonName o2) {
        return o1.getName().compareTo(o2.getName());
    }
    
}
