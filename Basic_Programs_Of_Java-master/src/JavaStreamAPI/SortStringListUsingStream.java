package JavaStreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
Input: "banana", "apple", "cherry", "date", "grape"
Output: Sorted words: [apple, banana, cherry, date, grape]
 */
public class SortStringListUsingStream {
    public static void main(String[] args) {
        List<String> words= Arrays.asList("banana", "apple", "cherry", "date", "grape");

        List<String> result=words.stream().sorted().collect(Collectors.toList());
        System.out.println("Sorted words: "+result);
    }
}
