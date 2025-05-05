package Leetcode;

import java.util.Arrays;

/*
Input: nums = [-4, -1, 0, 3, 10]
Output: [0, 1, 9, 16, 100]

Key Points:
Time Complexity: O(n)
Space Complexity: O(n) (excluding output)
Uses a two-pointer approach from both ends.
 */
public class squaresOfSortedArray {
    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        int[] result = sortedSquares(nums);
//        for (int i : result) {
//            System.out.print(i);
//        }
        System.out.println(Arrays.toString(result));
    }
    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;
        int pos = n - 1;

        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if (leftSquare > rightSquare) {
                result[pos] = leftSquare;
                left++;
            } else {
                result[pos] = rightSquare;
                right--;
            }
            pos--;
        }

        return result;
    }
}
