package Strings;


public class CharacterPercentage {
    public static void main(String[] args) {
        String s = "I travelled to Mumbai and reached @ 10:15PM";

        // Initialize counters
        int upperCaseCount = 0;
        int lowerCaseCount = 0;
        int digitCount = 0;
        int specialCharCount = 0;

        // Calculate the total number of characters
        int totalCount = s.length();

        // Iterate through the string
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                upperCaseCount++;
            } else if (Character.isLowerCase(c)) {
                lowerCaseCount++;
            } else if (Character.isDigit(c)) {
                digitCount++;
            } else if (!Character.isWhitespace(c)) {
                specialCharCount++;
            }
        }

        // Calculate percentages
        double upperCasePercentage = (double) upperCaseCount / totalCount * 100;
        double lowerCasePercentage = (double) lowerCaseCount / totalCount * 100;
        double digitPercentage = (double) digitCount / totalCount * 100;
        double specialCharPercentage = (double) specialCharCount / totalCount * 100;

        // Print the results
        System.out.printf("Uppercase Letters: %d (%.2f%%)\n", upperCaseCount, upperCasePercentage);
        System.out.printf("Lowercase Letters: %d (%.2f%%)\n", lowerCaseCount, lowerCasePercentage);
        System.out.printf("Digits: %d (%.2f%%)\n", digitCount, digitPercentage);
        System.out.printf("Special Characters: %d (%.2f%%)\n", specialCharCount, specialCharPercentage);
    }
}

