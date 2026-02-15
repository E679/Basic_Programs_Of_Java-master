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
    //another way
    public static int[][] merge1(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        // Sort by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);

        for (int[] interval : intervals) {
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if (currentEnd >= nextStart) {
                // Overlapping - merge
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // Non-overlapping - add new interval
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }


    public static void main(String[] args) {


        int[][] intervals = {{1,3}, {2,6}, {8,10}, {15,18}};
        int[][] result2 = merge1(intervals);

        System.out.println("Merged intervals:");
        for (int[] interval : result2) {
            System.out.println(Arrays.toString(interval));
        }
        // Output: [1,6], [8,10], [15,18]
    }
}
//Time: O(n log n), Space: O(n)
