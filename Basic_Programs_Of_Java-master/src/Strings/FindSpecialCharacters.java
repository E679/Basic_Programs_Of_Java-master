package Strings;

import java.util.*;
import java.util.stream.*;
public class FindSpecialCharacters {
    public static void main(String[] args) {
        String str = "Hello@World#2024!";

        // Method 1: Using Stream
        List<Character> specialChars = str.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> !Character.isLetterOrDigit(c))
                .collect(Collectors.toList());

        System.out.println("Special Characters: " + specialChars);
        // [@, #, !]

        // Method 2: Count special characters
        long count = str.chars()
                .filter(c -> !Character.isLetterOrDigit(c) && !Character.isWhitespace(c))
                .count();

        System.out.println("Count: " + count); // 3

        // Method 3: Using regex
        String specialCharsOnly = str.replaceAll("[a-zA-Z0-9]", "");
        System.out.println("Special Chars: " + specialCharsOnly); // @#!
    }
}
