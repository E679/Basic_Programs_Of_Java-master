package Strings;

import java.util.*;
import java.util.stream.Collectors;

public class ReverseEachWordsCharactersInString {
    public static void main(String[] args) {
        /*
        1.Reverse each word's character's but the position of the word in string remain unchanged.

        Original String : how to do in Java
        Reversed String : woh ot od ni avaJ
         */

        Scanner scanner = new Scanner(System.in);
        System.out.println("Original String: ");
        String str = scanner.nextLine();
        scanner.close();

        String[] words = str.split("\\s");
        String reversedStr = "";

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String revWord = "";
            for (int j = word.length() - 1; j >= 0; j--) {
                revWord += word.charAt(j);
            }
            reversedStr += revWord + " ";
        }

        System.out.println("Reversed String: " + reversedStr);

        //Another easy way

        reverseWordUsingStringBuilder();
        //Above Scenario using streams
        String reversedStringUsingStreams = getReversedStringUsingStreams(str);
        System.out.println("reversedStringUsingStreams " + reversedStringUsingStreams);
        //Using streams another expected output
        String reversedStringUsingStreamsanotherexpectedoutput = getReversedStringUsingStreamsanotherexpectedoutput(str);
        System.out.println("reversedStringUsingStreamsanotherexpectedoutput" + reversedStringUsingStreamsanotherexpectedoutput);
    }

    private static void reverseWordUsingStringBuilder() {

        System.out.println("Original String: ");
        String str = "how to do in Java";

        String[] words = str.split("\\s+"); // handles multiple spaces
        StringBuilder reversedStr = new StringBuilder();

        for (String word : words) {
            // Reverse each word using StringBuilder
            StringBuilder revWord = new StringBuilder(word);
            reversedStr.append(revWord.reverse()).append(" ");
        }

        // Trim the last space and print
        System.out.println("Reversed String using String Builder: " + reversedStr.toString().trim());
    }

    private static String getReversedStringUsingStreams(String str) {
        String reversedString = Arrays.stream(str.split("\\s")).map(String::toLowerCase).map(w -> new StringBuilder(w).reverse().toString()).collect(Collectors.joining(" "));
        return reversedString;
    }

    private static String getReversedStringUsingStreamsanotherexpectedoutput(String str) {
        //Input: Original String: how to do in Java
        //Output: avaj ni od ot woh
        StringBuilder rev = new StringBuilder();
        String[] words = str.split("\\s");
        Arrays.stream(words).map(String::toLowerCase).map(w -> rev.append(w + " ").toString()).collect(Collectors.joining(" "));
        return rev.reverse().toString();
    }

}
