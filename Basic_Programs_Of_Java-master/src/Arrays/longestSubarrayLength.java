package Arrays;

// Java program to find the length of the longest
// subarray having sum k using nested loop
//Longest Subarray With Sum K
/*
Given an array arr[] of size n containing integers, the task is to find the length of the longest subarray having sum equal to the given value k.

Note: If there is no subarray with sum equal to k, return 0.

Examples:

Input: arr[] = [10, 5, 2, 7, 1, -10], k = 15
Output: 6
Explanation: Subarrays with sum = 15 are [5, 2, 7, 1], [10, 5] and [10, 5, 2, 7, 1, -10]. The length of the longest subarray with a sum of 15 is 6.

Input: arr[] = [-5, 8, -14, 2, 4, 12], k = -5
Output: 5
Explanation: Only subarray with sum = 15 is [-5, 8, -14, 2, 4] of length 5.

Input: arr[] = [10, -10, 20, 30], k = 5
Output: 0
Explanation: No subarray with sum = 5 is present in arr[].
 */
public class longestSubarrayLength {
    // Function to find longest sub-array having sum k
    static int longestSubarray(int[] arr, int k) {
        int res = 0;

        for (int i = 0; i < arr.length; i++) {

            // Sum of subarray from i to j
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];

                // If subarray sum is equal to k
                if (sum == k) {

                    // find subarray length and update result
                    int subLen = j - i + 1;
                    res = Math.max(res, subLen);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 7, 1, -10};
        int k = 15;
        System.out.println(longestSubarray(arr, k));
    }
}
