package Strings;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class FindNumbersStartingWith1 {
    public static void main(String[] args) {
        String s="123 456 178 190 1234";
        int count = getNumbersStartingWith1(s);
        System.out.println("count: "+count);
        List<Integer> numbers = Arrays.asList(11, 18, 20, 24, 85, 66, 13);

        // Method 1: Convert to String and check
        List<Integer> result = numbers.stream()
                .filter(n -> String.valueOf(n).startsWith("1"))
                .collect(Collectors.toList());

        System.out.println(result); // Output: [11, 18, 13]

        // Method 2: Using map and filter
        numbers.stream()
                .map(String::valueOf)
                .filter(s1 -> s1.startsWith("1"))
                .forEach(System.out::println);
    }

    private static int getNumbersStartingWith1(String s) {
        String[] split = s.split("\\s");
        int count=0;
        for (String str:split){
            if(str.startsWith("1")){
                count++;
            }
        }
        return count;
    }
}
