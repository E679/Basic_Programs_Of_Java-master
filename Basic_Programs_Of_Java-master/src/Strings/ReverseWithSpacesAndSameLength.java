package Strings;

import java.util.ArrayList;
import java.util.List;

public class ReverseWithSpacesAndSameLength {
    public static void main(String[] args) {
        String input = "my name is supreeth";
        String result = reversePreserveSpaces(input);
        System.out.println(result); // Output: oc tics ie siemanym
        String s = reversePreservingFormat(input);
        System.out.println(s);
        String s1 = reversePreservingFormat("a-bC-dEf-ghIj");
        System.out.println(s1.equals("j-Ih-gfE-dCba"));
        String s2 = reversePreservingFormat2(input);
        //System.out.println(s2.equals("ht eerp us siemanym"));
    }

    public static String reversePreserveSpaces(String input) {
        char[] inputArr = input.toCharArray();
        char[] result = new char[inputArr.length];

        // Step 1: Mark space positions in result
        for (int i = 0; i < inputArr.length; i++) {
            if (inputArr[i] == ' ') {
                result[i] = ' ';
            }
        }

        // Step 2: Reverse the characters (ignoring spaces)
        int j = inputArr.length - 1;
        for (int i = 0; i < inputArr.length; i++) {
            if (inputArr[i] != ' ') {
                if (result[j] == ' ') {
                    j--;
                }
                result[j] = inputArr[i];
                j--;
            }
        }

        return new String(result);
    }

    //Another way
    public static String reversePreservingFormat(String input) {
        List<Character> letters = new ArrayList<>();

        // Step 1: Collect all letters from the string
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                letters.add(c);
            }
        }

        // Step 2: Create result by replacing letters in reverse order, skipping non-letters
        StringBuilder result = new StringBuilder();

        int letterIndex = letters.size() - 1;
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                result.append(letters.get(letterIndex--));
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
    //Easy Way Using Two Pointer Approach
    private static String reversePreservingFormat2(String s) {
        //String s = "my name is supreeth";
//Output: ht eerp us siemanym
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            if (!Character.isLetter(chars[left])) {
                left++;
            } else if (!Character.isLetter(chars[right])) {
                right--;
            } else {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++; right--;
            }
        }
        String res = new String(chars);
        System.out.println(res);
        System.out.println(res.equalsIgnoreCase("ht eerp us siemanym"));
        return res;
    }
}

