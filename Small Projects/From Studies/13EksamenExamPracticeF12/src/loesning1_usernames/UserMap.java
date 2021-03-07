package loesning1_usernames;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserMap {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Map<String, User> map = new HashMap<String, User>();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter full name:");
        String fullName = sc.nextLine();
        while (!fullName.equalsIgnoreCase("")) {
            User user = new User(fullName);
            String userName = user.makeUserName();

            // Her tildeles loebenummer, hvis userName allerede findes
            int i = 0;
            while (map.containsKey(i == 0 ? userName : userName + i)) {
                i++;
            }
            if (i > 0) {
                userName += i;
            }

            map.put(userName, user);
            fullName = sc.nextLine();
        }

        System.out.println(map);

    }

}
