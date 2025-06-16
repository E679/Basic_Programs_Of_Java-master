package Leetcode;

import java.util.HashSet;
import java.util.Set;

/*
You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.


Example 1:

Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:

Input: nums = [3,3,7,7,10,11,11]
Output: 10


Constraints:

1 <= nums.length <= 105
0 <= nums[i] <= 105
 */
public class SingleElementInASortedArray {
    //using set or list for this
    public static int singleNonDuplicate(int[] nums) {
        int result = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        for(int num:set){
            result=num;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr={1,1,2,3,3,4,4,8,8};
        int singleNonDuplicate = singleNonDuplicate(arr);
        System.out.println("singleNonDuplicate: "+singleNonDuplicate);
        int singleNonDuplicateAnotherWay = singleNonDuplicateAnotherWay(arr);
        System.out.println("singleNonDuplicateAnotherWay: "+singleNonDuplicateAnotherWay);
    }
    /*
    //Another way
To solve this problem in (O(\log n)) time and (O(1)) space, we can use a binary search approach. Here's the explanation and the code:

Explanation:
Since the array is sorted and every element except one appears twice, the single element disrupts the pairing.
Use binary search to find the single element:
Check the middle index.
If the middle index is even, the pair should start at this index. If the next element is not the same, the single element is on the left.
If the middle index is odd, the pair should end at this index. If the previous element is not the same, the single element is on the left.
Adjust the search range accordingly.
Continue until the single element is found.

This code solves the problem of finding the single non-duplicate element in a sorted array where every other element appears exactly twice. It uses a binary search approach to achieve (O(\log n)) time complexity and (O(1)) space complexity. Here's how it works:

Key Points:
Binary Search:

The array is sorted, and every element except one appears twice. This allows the use of binary search to narrow down the search space.
Logic:

The mid index is calculated as left + (right - left) / 2.
The pairing of elements determines the search direction:
If mid is even, the pair should start at mid. If nums[mid] == nums[mid + 1], the single element is in the right half; otherwise, it's in the left half.
If mid is odd, the pair should end at mid. If nums[mid] == nums[mid - 1], the single element is in the right half; otherwise, it's in the left half.
Termination:

The loop continues until left == right, at which point left points to the single non-duplicate element.
Code Walkthrough:
Initialization:
left starts at 0, and right starts at the last index of the array.
Binary Search Loop:
Calculate mid.
Check the pairing condition based on whether mid is even or odd.
Adjust left or right to narrow the search space.
Return:
When the loop ends, nums[left] is the single non-duplicate element.
Example:
For nums = [1,1,2,3,3,4,4,8,8]:
Initial: left = 0, right = 8.
mid = 4 (even), nums[mid] == nums[mid + 1] is false, so right = mid = 4.
mid = 2 (even), nums[mid] == nums[mid + 1] is false, so right = mid = 2.
mid = 1 (odd), nums[mid] == nums[mid - 1] is true, so left = mid + 1 = 2.
left == right, return nums[left] = 2.
     */
    public static int singleNonDuplicateAnotherWay(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Check if mid is even or odd and adjust the range
            if (mid % 2 == 0) {
                if (nums[mid] == nums[mid + 1]) {
                    left = mid + 2;
                } else {
                    right = mid;
                }
            } else {
                if (nums[mid] == nums[mid - 1]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }

        return nums[left];
    }
}
