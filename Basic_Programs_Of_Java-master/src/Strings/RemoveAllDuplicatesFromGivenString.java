package Strings;

import java.util.*;
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
    }
}
