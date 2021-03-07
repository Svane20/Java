package opg3_tour;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author erso
 */
public class TourDeFranceMain
{
    private List<RacingCyclist> list;
    private File tourFile;

    public TourDeFranceMain(String fileName)
    {
        this.tourFile = new File(fileName);
        list = new ArrayList<>();
    }
    
    public void readFile(){
        
        try (Scanner scan = new Scanner(tourFile))
        {
            String line[];
            RacingCyclist cyclist;
            while(scan.hasNextLine()){
                line = scan.nextLine().split("\t");
                cyclist = new RacingCyclist(line[0], line[1], line[2], line[3], new Integer(line[4]), new Integer(line[5]));
                list.add(cyclist);
            }
            
        } catch (FileNotFoundException ex)
        {
            ex.printStackTrace();
        }
    }

    public List<RacingCyclist> getList()
    {
        return list;
    }

    public void sort(){
        Collections.sort(list);
    }
    
    public Set<RacingCyclist> makeSortedSet(Comparator comp){
        Set<RacingCyclist> set = new TreeSet<>(comp);
        for(RacingCyclist rider: list){
            set.add(rider);
        }
        return set;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        TourDeFranceMain tfm = new TourDeFranceMain("tourdefrance.txt");
        tfm.readFile();
        System.out.println("List:\n" + tfm.getList().subList(0, 10));
        
        tfm.sort();
        System.out.println("Sort:\n" + tfm.getList().subList(0, 10));

        Comparator<RacingCyclist> comp = new CountryMountainComparator();
        Set<RacingCyclist> countryMountainSet = tfm.makeSortedSet(comp);
        System.out.println("Country/Mountain:\n" + countryMountainSet);
//
//        tfm.sort(new CountryComparator());
//        System.out.println("Point:\n" + tfm.getList().subList(0, 10));
    }
    
}
