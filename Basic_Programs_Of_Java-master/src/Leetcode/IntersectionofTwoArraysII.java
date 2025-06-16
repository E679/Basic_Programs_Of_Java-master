package Leetcode;

import java.util.*;

/*
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

Example 1:

Plain Text
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]

Example 2:

Plain Text
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]Explanation: [9,4] is also accepted.

 */
public class IntersectionofTwoArraysII {
    public static void main(String[] args) {
        int[] nums1={1,2,2,1};
        int[] nums2={2,2};
        int[] intersect = intersect(nums1, nums2);
        System.out.println("intersection: "+ Arrays.toString(intersect));//[2, 2]
    }
    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length)
            return intersect(nums2, nums1);

        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> count = new HashMap<>();

        for (final int num : nums1)
            count.put(num, count.getOrDefault(num, 0) + 1);

        for (final int num : nums2)
            if (count.containsKey(num) && count.get(num) > 0) {
                ans.add(num);
                count.put(num, count.get(num) - 1);
            }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
