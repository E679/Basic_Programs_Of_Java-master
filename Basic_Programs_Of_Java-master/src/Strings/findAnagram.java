package Strings;

import java.util.HashMap;
import java.util.Scanner;
/*
Two strings,  and , are called anagrams if they contain all the same characters in the same frequencies. For this challenge, the test is not case-sensitive. For example, the anagrams of CAT are CAT, ACT, tac, TCA, aTC, and CtA.

Function Description

Complete the isAnagram function in the editor.

isAnagram has the following parameters:

string a: the first string
string b: the second string
Returns

boolean: If  and  are case-insensitive anagrams, return true. Otherwise, return false.
Input Format

The first line contains a string .
The second line contains a string .

Constraints

Strings  and  consist of English alphabetic characters.
The comparison should NOT be case sensitive.

Sample Input 0
anagram
margana

Sample Output 0
Anagrams

Explanation 0

Character	Frequency: anagram	Frequency: margana
A or a	            3	                3
G or g	            1	                1
N or n	            1	                1
M or m	            1	                1
R or r	            1	                1


The two strings contain all the same letters in the same frequencies, so we print "Anagrams".

Sample Input 1
anagramm
marganaa

Sample Output 1
Not Anagrams

Explanation 1

Character	Frequency: anagramm	Frequency: marganaa
A or a	                3	            4
G or g	                1	            1
N or n	                1	            1
M or m	                2	            1
R or r	                1	            1


The two strings don't contain the same number of a's and m's, so we print "Not Anagrams".

Sample Input 2
Hello
hello

Sample Output 2
Anagrams
Explanation 2

Character	Frequency: Hello	Frequency: hello
E or e	            1	                1
H or h	            1	                1
L or l	            2	                2
O or o	            1	                1

The two strings contain all the same letters in the same frequencies, so we print "Anagrams".
 */
public class findAnagram {

    static boolean isAnagram(String a, String b) {
        // Convert both strings to lower case for case-insensitive comparison
        a = a.toLowerCase();
        b = b.toLowerCase();

        // If lengths differ, they cannot be anagrams
        if (a.length() != b.length()) {
            return false;
        }

        // Create a HashMap to count the frequency of characters
        HashMap<Character, Integer> charCount = new HashMap<>();

        // Count frequencies of characters in the first string
        for (char c : a.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Subtract frequencies based on the second string
        for (char c : b.toCharArray()) {
            if (!charCount.containsKey(c)) {
                return false; // Character in b not found in a
            }
            charCount.put(c, charCount.get(c) - 1);
            if (charCount.get(c) < 0) {
                return false; // More occurrences in b than in a
            }
        }

        // All counts should be zero if they are anagrams
        return true;
    }

    static boolean isAnagramOldway(String a, String b) {
        // Complete the function
        if(a.length()!=b.length()){
            return false;
        }

        char[] ch1=a.toLowerCase().toCharArray();
        char[] ch2=b.toLowerCase().toCharArray();

        int[] countarray=new int[26];

        for(char c: ch1){
            countarray[c-'a']++;
        }
        for(char c: ch2){
            countarray[c-'a']--;
        }

        for(int count:countarray){
            if(count!=0){
                return false;
            }
        }


        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println((ret) ? "Anagrams" : "Not Anagrams");
    }
}
