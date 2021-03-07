package opg4names;

import java.util.Comparator;

public class CommonNamesComparator implements Comparator<CommonName>{

    @Override
    public int compare(CommonName o1, CommonName o2) {
        return o1.getName().compareTo(o2.getName());
    }
    
}
