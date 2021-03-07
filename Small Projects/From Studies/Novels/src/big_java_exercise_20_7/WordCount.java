package big_java_exercise_20_7;

public class WordCount
{
    public static void main(String argv[])
    {
        String[] fileNames = {"alice30.txt", "Boscombe.txt", "Snow White.txt"};
        for (int i = 0; i < fileNames.length; i++)
        {
            Runnable wcr = new WordCountRunnable(fileNames[i]);
            Thread t = new Thread(wcr);
            t.start();
        }
    }
}
