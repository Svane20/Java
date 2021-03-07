package big_java_exercise_20_7;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileInputStream;

/**
 * Counts how many words in a file.
 */
public class WordCountRunnable implements Runnable {

    private String filename;

    /**
     * Constructs a WordCountRunnable object with a file name.
     *
     * @param aFilename the file name that needs to count word
     */
    public WordCountRunnable(String aFilename) {
        filename = aFilename;
    }

    public void run() {
        int count = 0;
        try (Scanner in = new Scanner(new FileInputStream(filename))) {

            while (in.hasNext()) {
                in.next();
                count++;
            }
        } catch (FileNotFoundException e) {
            System.out.println(filename + " not found!");

        }
        System.out.println(filename + ": " + count);
    }
}
