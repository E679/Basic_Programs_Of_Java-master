package CodingChallengesInInterview;
import java.util.Scanner;

/*
Write Java code for below scenario Have the function

SearchingChallenge (str) take the str parameter being passed and find the longest palindromic substring, which means the longest substring which is read the same forwards as it is backwards. For example: if str is "abracecars" then your program should return the string racecar because it is the longest palindrome within the input string.

The input will only contain lowercase alphabetic characters. The longest palindromic substring will always be unique, but if there is none that is longer than 2 characters, return the string none

To solve the problem of finding the longest palindromic substring in a given string str, we can use an approach based on expanding around centers
 */

/*
Explanation:
expandAroundCenter Function:

This function is used to find the length of the palindrome centered at indices left and right.
It expands outwards from these indices as long as characters at left and right are equal and within bounds of the string.
SearchingChallenge Function:

It initializes start and end indices to keep track of the longest palindromic substring found so far.
Iterates through each character of the input string str.
For each character, it checks two cases:
Palindromes with odd length (centered at i).
Palindromes with even length (centered between i and i+1).
Updates start and end indices whenever a longer palindrome is found.
Main Method:

Reads input from the user using Scanner.
Calls SearchingChallenge function with the input string and prints the longest palindromic substring.
Example:
If you input "abracecars", the program will output "racecar" because it is the longest palindromic substring in the input string.

This implementation efficiently finds the longest palindromic substring using an O(n^2) time complexity due to the expansion around centers technique, where n is the length of the input string.
 */
public class searchinglongestSubString {


        public static String SearchingChallenge(String str) {
            if (str == null || str.length() < 1) {
                return "none";
            }

            int start = 0, end = 0;
            for (int i = 0; i < str.length(); i++) {
                // Check for odd length palindromes
                int len1 = expandAroundCenter(str, i, i);
                // Check for even length palindromes
                int len2 = expandAroundCenter(str, i, i + 1);
                // Determine the maximum length palindrome centered at i
                int len = Math.max(len1, len2);
                // Update start and end indices if a longer palindrome is found
                if (len > end - start) {
                    start = i - (len - 1) / 2;
                    end = i + len / 2;
                }
            }

            return str.substring(start, end + 1);
        }

        // Helper function to expand around center
        private static int expandAroundCenter(String s, int left, int right) {
            int L = left, R = right;
            while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
                L--;
                R++;
            }
            return R - L - 1;
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a string: ");
            String input = scanner.nextLine().trim();
            scanner.close();

            System.out.println("Longest palindromic substring: " + SearchingChallenge(input));
        }

}
