package exercise_text_analyser;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class TextAnalyzer {

	private File file;

	public TextAnalyzer(String fileName) {
		file = new File(fileName);
	}

	// Opgave 2A     
	// Parameteren sorted afgør om der skal benyttes et sorteret Set
	//
	public Set<String> findUniqueWords(boolean sorted) {
		Set<String> set;
		if (sorted) {
			set = new TreeSet<String>();
		} else {
			set = new HashSet<String>();
		}
                
		// gennemlæs filen et ord ad gangen
		// kald clean() metoden på hvert ord
		// og tilføj ordet til settet.
                
                Scanner scanner = null;
                
                try {
                    scanner = new Scanner(file);
                    while (scanner.hasNext()) {
                        set.add(clean(scanner.next()));
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                scanner.close();
		return set;
	}

	// Opgave 2B:   Nearly as Listing 21.9 from Liang
	//
	public Map<String, Integer> countWords(boolean sorted) {
		Map<String, Integer> map;
		if (sorted) {
			map = new TreeMap<String, Integer>();
		} else {
			map = new HashMap<String, Integer>();
		}
		// gennemlæs filen et ord ad gangen
		// kald clean() metoden på hvert ord
		// benyt mappen til at tælle forekomsten af hvert ord
                
                Scanner scanner = null;
                
                try {
                    scanner = new Scanner(file);
                    String word = "";
                    int val;
                    while (scanner.hasNext()) {
                        val = 1;
                        word = clean(scanner.next());
                        if (map.containsKey(word)) {
                            val += map.get(word);
                        }
                        map.put(word, val);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                scanner.close();
		return map;
	}

	// Opgave 2C:     Udvidelse af P15.1
	//
	public Map<Integer, Set<String>> lengthOfWords(boolean sorted) {
		Map<Integer, Set<String>> mapOfSets;
		if (sorted) {
			mapOfSets = new TreeMap<Integer, Set<String>>();
		} else {
			mapOfSets = new HashMap<Integer, Set<String>>();
		}
		// gennemlæs filen et ord ad gangen
		// kald clean() metoden på hvert ord
		// Indsæt hvert ord i det Set<String> som er værdi til ordlængden som key
		// Hint: nyt Set<String> skal oprettes hver gang en længde opdages første gang.

                Scanner scanner = null;
                
                try {
                    scanner = new Scanner(file);
                    String word = "";
                    int length;
                    while (scanner.hasNext()) {
                        word = clean(scanner.next());
                        length = word.length();
                        
                        if (mapOfSets.containsKey(length)) {
                            mapOfSets.get(length).add(word); 
                        } else {
                            Set<String> s = sorted ? new TreeSet<String>() : new HashSet<String>();
                            s.add(word);
                            mapOfSets.put(length, s);
                        }
                    }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
                scanner.close();
		return mapOfSets;

	}

	// Denne metode forsøger at fjerne alt 'snavs' fra en String,
	// så kun bogstaver bevares og store gøres til små
	private String clean(String s) {
		String r = "";
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isLetter(c)) {
				r = r + c;
			}
		}
		return r.toLowerCase();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		TextAnalyzer ta = new TextAnalyzer("alice30.txt");

		//Opgave 2A. Find alle unikke ord i filen
		Set<String> set = ta.findUniqueWords(true);
		System.out.println(set);
		System.out.println("Number of unique words: " + set.size());

		System.out.println("\n------------------------------------------------------------------\n");

		// Opgave 2B. Tæl forekomster af ord
		Map<String, Integer> map = ta.countWords(true);
		System.out.println(map);

		System.out.println("\n------------------------------------------------------------------\n");

		// Opgave 2C. Benyt en mappe til at gruppere ord efter længde
		Map<Integer, Set<String>> map2 = ta.lengthOfWords(true);
		System.out.println(map2);

	}

}
