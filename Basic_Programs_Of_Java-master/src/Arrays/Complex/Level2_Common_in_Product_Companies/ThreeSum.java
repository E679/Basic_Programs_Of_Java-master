package Arrays.Complex.Level2_Common_in_Product_Companies;
//Find all triplets with sum = 0

import java.util.*;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] a) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(a);
        for (int i = 0; i < a.length - 2; i++) {
            if (i > 0 && a[i] == a[i - 1]) continue;
            int l = i + 1, r = a.length - 1;
            while (l < r) {
                int sum = a[i] + a[l] + a[r];
                if (sum == 0) {
                    res.add(Arrays.asList(a[i], a[l], a[r]));
                    l++;
                    r--;
                    while (l < r && a[l] == a[l - 1]) l++;
                    while (l < r && a[r] == a[r + 1]) r--;
                } else if (sum < 0) l++;
                else r--;
            }
        }
        return res;
    }
}
//Time: O(n²), Space: O(1) extra
