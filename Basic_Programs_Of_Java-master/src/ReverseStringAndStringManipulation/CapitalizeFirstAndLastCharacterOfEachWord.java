package ReverseStringAndStringManipulation;

import java.util.Arrays;

public class CapitalizeFirstAndLastCharacterOfEachWord {
    public static void main(String[] args) {
        String s="hi my name is supreeth";
        String capitalizeFirstAndLastCharacterOfEachWord = capitalizeFirstAndLastCharacterOfEachWord(s);
        System.out.println("capitalizeFirstAndLastCharacterOfEachWord: "+capitalizeFirstAndLastCharacterOfEachWord);
        System.out.println("capitalizeFirstAndLastCharacterOfEachWordWithoutStringBuilder: "+capitalizeFirstAndLastCharacterOfEachWordWithoutStringBuilder(s));
    }

    private static String capitalizeFirstAndLastCharacterOfEachWord(String s){
        String[] words = s.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            int len = word.length();
            if (len == 1) {
                result.append(Character.toUpperCase(word.charAt(0))).append(" ");
            } else {
                StringBuilder modifiedWord = new StringBuilder();
                modifiedWord.append(Character.toUpperCase(word.charAt(0))); // First char
                modifiedWord.append(word.substring(1, len - 1)); // Middle part
                modifiedWord.append(Character.toUpperCase(word.charAt(len - 1))); // Last char
                result.append(modifiedWord).append(" ");
            }
        }
        return result.toString().trim();
    }
    //Without using string builder
    private static String capitalizeFirstAndLastCharacterOfEachWordWithoutStringBuilder(String s){
        String[] words = s.split(" ");
        String result = "";

        for (String word : words) {
            int len = word.length();
            if (len == 1) {
                result += Character.toUpperCase(word.charAt(0)) + " ";
            } else {
                String first = String.valueOf(Character.toUpperCase(word.charAt(0)));
                String middle = word.substring(1, len - 1);
                String last = String.valueOf(Character.toUpperCase(word.charAt(len - 1)));
                result += first + middle + last + " ";
            }
        }
        return result.trim(); // Remove trailing space
    }
}
/*
Output:
capitalizeFirstAndLastCharacterOfEachWord: HI MY NamE IS SupreetH
capitalizeFirstAndLastCharacterOfEachWordWithoutStringBuilder: HI MY NamE IS SupreetH
 */