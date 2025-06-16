package Leetcode;

public class MergeStrings {
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
    public static void main(String[] args) {
        String res = mergeAlternately("abc", "pqr");
        System.out.println("Merged string is Scenario 1 :" + res);
        String res1 = mergeAlternately("ab", "pqrs");
        System.out.println("Merged string is Scenario 2 :" + res1);
        String res2 = mergeAlternately("abcd", "pq");
        System.out.println("Merged string is Scenario 3 :" + res2);
    }

    public static String mergeAlternately(String word1, String word2) {
        int len1=word1.length();
        int len2=word2.length();
        int len=Math.max(len1,len2);
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (i<len1){
                sb.append(word1.charAt(i));
            }
            if (i<len2){
                sb.append(word2.charAt(i));
            }
        }
        return sb.toString();
    }
}
