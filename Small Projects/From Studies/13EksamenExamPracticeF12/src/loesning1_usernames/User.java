package loesning1_usernames;

import java.util.Date;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class User {

    private String fullName;
    private Date createdAt;

    public User(String name) {
        this.fullName = name;
        this.createdAt = new Date();
    }

    public String makeUserName() {
        String[] names = fullName.split(" ");
        String userName = "";

        if (names[0].length() > 1) {
            userName += names[0].substring(0, 2).toLowerCase();
        } else {
            userName += names[0].toLowerCase();
        }

        if (names[names.length - 1].length() > 2) {
            userName += names[names.length - 1].substring(0, 3).toLowerCase();
        } else {
            userName += names[names.length - 1].toLowerCase();
        }
        userName = userName.replace("�", "ae");
        userName = userName.replace("�", "oe");
        userName = userName.replace("�", "aa");

        return userName;
    }

    @Override
    public String toString() {
        return "User: " + fullName + " - " + createdAt;
    }

    public static void main(String[] arg) {
        // Til test af opg. 1a
        User user1 = new User("Joachim Holger Waldemar Christian");
        System.out.println(user1);

        User user2 = new User("Ib Bo");
        System.out.println(user2);

        User user3 = new User("�ge B�geskov");
        System.out.println(user3);

        // Til test af opg. 1b 
        System.out.println(user1.makeUserName());
        System.out.println(user2.makeUserName());
        System.out.println(user3.makeUserName());
    }
}
