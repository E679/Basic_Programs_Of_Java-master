package Arrays.Complex.Level2_Common_in_Product_Companies;
//Merge Overlapping Intervals

import java.util.*;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        int[] curr = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (curr[1] >= intervals[i][0]) curr[1] = Math.max(curr[1], intervals[i][1]);
            else {
                res.add(curr);
                curr = intervals[i];
            }
        }
        res.add(curr);
        return res.toArray(new int[res.size()][]);
    }
}
//Time: O(n log n), Space: O(n)
