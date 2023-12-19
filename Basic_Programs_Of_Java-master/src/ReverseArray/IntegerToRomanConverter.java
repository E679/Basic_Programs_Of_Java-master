package ReverseArray;

import java.util.ArrayList;
import java.util.List;

public class IntegerToRomanConverter {

    public static String intToRoman(int num) {
        // Define the possible Roman numeral symbols and their corresponding values
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder romanNumeral = new StringBuilder();

        // Iterate through the symbols and append the corresponding Roman numerals
        for (int i = 0; i < symbols.length; i++) {
            while (num >= values[i]) {
                romanNumeral.append(symbols[i]);
                num -= values[i];
            }
        }

        return romanNumeral.toString();
    }

    public static List<String> convertListToRoman(List<Integer> integerList) {
        List<String> romanList = new ArrayList<>();

        for (int num : integerList) {
            String romanNumeral = intToRoman(num);
            romanList.add(romanNumeral);
        }

        return romanList;
    }

    public static void main(String[] args) {
        // Example usage
        List<Integer> integerList = List.of(3, 9, 27, 49, 101);
        List<String> romanList = convertListToRoman(integerList);

        System.out.println("Integer List: " + integerList);
        System.out.println("Roman Numeral List: " + romanList);
    }
}
