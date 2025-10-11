package Arrays.Complex.Level2_Common_in_Product_Companies;
//Longest consecutive sequence (HashSet)

import java.util.*;

public class LongestConsecutive {
    public static int longest(int[] a) {
        Set<Integer> s = new HashSet<>();
        for (int x : a) s.add(x);
        int best = 0;
        for (int x : s) {
            if (!s.contains(x - 1)) {
                int len = 1, cur = x;
                while (s.contains(cur + 1)) {
                    cur++;
                    len++;
                }
                best = Math.max(best, len);
            }
        }
        return best;
    }
}
//Time: O(n), Space: O(n)