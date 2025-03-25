package Leetcode;

import java.util.HashSet;

public class HappyNumber {
    public static void main(String[] args) {
        int n1 = 19;
        int n2 = 2;

        System.out.println(isHappy(n1)); // Output: true
        System.out.println(isHappy(n2)); // Output: false
    }

    public static boolean isHappy(int n) {
        HashSet<Integer> seenNumbers = new HashSet<>();

        while (n != 1) {
            if (seenNumbers.contains(n)) {
                return false;
            }
            seenNumbers.add(n);
            n = sumOfSquares(n);
        }

        return true; // If we reach 1, the number is happy
    }

    private static int sumOfSquares(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}