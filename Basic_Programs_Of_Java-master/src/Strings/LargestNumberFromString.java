package Strings;

import java.util.*;
import java.util.stream.Collectors;

public class LargestNumberFromString {
    public static void main(String[] args) {
        int[] intArray = {9, 6, 5, 92, 1, 9};

        // Convert int array to a list of strings
        List<String> stringList = Arrays.stream(intArray)
                .mapToObj(String::valueOf)
                .collect(Collectors.toList());

        // Sort strings based on custom comparator
        stringList.sort((a, b) -> (b + a).compareTo(a + b));

        // Use StringBuilder to form the largest number
        StringBuilder largestNumber = new StringBuilder();
        for (String num : stringList) {
            largestNumber.append(num);
        }

        System.out.println("Largest Number: " + largestNumber);

        //Another way
        int[] nums = {3, 30, 34, 5, 9};
        List<String> result = formLargestNumber(nums);
        System.out.println("Sorted List: " + result);

        // Optionally, concatenate the sorted list to form the largest number
        String largestNumber1 = String.join("", result);
        System.out.println("Largest Number: " + largestNumber1);
    }

    //Another way
    public static List<String> formLargestNumber(int[] nums) {
        // Convert the integer array to a list of strings
        List<String> stringList = new ArrayList<>();
        for (int num : nums) {
            stringList.add(String.valueOf(num));
        }

        // Sort the list using a custom comparator
        Collections.sort(stringList, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                // Compare based on concatenated values
                String order1 = a + b;
                String order2 = b + a;
                return order2.compareTo(order1); // Descending order
            }
        });

        return stringList;
    }
}
//output wil be  =  9992651
