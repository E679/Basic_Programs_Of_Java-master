package Leetcode;

import java.util.*;

public class MergeIntervals {
    public static int[][] mergeIntervals(int[][] interval1, int[][] interval2) {
        List<int[]> intervals = new ArrayList<>();
        intervals.addAll(Arrays.asList(interval1));
        intervals.addAll(Arrays.asList(interval2));

        // Sort intervals based on the start value
        intervals.sort(Comparator.comparingInt(a -> a[0]));

        List<int[]> merged = new ArrayList<>();
        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        int[][] interval1 = {{2, 4}, {5, 6}, {7, 9}};
        int[][] interval2 = {{2, 3}, {5, 6}, {7, 8}, {10, 12}};

        int[][] result = mergeIntervals(interval1, interval2);

        for (int[] interval : result) {
            System.out.print(Arrays.toString(interval));
        }
    }
}

