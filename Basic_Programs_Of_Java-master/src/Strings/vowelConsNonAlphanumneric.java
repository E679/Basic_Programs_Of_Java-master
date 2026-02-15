package Strings;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Arrays;
public class vowelConsNonAlphanumneric {
    public static void main(String[] args) {
        System.out.println(countValidWords("This is an example string 234! Word, and code123."));
        WordsStartingWithVowels();
    }

    public static int countValidWords(String s) {
        if (s == null || s.trim().isEmpty()) {
            return 0;
        }

        String[] words = s.split("\\s+");
        int count = 0;

        for (String word : words) {
            // Remove non-alphanumeric characters from the start and end
            word = word.replaceAll("^[^a-zA-Z0-9]+|[^a-zA-Z0-9]+$", "");

            if (isValidWord(word)) {
                count++;
            }
        }

        return count;
    }

    public static boolean isValidWord(String word) {
        if (word.length() < 3) {
            return false;
        }

        boolean hasVowel = false;
        boolean hasConsonant = false;

        for (char c : word.toLowerCase().toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                return false; // contains internal non-alphanumeric character
            }

            if (Character.isLetter(c)) {
                if (isVowel(c)) {
                    hasVowel = true;
                } else {
                    hasConsonant = true;
                }
            }
        }

        return hasVowel && hasConsonant;
    }

    public static boolean isVowel(char c) {
        return "aeiou".indexOf(c) >= 0;
    }

    //WordsStartingWithVowels
    public static void WordsStartingWithVowels() {
        List<String> words = Arrays.asList("Apple", "Banana", "Orange", "Grape", "Elephant", "Mango");

        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

        // Method 1: Using filter
        List<String> result = words.stream()
                .filter(word -> vowels.contains(word.charAt(0)))
                .collect(Collectors.toList());

        System.out.println(result); // [Apple, Orange, Elephant]

        // Method 2: Using regex
        List<String> result2 = words.stream()
                .filter(word -> word.matches("^[AEIOUaeiou].*"))
                .collect(Collectors.toList());

        System.out.println(result2); // [Apple, Orange, Elephant]

        // Method 3: Case insensitive
        List<String> result3 = words.stream()
                .filter(word -> "AEIOUaeiou".indexOf(word.charAt(0)) != -1)
                .collect(Collectors.toList());

        System.out.println(result3); // [Apple, Orange, Elephant]
    }


}
