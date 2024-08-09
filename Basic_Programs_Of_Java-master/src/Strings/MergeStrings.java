package Strings;

public class MergeStrings {
    public static void main(String[] args) {
        //Leet code Problem
        /*
        You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.

Return the merged string.



Example 1:

Input: word1 = "abc", word2 = "pqr"
Output: "apbqcr"
Explanation: The merged string will be merged as so:
word1:  a   b   c
word2:    p   q   r
merged: a p b q c r
Example 2:

Input: word1 = "ab", word2 = "pqrs"
Output: "apbqrs"
Explanation: Notice that as word2 is longer, "rs" is appended to the end.
word1:  a   b
word2:    p   q   r   s
merged: a p b q   r   s
Example 3:

Input: word1 = "abcd", word2 = "pq"
Output: "apbqcd"
Explanation: Notice that as word1 is longer, "cd" is appended to the end.
word1:  a   b   c   d
word2:    p   q
merged: a p b q c   d

         */
        String res = mergeAlternately("abc", "pqr");
        System.out.println("Merged string is Scenario 1 :" + res);
        String res1 = mergeAlternately("ab", "pqrs");
        System.out.println("Merged string is Scenario 2 :" + res1);
        String res2 = mergeAlternately("abcd", "pq");
        System.out.println("Merged string is Scenario 3 :" + res2);
    }

    public static String mergeAlternately(String word1, String word2) {
        String res = "";
        if (word1.length() == word2.length()) {
            for (int i = 0; i < word1.length(); i++) {
                res += word1.charAt(i);
                res += word2.charAt(i);
            }
        } else if (word1.length() < word2.length()) {
            for (int i = 0; i < word1.length(); i++) {
                res += word1.charAt(i);
                res += word2.charAt(i);
            }
            for (int i=word1.length();i<word2.length();i++) {
                res+=word2.charAt(i);
            }
        } else if (word1.length() > word2.length()) {
            for (int i = 0; i < word2.length(); i++) {
                res += word1.charAt(i);
                res += word2.charAt(i);
            }
            for (int i=word2.length();i<word1.length();i++) {
                res+=word1.charAt(i);
            }
        }

        return res;

    }
}
