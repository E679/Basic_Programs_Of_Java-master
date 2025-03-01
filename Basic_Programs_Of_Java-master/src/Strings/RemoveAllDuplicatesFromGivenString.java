package Strings;

import java.util.*;
import java.util.stream.Collectors;

/*
Example:

Input: Str = geeksforgeeks
Output: geksfor
Explanation: After removing duplicate characters such as e, k, g, s, we have string as “geksfor”.

Input: Str = HappyNewYear
Output: HapyNewYr
Explanation: After removing duplicate characters such as p, e, a, we have string as “HapyNewYr”.
 */
public class RemoveAllDuplicatesFromGivenString {
    static String removeDuplicate(char str[], int n)
    {
        // Used as index in the modified string
        int index = 0;

        // Traverse through all characters
        for (int i = 0; i < n; i++)
        {

            // Check if str[i] is present before it
            int j;
            for (j = 0; j < i; j++)
            {
                if (str[i] == str[j])
                {
                    break;
                }
            }

            // If not present, then add it to
            // result.
            if (j == i)
            {
                str[index++] = str[i];
            }
        }
        return String.valueOf(Arrays.copyOf(str, index));
    }

    // Driver code
    public static void main(String[] args)
    {
        char str[] = "geeksforgeeks".toCharArray();
        int n = str.length;
        System.out.println(removeDuplicate(str, n));
        String str1="geeksforgeeks";
        Set<Character> set=new HashSet<>();
        str1.chars().mapToObj(c->(char)c).filter(x->!set.add(x)).collect(Collectors.toSet());
    }
    //Another way using set
    public static String removeDuplicatesUsingSet(String str) {
        Set<Character> seen = new LinkedHashSet<>();
        StringBuilder result = new StringBuilder();

        for (char ch : str.toCharArray()) {
            if (seen.add(ch)) { // Adds only if not already present
                result.append(ch);
            }
        }

        return result.toString();
    }

}
