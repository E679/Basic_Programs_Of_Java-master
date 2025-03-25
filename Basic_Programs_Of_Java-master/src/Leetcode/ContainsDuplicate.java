package Leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (!seen.add(num)) { // If add() returns false, a duplicate is found
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1};
        int[] nums2 = {1, 2, 3, 4};
        int[] nums3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};

        System.out.println(containsDuplicate(nums1)); // Output: true
        System.out.println(containsDuplicate(nums2)); // Output: false
        System.out.println(containsDuplicate(nums3)); // Output: true
        //Using java8 streams
        System.out.println(containsDuplicateUsingStreams(nums3)); // Output: true
    }

    private static boolean containsDuplicateUsingStreams(int[] nums) {
        Set<Integer> collect = Arrays.stream(nums).mapToObj(x -> x).collect(Collectors.toSet());
        return collect.size()<nums.length;
    }
}

