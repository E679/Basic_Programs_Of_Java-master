package temp;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FindTheMinimumAndMaximumOccurringCharacter {
    public static void main(String[] args)
    {
        //Take input from the user
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the string: ");
        String str=sc.nextLine();
        int[] freq = new int[str.length()];
        char minChar = str.charAt(0), maxChar = str.charAt(0);
        int i, j, min, max;
        char string[] = str.toCharArray();
        for(i = 0; i < string.length; i++)
        {
            freq[i] = 1;
            for(j = i+1; j < string.length; j++)
            {
                if(string[i] == string[j] && string[i] != ' ' && string[i] != '0')
                {
                    freq[i]++;

                    string[j] = '0';
                }
            }
        }
        min = max = freq[0];
        for(i = 0; i <freq.length; i++)
        {
            if(min > freq[i] && freq[i] != '0')
            {
                min = freq[i];
                minChar = string[i];
            }
            if(max < freq[i])
            {
                max = freq[i];
                maxChar = string[i];
            }
        }
        System.out.println("Minimum occurring character: " + minChar);
        System.out.println("Maximum occurring character: " + maxChar);

        //Another way to find maximum occurence of a character in a String
        String s = "geeksforgeeks";
        int count = 0;

        char c1 = s.charAt(0);
        HashMap<Character, Integer> charMap = new HashMap<>();

        for (Character c : s.toCharArray()) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> c : charMap.entrySet()) {
            if (c.getValue() > count) {
                count = c.getValue();
                c1 = c.getKey();
            }
        }
        System.out.println("Maximum Occured Character in " + s + " is " + c1);
        Character mostFrequentChar = s.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, Collectors.counting())).entrySet().stream()
                .max(Map.Entry.comparingByValue()) // Find the entry with the maximum value
                .map(Map.Entry::getKey) // Get the character with the highest count
                .orElse('\0'); // Default in case of empty string

        System.out.println("Most frequent character using streams is : " + mostFrequentChar);
        //Count the occurences of a character in a string
        String s1 = "geeksforgeeks";
        char ch1 = 'e';
        int charcount = 0;
        for (char c : s1.toCharArray()) {
            if (c == ch1) charcount++;
        }
        System.out.println("Count the occurences of a character in " + s1 + " is " + charcount);

        //Count occurrences of the character using streams
        String s11 = "geeksforgeeks";
        char ch11 = 'e';

        long charCount = s11.chars()
                .filter(c -> c == ch11) // Filter the characters matching 'ch1'
                .count(); // Count the occurrences

        System.out.println("Count of '" + ch1 + "' in the string Using Streams is: " + charCount);
    }
}
