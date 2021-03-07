package matching_brackets_solution;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MatchingBracketsWithList {

    public boolean ckeckBrackets(String expression){
        List<Character> parens = new LinkedList<Character>();

      for (int i = 0; i < expression.length(); i++)
      {
         char ch = expression.charAt(i);
         if (ch == '(' || ch == '[' || ch == '{')
         {
            parens.add(0, ch);
         }
         else if (ch == ')' || ch == ']' || ch == '}')
         {
            if (parens.isEmpty())
            {
               System.out.println("Not balanced.");
               return false;
            }
            char open = parens.remove(0);
            if (!(open == '(' && ch == ')'
                  || open == '[' && ch == ']'
                  || open == '{' && ch == '}'))
            {
               System.out.println("Not balanced.");
               return false;
            }
         }
      }
      if (parens.isEmpty()) 
      { 
         System.out.print("Balanced.\t ");
         return true;
      }
      else
      { 
         System.out.print("Not balanced.\t");
         return false;
         
      }        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        
            MatchingBracketsWithList pc = new MatchingBracketsWithList();
           try (Scanner in = new Scanner(new File("DanishTown.java"))){ 
            
            StringBuilder expression = new StringBuilder();
            while(in.hasNextLine()){
                expression.append(in.nextLine());
            }
            pc.ckeckBrackets(expression.toString());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MatchingBracketsWithList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
