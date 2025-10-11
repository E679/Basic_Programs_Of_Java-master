package Arrays.Complex.Level2_Common_in_Product_Companies;
//Subarray with equal 0s and 1s

import java.util.*;

public class EqualZeroOne {
    public static boolean exists(int[] a) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int x : a) {
            sum += (x == 0) ? -1 : 1;
            if (sum == 0 || map.containsKey(sum)) return true;
            map.put(sum, 1);
        }
        return false;
    }
}
//Time: O(n), Space: O(n)
