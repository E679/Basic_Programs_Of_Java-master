package Leetcode;

public class findTwoSumInputArraySorted {
    public int[] findTwoSum(int[] numbers, int target) {
        int left = 0;              // Initialize the first pointer at the beginning of the array
        int right = numbers.length - 1; // Initialize the second pointer at the end of the array

        while (left < right) {     // Loop until the two pointers meet
            int sum = numbers[left] + numbers[right]; // Calculate the sum of the two pointed elements

            if (sum == target) {   // If the sum equals the target, return the indices (1-based)
                return new int[]{left + 1, right + 1};
            } else if (sum < target) { // If the sum is less than the target, move the left pointer forward
                left++;
            } else {               // If the sum is greater than the target, move the right pointer backward
                right--;
            }
        }
        return new int[]{-1, -1}; // This will never be reached due to the problem guarantee of one solution
    }

    public static void main(String[] args) {
        findTwoSumInputArraySorted twoSum = new findTwoSumInputArraySorted();
        int[] numbers = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum.findTwoSum(numbers, target);
        System.out.println("Indices: " + result[0] + ", " + result[1]);
    }
}
/*
Example 1:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
Example 2:

Input: numbers = [2,3,4], target = 6
Output: [1,3]
Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
Example 3:

Input: numbers = [-1,0], target = -1
Output: [1,2]
Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].


### Explanation:
1. **Input**: A sorted array `numbers` and a target sum `target`.
2. **Output**: An array containing the 1-based indices of the two elements that add up to `target`.

### Algorithm:
- **Two-Pointer Technique**:
    - Use two pointers, `left` initialized at the start of the array and `right` initialized at the end.
    - Compute the sum of the elements pointed to by `left` and `right`.
    - If the sum equals the target, return the indices incremented by 1 (1-based indexing).
    - If the sum is less than the target, increment `left` to increase the sum.
    - If the sum is greater than the target, decrement `right` to decrease the sum.

### Complexity:
- **Time Complexity**: `O(n)` since we traverse the array at most once.
- **Space Complexity**: `O(1)` since no additional space is used except for the pointers.

 */

