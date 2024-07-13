package temp;

import java.util.HashMap;
import java.util.Map;

public class CountFrequencyOfCharactersInString {
    public static void main(String[] args) {
        String str = "Study Tonight";
        int[] freq = new int[str.length()];
        System.out.println("The entered string is " + str);
        //Convert the given string into character array
        char str1[] = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            freq[i] = 1;
            for (int j = i + 1; j < str.length(); j++) {
                if (str1[i] == str1[j]) {
                    freq[i]++;

                    //Set str1[j] to 0 to avoid printing visited character
                    str1[j] = '0';
                }
            }
        }
        //Displays the characters and their corresponding frequency
        System.out.println("Frequencies of the characters in the string are as below: ");
        System.out.println("Characters  frequencies");
        for (int i = 0; i < freq.length; i++) {
            if (str1[i] != ' ' && str1[i] != '0')
                System.out.println(str1[i] + "-" + freq[i]);
        }
        System.out.println("Characters  frequencies with 2nd method");
        getFrequencyOfCharactersInString(str);
        System.out.println("Characters  frequencies with 3rd method");
        characterCount(str);

    }

    //Another easy way to count frequency of characters in a given string
    private static void getFrequencyOfCharactersInString(String str) {
        Map<Character, Integer> map = new HashMap<>();
        str = str.toLowerCase();
        char str1[] = str.toCharArray();
        for(Character c:str1) {
            if(Character.isLetter(c)) {
                map.put(c,map.getOrDefault(c,0)+1);
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
    //Another way
    private static void characterCount(String inputString)
    {
        // Creating a HashMap containing char
        // as a key and occurrences as  a value
        HashMap<Character, Integer> charCountMap
                = new HashMap<Character, Integer>();

        // Converting given string to char array

        char[] strArray = inputString.toCharArray();

        // checking each char of strArray
        for (char c : strArray) {
            if (charCountMap.containsKey(c)) {

                // If char is present in charCountMap,
                // incrementing it's count by 1
                charCountMap.put(c, charCountMap.get(c) + 1);
            }
            else {

                // If char is not present in charCountMap,
                // putting this char to charCountMap with 1 as it's value
                charCountMap.put(c, 1);
            }
        }

        // Printing the charCountMap
        for (Map.Entry entry : charCountMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
