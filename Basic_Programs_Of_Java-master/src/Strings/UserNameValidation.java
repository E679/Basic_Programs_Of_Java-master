package Strings;

import java.util.Scanner;

public class UserNameValidation {
    public static boolean CodelandUsernameValidation(String str) {
        // code goes here
        str=str.toLowerCase();
        boolean usernameLength = str.length() > 4 && str.length() < 25;
        boolean usernameStartwithletter = Character.isLetter(str.charAt(0));
        boolean usernameendwithunderscore = (str.charAt(str.length() - 1)) != '_';


        return usernameLength && usernameStartwithletter && usernameendwithunderscore && validateUsernameLetterOrNumber(str);
    }

    public static boolean validateUsernameLetterOrNumber(String str) {
        return str
                .chars().anyMatch(x->Character.isLetter(x) || Character.isDigit(x) || str.contains("_"));
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print(CodelandUsernameValidation(s.nextLine()));
    }
}
