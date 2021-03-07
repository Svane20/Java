/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mountains_in_france;

import java.util.Comparator;

/**
 *
 * @author adooz
 */
public class MountainRangeComparator implements Comparator<Mountain> {

    @Override
    public int compare(Mountain o1, Mountain o2) {
        int r = o1.getRange().compareTo(o2.getRange());
        if (r == 0) {
            r = o1.compareTo(o2);
        }
        return r;
    }
    
}
