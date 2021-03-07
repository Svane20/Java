package opg3_tour;

import java.util.Comparator;

/**
 *
 * @author erso
 */
public class CountryMountainComparator implements Comparator<RacingCyclist>
{

    @Override
    public int compare(RacingCyclist o1, RacingCyclist o2)
    {
        int r = o1.getCountry().compareTo(o2.getCountry());
        if (r == 0)
        {
            r = o2.getMountains() - o1.getMountains();
        }
        return r;
    }

}
