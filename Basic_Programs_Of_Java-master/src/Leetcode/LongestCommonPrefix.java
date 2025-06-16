package Leetcode;

import java.util.Arrays;

/*
Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".

Example 1:

Plain Text
Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:

Plain Text
Input: strs = ["dog","racecar","car"]
Output: ""Explanation: There is no common prefix among the input strings.

 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs={"flower","flow","flight"};
        String longestCommonPrefix = longestCommonPrefix(strs);
        System.out.println("longestCommonPrefix: "+longestCommonPrefix);
        String[] strs1={"dog","racecar","car"};
        String longestCommonPrefix1 = longestCommonPrefix(strs1);
        System.out.println("longestCommonPrefix: "+longestCommonPrefix1);
    }
    public static String longestCommonPrefix(String[] strs) {
        //Sorting array because if we sort then 1st string and last string may have same common prefix
        StringBuilder sb = new StringBuilder();
        Arrays.sort(strs);
        char[] first = strs[0].toCharArray();
        char[] last = strs[strs.length - 1].toCharArray();

        for (int i = 0; i < first.length; i++) {
            if (first[i] != last[i]) {
                break;
            }
            sb.append(first[i]);
        }
        return sb.toString();
    }
    //Another Way
    public static String longestCommonPrefix1(String[] strs) {
        //Sorting array because if we sort then 1st string and last string may have same common prefix
        Arrays.sort(strs);
        String s1=strs[0];
        String s2=strs[strs.length-1];
        int index=0;
        while(index<s1.length()){
            if(s1.charAt(index)==s2.charAt(index)){
                index++;
            } else{
                break;
            }
        }
        return index==0?"":s1.substring(0,index);
    }
}
