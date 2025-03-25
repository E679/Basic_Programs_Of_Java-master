package Leetcode;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        merge(nums1, m, nums2, n);

        System.out.println("Merged Array: " + Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // Pointers for nums1 and nums2
        int p1 = m - 1; // Last element in the non-zero portion of nums1
        int p2 = n - 1; // Last element in nums2
        int p = m + n - 1; // Last position in nums1 (including zeros)

        // Merge nums1 and nums2 from the back
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }

        // If there are remaining elements in nums2, copy them over
        while (p2 >= 0) {
            nums1[p] = nums2[p2];
            p2--;
            p--;
        }
        // Note: No need to handle remaining elements in nums1 as they are already in place
    }
}
/*
OUTPUT: Merged Array: [1, 2, 2, 3, 5, 6]

### Explanation:
1. **Two-pointer approach**:
    - Use two pointers:
        - `p1` starts at the end of the meaningful elements in `nums1` (`m - 1`).
        - `p2` starts at the end of `nums2` (`n - 1`).

    - Place the largest of the two values from `nums1[p1]` and `nums2[p2]` at the current position `p` (`m + n - 1`, starting at the end of `nums1`).

2. **Why merge from the back?**
    - If we start merging from the front, we would overwrite elements from `nums1` before they are compared.
    - Starting from the back ensures that there’s always empty space at the end of `nums1` to accommodate elements.

3. **Handling leftover elements**:
    - If there are any elements left in `nums2` (when `p2 >= 0`), copy them into `nums1`.
    - If there are leftover elements in `nums1` (when `p1 >= 0`), they are already in place, so no action is needed.

### Time Complexity:
- **O(m + n)**: Each element in `nums1` and `nums2` is processed exactly once.

### Space Complexity:
- **O(1)**: No additional space is used, merging is done in-place.

 */