package Strings;

import java.util.Arrays;

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
    }

}

