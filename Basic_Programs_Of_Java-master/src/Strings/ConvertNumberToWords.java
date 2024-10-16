package Strings;

import java.util.HashMap;
import java.util.Scanner;

public class ConvertNumberToWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: an integer
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();

        // Convert number to words
        String result = convertNumberToWords(number);

        // Output the result
        System.out.println(result);

        scanner.close();
    }

    public static String convertNumberToWords(int number) {
        StringBuilder result = new StringBuilder();

        // Convert integer to string to process each digit
        String numberString = Integer.toString(number);

        // Map digits to words
        String[] words = {"zero", "one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine"};

        // Iterate through each character in the string
        for (char digit : numberString.toCharArray()) {
            // Convert character to integer
            int digitValue = Character.getNumericValue(digit);
            // Append corresponding word to result
            result.append(words[digitValue]);
        }

        return result.toString();
    }
    public static String convertNumberToWordsusingHashMap(int number) {
        StringBuilder result = new StringBuilder();

        // Convert integer to string to process each digit
        String numberString = Integer.toString(number);

        // Map digits to words using HashMap
        HashMap<Character, String> digitToWordMap = new HashMap<>();
        digitToWordMap.put('0', "zero");
        digitToWordMap.put('1', "one");
        digitToWordMap.put('2', "two");
        digitToWordMap.put('3', "three");
        digitToWordMap.put('4', "four");
        digitToWordMap.put('5', "five");
        digitToWordMap.put('6', "six");
        digitToWordMap.put('7', "seven");
        digitToWordMap.put('8', "eight");
        digitToWordMap.put('9', "nine");

        // Iterate through each character in the string
        for (char digit : numberString.toCharArray()) {
            // Append corresponding word to result using HashMap
            result.append(digitToWordMap.get(digit));
        }

        return result.toString();
    }
}

