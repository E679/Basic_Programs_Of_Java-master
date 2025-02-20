package Arrays;

import java.util.Comparator;
import java.util.OptionalInt;
import java.util.Arrays;

public class FindSecondLargestElementInAnArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int secondLargestElementInAnArray = findSecondLargestElementInAnArray(nums);
        System.out.println("secondLargestElementInAnArray: "+secondLargestElementInAnArray);
        int[] numbers = {12, 35, 1, 10, 34, 1};

        // Finding the second largest number using streams
        OptionalInt secondLargest = Arrays.stream(numbers)
                .distinct() // To handle duplicate values
                .boxed()
                .sorted((a, b) -> b - a) // Sort in reverse order
                .skip(1) // Skip the largest number
                .mapToInt(Integer::intValue)
                .findFirst(); // Get the second largest number

        int asInt = Arrays.stream(numbers).distinct().sorted().skip(numbers.length - 2).findFirst().getAsInt();

        // Print result
        if (secondLargest.isPresent()) {
            System.out.println("Second Largest: " + secondLargest.getAsInt());
        } else {
            System.out.println("No second largest number found.");
        }


        // Given a sentence find the word that has the 2nd (Nth) highest length.
        String s = "I am interested123455 to grow in my organization";
        String s1 = Arrays.stream(s.split("\\s")).sorted(Comparator.comparing(String::length).reversed()).skip(1).findFirst().get();
        System.out.println(s1);
    }

    static int findSecondLargestElementInAnArray(int[] nums) {
        int highest=Integer.MIN_VALUE;
        int secondHighest=Integer.MIN_VALUE;
        for (int num:nums) {
            if(num>highest) {
                secondHighest=highest;
                highest = num;
            } else if (num>secondHighest && num!=highest) {
                secondHighest=num;
            }
        }
        return secondHighest;
        /*
        Explanation:
        Initialization: Two variables largest and secondLargest are initialized to Integer.MIN_VALUE to ensure any number in the array will be larger than these values.
        Loop: We loop through the array.
        If the current number is greater than largest, we update secondLargest to be the previous largest, and then set largest to the current number.
        If the number is not greater than largest but is greater than secondLargest, we update secondLargest.
         */
    }
}
