package Leetcode;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

Example 1:
Input: s = "leetcode"
Output: 0
Explanation:
The character 'l' at index 0 is the first character that does not occur at any other index.
Example 2:
Input: s = "loveleetcode"
Output: 2
Example 3:
Input: s = "aabb"
Output: -1
 */
public class FindFirstUniqueCharacterIndexInAString {
    public static void main(String[] args) {
        int firstUniqCharIndex = firstUniqChar("leetcode");
        System.out.println("firstUniqCharIndex: "+firstUniqCharIndex);
    }
    public static int firstUniqChar(String s) {
        Map<Character, Long> charCountMap = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Optional<Integer> firstUniqueCharIndex = s.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> charCountMap.get(c) == 1)
                .findFirst()
                .map(c -> s.indexOf(c));
        return firstUniqueCharIndex.orElse(-1);
    }
}
