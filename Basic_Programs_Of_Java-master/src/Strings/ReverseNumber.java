package Strings;

import java.util.Arrays;

public class ReverseNumber {
    public static void main(String[] args) {
        int digit = 10;
        int[] result = new int[2];

        for (int i = 0; digit > 0; i++) {
            result[i] = digit % 10; // Extract last digit
            digit /= 10; // Remove last digit
        }

        System.out.println(Arrays.toString(result)); // Output: [0, 1]
    }
}
