package Arrays.Complex.Level2_Common_in_Product_Companies;
//Find all subarrays with product < K

import java.util.*;

public class SubarraysProductLessK {
    public static List<List<Integer>> findSubarrays(int[] a, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int prod = 1, left = 0;
        for (int right = 0; right < a.length; right++) {
            prod *= a[right];
            while (left <= right && prod >= k) prod /= a[left++];
            List<Integer> temp = new ArrayList<>();
            for (int i = right; i >= left; i--) {
                temp.add(0, a[i]);
                res.add(new ArrayList<>(temp));
            }
        }
        return res;
    }
}
//Time: O(n²), Space: O(n²)
