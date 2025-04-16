package Strings;

public class vowelConsNonAlphanumneric {
        public static void main(String[] args) {
            System.out.println(countValidWords("This is an example string 234! Word, and code123."));
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


}
