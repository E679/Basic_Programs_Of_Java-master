package Leetcode;

import java.util.Arrays;
import java.util.*;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        merge(nums1, m, nums2, n);
        System.out.println("Merged Array: " + Arrays.toString(nums1));
        //Second way
        int[] nums12 = {1, 2, 3, 0, 0, 0};
        int m1 = 3;
        int[] nums21 = {2, 5, 6};
        int n1 = 3;

        merge1(nums12, m1, nums21, n1);
        System.out.println("Merged1 Array: " + Arrays.toString(nums1));
        //third way
        int[] arr1 = {-5, -2, 4, 5};
        int[] arr2 = {-3, 1, 8};
        mergeTwoArrays(arr1,arr1.length,arr2,arr2.length);
        System.out.println("mergeWithoutExtraSpace:"+ Arrays.toString(arr1));//[-5, -3, -2, 1]
        System.out.println("mergeWithoutExtraSpace:"+ Arrays.toString(arr2));//[4, 5, 8]
    }

    //My own different from leetcode
    public static void mergeTwoArrays(int[] nums1, int m, int[] nums2, int n) {
        List<Integer> ls=new ArrayList<>();
        for(int ns1:nums1){
            ls.add(ns1);
        }
        for(int ns2:nums2){
            ls.add(ns2);
        }
        Collections.sort(ls);
        for(int i=0;i<m;i++){
            nums1[i]=ls.get(i);
        }
        for(int i=0;i<n;i++){
            nums2[i]=ls.get(m+i);
        }
    }
    /*
    take two pointers start comparing elements of arr1 from last index(p1) and
    compare elements from last index(p2) of arr2
    index p=m+n-1 which is last index of arr1 to put elements which is greater in either arr1 or arr2
     */ //for leetcode
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

    //Another way for leet code
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;//for comparing
        int p2 = n - 1;//for comparing
        int i = m + n - 1;//for placing elements

        while (p2 >= 0) {
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[i--] = nums1[p1--];
            } else {
                nums1[i--] = nums2[p2--];
            }
        }
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