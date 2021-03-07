package opg4names;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author erso
 */
public class GirlsAndBoys {

    private Map<String, Integer> girlsMap;
    private Map<String, Integer> boysMap;
    private Set<CommonName> commonSet;

    public GirlsAndBoys() {
        boysMap = createNameMap(new File("Boys.txt"));
        girlsMap = createNameMap(new File("Girls.txt"));
    }

    private Map<String, Integer> createNameMap(File file) {

        Map<String, Integer> map = new HashMap<>();
        try (Scanner sc = new Scanner(file)) {
            String[] line;
            while (sc.hasNextLine()) {
                line = sc.nextLine().split("\t");

                map.put(line[1], new Integer(line[2]));
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        System.out.println(file.getName() + ":\n" + map);
        return map;
    }

    public void makeCommonNames() {
        commonSet = new TreeSet<>();
        for (String name : girlsMap.keySet()) {
            if (boysMap.containsKey(name)) {
                commonSet.add(new CommonName(name, girlsMap.get(name), boysMap.get(name)));
            }
        }
        
    }

    @Override
    public String toString() {
        String st = commonSet.toString();
        st = st.substring(1);
        st = st.substring(0, st.length() - 1);
        st = st.replace(", ", "");
        return st;
    }

    public void sortCommonByName(Comparator<CommonName> comparator) {
        Set<CommonName> set = new TreeSet<>(comparator);
        set.addAll(commonSet);
        commonSet = set;
        
    }

    public void write2file(File f) {
        try (FileWriter fw = new FileWriter(f)) {
            for (CommonName cn : commonSet) {
                fw.append(cn.toString());
            }
        } catch (IOException ex) {
            Logger.getLogger(GirlsAndBoys.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GirlsAndBoys gAndB = new GirlsAndBoys();
        gAndB.makeCommonNames();

        System.out.println("Common Names:\n" + gAndB.toString());
        
//        gAndB.write2file(new File("CommonSortByNumber.txt"));

        gAndB.sortCommonByName(new CommonNamesComparator());
        System.out.println("Sorted by name:\n" + gAndB.toString());
//        gAndB.write2file(new File("CommonSortByName.txt"));
    }

//        throw new UnsupportedOperationException("Not supported yet.");

}
