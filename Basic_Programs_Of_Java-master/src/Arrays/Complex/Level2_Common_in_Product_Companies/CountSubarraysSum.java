package Arrays.Complex.Level2_Common_in_Product_Companies;
//Count subarrays with given sum (handles negative numbers)

import java.util.*;

public class CountSubarraysSum {
    public static int count(int[] a, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, cnt = 0;
        for (int x : a) {
            sum += x;
            cnt += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return cnt;
    }
}
//Time: O(n), Space: O(n)
