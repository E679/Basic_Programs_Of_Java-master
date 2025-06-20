package Leetcode;

/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

Example 1:
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 2:
Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.
 */
public class HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int prev1 = 0; // max loot excluding previous house
        int prev2 = 0; // max loot including previous house

        for (int num : nums) {
            int temp = prev1;
            prev1 = Math.max(prev2 + num, prev1); // max if we rob current or skip it
            prev2 = temp;
        }

        return prev1;
    }

    public static void main(String[] args) {
        HouseRobber hr = new HouseRobber();

        int[] nums1 = {1, 2, 3, 1};
        System.out.println("Max loot: " + hr.rob(nums1)); // Output: 4

        int[] nums2 = {2, 7, 9, 3, 1};
        System.out.println("Max loot: " + hr.rob(nums2)); // Output: 12
    }
}
