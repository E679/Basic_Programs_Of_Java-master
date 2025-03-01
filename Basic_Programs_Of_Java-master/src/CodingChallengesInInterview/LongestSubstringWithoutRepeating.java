package CodingChallengesInInterview;

import java.util.HashSet;

public class LongestSubstringWithoutRepeating {
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>(); // To store unique characters
        int maxLength = 0; // To keep track of the maximum length
        int left = 0; // Left pointer of the sliding window

        for (int right = 0; right < s.length(); right++) {
            // If we encounter a duplicate character, move the left pointer
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            // Add the current character to the set
            set.add(s.charAt(right));

            // Update the maximum length
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String input = "abcabcbb";
        System.out.println("Length of the longest substring without repeating characters: " + lengthOfLongestSubstring(input));

        input = "bbbbb";
        System.out.println("Length of the longest substring without repeating characters: " + lengthOfLongestSubstring(input));

        input = "pwwkew";
        System.out.println("Length of the longest substring without repeating characters: " + lengthOfLongestSubstring(input));
    }
}

/*
### Explanation of the Code:
1. **Logic**:
    - Use two pointers (`left` and `right`) to form a sliding window.
    - Traverse the string with the `right` pointer. For each character:
        - If it's already in the `HashSet`, it means there is a duplicate, so remove characters from the `left` pointer until the duplicate is gone.
        - Add the current character to the `HashSet`.
        - Calculate the window length (`right - left + 1`) and update `maxLength` if the new window is longer.

2. **HashSet**:
    - The `HashSet` ensures that all characters in the current window are unique.
    - It's efficient for checking duplicates and removing elements.

3. **Output for Example Inputs**:
    - Input: `"abcabcbb"` → Output: `3` (The longest substring is `"abc"`).
    - Input: `"bbbbb"` → Output: `1` (The longest substring is `"b"`).
    - Input: `"pwwkew"` → Output: `3` (The longest substring is `"wke"`).

4. **Time Complexity**:
    - The `right` pointer traverses the string once in O(n).
    - The `left` pointer also traverses the string at most once, as elements are removed from the `HashSet`.
    - Overall time complexity: **O(n)**.

5. **Space Complexity**:
    - The `HashSet` can store at most all unique characters of the input string. For a string of length `n` with all distinct characters, space complexity is **O(n)**.

 */
