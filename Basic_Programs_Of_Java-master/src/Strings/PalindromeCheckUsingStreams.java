package Strings;

import java.util.stream.IntStream;

public class PalindromeCheckUsingStreams {
    public static void main(String[] args) {
        System.out.println(isPalindrome("madam") ? "Palindrome" : "Not Palindrome");
    }
    private static boolean isPalindrome(String s){
        if(s.length()<=1) return false;

        boolean isPalindrome = IntStream.range(0, s.length() / 2).
                allMatch(i -> s.charAt(i) == s.charAt(s.length() - i - 1));
        return isPalindrome;
    }
}
