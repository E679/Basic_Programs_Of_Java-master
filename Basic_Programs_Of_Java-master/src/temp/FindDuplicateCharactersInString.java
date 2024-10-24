package temp;

import java.util.Map;
import java.util.HashMap;

public class FindDuplicateCharactersInString {
    public static void main(String[] args) {
        String str = "Maximum and Minimum";
        int count = 0;
        System.out.println("Entered String is: " + str);

        char[] str1 = str.toCharArray();

        System.out.println("Duplicates in String are: ");
        for (int i = 0; i < str1.length; i++) {
            count = 1;
            for (int j = i + 1; j < str1.length; j++) {
                if (str1[i] == str1[j] && str1[i] != ' ') {
                    count++;
                    str1[j] = '0';
                }
            }
            if (count > 1 && str1[i] != '0') {
                System.out.print(" " + str1[i]);
            }
        }

        System.out.println("\n"+checkVowelIsPresentOrNot("hello"));
        System.out.println(checkVowelIsPresentOrNot("tv"));
    }

    private static boolean checkVowelIsPresentOrNot(String str) {
        return str.toLowerCase().matches(".*[aeiou].*");
    }

    public Map<String, Integer> countVowelsAndConsonants(String str) {
        Map<String, Integer> count = new HashMap<>();
        int vowels = 0, consonants = 0;

        for (char c : str.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                if ("aeiou".indexOf(c) != -1) {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        count.put("vowels", vowels);
        count.put("consonants", consonants);
        return count;
    }


}
