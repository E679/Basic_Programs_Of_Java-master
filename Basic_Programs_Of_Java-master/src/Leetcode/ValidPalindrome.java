package Leetcode;

import java.util.stream.Collectors;

/*
Example 1:
Input: s = "A man, a plan, a canal: Panama"Output: trueExplanation: "amanaplanacanalpanama" is a palindrome.
Example 2:
Input: s = "race a car"Output: falseExplanation: "raceacar" is not a palindrome.
Example 3:
Input: s = " "Output: trueExplanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.

 */
public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        if(s.isEmpty()|| s.isBlank() || s==null){
            return true;
        }
        char[] charArray = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : charArray) {
            if(Character.isLetterOrDigit(c)){
                sb.append(c);
            }
        }
        String letters = sb.toString().toLowerCase();
        String rev=sb.reverse().toString();
        return letters.equalsIgnoreCase(rev);
    }
    //Using Streams
    public static boolean isPalindromes(String s) {
        String collect = s.chars().mapToObj(c -> (char) c).filter(Character::isLetterOrDigit).map(String::valueOf)
                .collect(Collectors.joining());
        String collect1 = new StringBuilder(collect).reverse().toString();
        return collect.equalsIgnoreCase(collect1);
    }

    public static void main(String[] args) {
        boolean palindrome = isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(palindrome);// Output: true
        boolean palindrome2 = isPalindrome("race a car");
        System.out.println(palindrome2);// Output: false
        boolean palindrome3 = isPalindrome(" ");
        System.out.println(palindrome3);// Output: true
        boolean ispalindrome4=isPalindromes(" ");
        System.out.println(ispalindrome4);//true
    }
}
