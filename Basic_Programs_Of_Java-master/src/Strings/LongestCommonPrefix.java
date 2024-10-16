package Strings;

import java.util.Arrays;
import java.util.Scanner;

/*
       Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".
Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""
        */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Start with the first string as the prefix
        String prefix = strs[0];

        // Compare the prefix with each string in the array
        for (int i = 1; i < strs.length; i++) {
            // Reduce the prefix until it matches the beginning of strs[i]
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }

    public static void main(String[] args) {
        String[] example1 = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(example1)); // Output: "fl"

        String[] example2 = {"dog", "racecar", "car"};
        System.out.println(longestCommonPrefix(example2)); // Output: ""


        //Below logic I have Written in interview
        String[] strs = {"dog","racecar","car"};
        String result="";

        for(int i=0;i< strs.length-1;i++){
            Arrays.sort(strs);

            char[] charArray1 = strs[i].toCharArray();
            char[] charArray2 = strs[i+1].toCharArray();

            String s1 = String.valueOf(charArray1[i]);
            String s2 = String.valueOf(charArray2[i]);

            if((s1.equalsIgnoreCase(s2))){
                result+=charArray1[i];
            }
        }
        System.out.println("Ouptut prefix: "+result);

        /*
        Example 1:

Input: word = "abcdefd", ch = "d"
Output: "dcbaefd"
Explanation: The first occurrence of "d" is at index 3.
Reverse the part of word from 0 to 3 (inclusive), the resulting string is "dcbaefd".

Example 2:

Input: word = "xyxzxe", ch = "z"
Output: "zxyxxe"
Explanation: The first and only occurrence of "z" is at index 3.
Reverse the part of word from 0 to 3 (inclusive), the resulting string is "zxyxxe".

Example 3:

Input: word = "abcd", ch = "z"
Output: "abcd"
Explanation: "z" does not exist in word.
You should not do any reverse operation, the resulting string is "abcd".
         */
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter word");
        String word=sc.nextLine();
        System.out.println("Enter char");
        char ch=sc.next().charAt(0);
        System.out.println("result is : "+reversePrefix(word,ch));
    }

    public static String reversePrefix(String word, char ch) {
        if(!(word.contains(Character.toString(ch)))){
            return word;
        }
        Character c1 = word.chars().mapToObj(c -> (char) c).filter(c->c==ch).findFirst().get();
        String substring = word.substring(0, word.indexOf(c1)+1);
        String reversedSubstring=new StringBuilder(substring).reverse().toString();
        String rest=word.substring(reversedSubstring.length(),word.length());
        return reversedSubstring+rest;
    }

}

