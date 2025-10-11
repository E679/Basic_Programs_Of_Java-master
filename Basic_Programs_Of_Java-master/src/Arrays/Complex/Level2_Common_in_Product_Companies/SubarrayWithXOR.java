package Arrays.Complex.Level2_Common_in_Product_Companies;

//Find subarray with given XOR

import java.util.*;

public class SubarrayWithXOR {
    public static boolean exists(int[] a, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int xr = 0;
        for (int x : a) {
            xr ^= x;
            if (xr == target) return true;
            if (map.containsKey(xr ^ target)) return true;
            map.put(xr, map.getOrDefault(xr, 0) + 1);
        }
        return false;
    }
}
//Time: O(n), Space: O(n)
