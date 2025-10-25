package Leetcode;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.Arrays;

/*
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and using only constant extra space.



Example 1:

Input: nums = [1,3,4,2,2]
Output: 2
Example 2:

Input: nums = [3,1,3,4,2]
Output: 3
Example 3:

Input: nums = [3,3,3,3,3]
Output: 3
 */
public class FindDuplicateNumber {
    public static void main(String[] args) {
        int duplicate = findDuplicate(new int[]{1, 3, 4, 2, 2});
        System.out.println("duplicate "+duplicate);
        int duplicate1 = findDuplicate(new int[]{3,1,3,4,2});
        System.out.println("duplicate "+duplicate1);
    }
    public static int findDuplicate(int[] nums) {
        return Arrays.stream(nums).mapToObj(i -> i).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).map(e -> e.getKey()).get();
    }
}
