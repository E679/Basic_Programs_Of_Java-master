package Leetcode;

import java.util.Scanner;

/*
To solve this problem, we need to implement the `longestDecreasingSubstring` method to find the length of the longest substring in the input string `s` that is in reverse alphabetical order.
Explanation:
- We initialize `maxLength` to keep track of the maximum length found so far and `currentLength` to track the length of the current decreasing substring.
- We iterate through the string `s`. If the current character is less than the previous one (meaning it's in reverse alphabetical order), we increment `currentLength`.
- If the current character is not less than the previous one, we update `maxLength` if `currentLength` is greater, and reset `currentLength` to 1.
- After the loop, we do one final check to update `maxLength` in case the longest decreasing substring ended at the end of the string.
 */
public class longestDecreasingSubstring {
    static int longestDecreasingSubstring(String s){
        int maxLength = 0;
        int currentLength = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) <= s.charAt(i-1)) {
                currentLength++;
            } else {
                maxLength = Math.max(maxLength, currentLength);
                currentLength = 1;
            }
        }
        return Math.max(maxLength, currentLength);
    }

    public static void main(String[] args){
        System.out.println(longestDecreasingSubstring("BBAASSSRPPOCCBAAACBABA"));//OUTPUT: 13
        /*
        EXPLANATION:
        String s="BBAASSSRPPOCCBAAACBABA" reverse alphabetical strings are BBAA,SSSRPPOCCBAAA,CBA and BA
        longest is SSSRPPOCCBAAA and it's length is 13. Hence OUTPUT is 13
         */
        System.out.println(longestDecreasingSubstring("hjgAvjhjKLhbfvbZSF"));//OUTPUT: 5
        /*
        EXPLANATION:
        String s="hjgAvjhjKLhbfvbZSF" reverse alphabetical strings are gA,vjh,jK,hb and vbZSF
        longest is vbZSF and it's length is 5. Hence OUTPUT is 5
         */
    }
}
