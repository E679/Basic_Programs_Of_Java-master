package Leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.

You are given an integer array nums representing the data status of this set after the error.

Find the number that occurs twice and the number that is missing and return them in the form of an array.

Example 1:

Input: nums = [1,2,2,4]
Output: [2,3]
Example 2:

Input: nums = [1,1]
Output: [1,2]
 */
public class SetMismatch {
    public static void main(String[] args) {
        int[] errorNums = findErrorNums(new int[]{1, 1});
        System.out.print(Arrays.toString(errorNums));
    }

    public static int[] findErrorNums(int[] nums) {
        /*
        To solve this
        1. Remove duplicates to find missing number
        2. Find number that occurred twice
        3. Add to int array
         */
        int sum = 0;
        int len = nums.length;
        int total = len * (len + 1) / 2;
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }

        for (Integer s : set) {
            sum += s;
        }
        res += total - sum;

        Integer numberOccuredTwice = Arrays.stream(nums).mapToObj(i -> i).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).map(e -> e.getKey()).get();

        return new int[]{numberOccuredTwice, res};
    }
}
