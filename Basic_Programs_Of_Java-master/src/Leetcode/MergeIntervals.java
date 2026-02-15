package Leetcode;

import java.util.*;
//Merge Intervals
//Problem: Given a collection of intervals, merge overlapping intervals.
public class MergeIntervals {
    public static int[][] mergeIntervals(int[][] interval1, int[][] interval2) {
        List<int[]> intervals = new ArrayList<>();
        intervals.addAll(Arrays.asList(interval1));
        intervals.addAll(Arrays.asList(interval2));

        // Sort intervals based on the start value
        intervals.sort(Comparator.comparingInt(a -> a[0]));//- Sort the list of intervals based on the `start` value of each interval. Sorting ensures that intervals appear in sequential order, making it easier to merge them without missing cases.

        List<int[]> merged = new ArrayList<>();
        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);// No overlap, add interval as is
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
                // Overlap, merge by updating the 'end' of the last interval.
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

    //another way
        public static int[][] merge(int[][] intervals) {
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
        int[][] interval1 = {{2, 4}, {5, 6}, {7, 9}};
        int[][] interval2 = {{2, 3}, {5, 6}, {7, 8}, {10, 12}};

        int[][] result = mergeIntervals(interval1, interval2);

        for (int[] interval : result) {
            System.out.print(Arrays.toString(interval));
        }

        int[][] intervals = {{1,3}, {2,6}, {8,10}, {15,18}};
        int[][] result2 = merge(intervals);

        System.out.println("Merged intervals:");
        for (int[] interval : result2) {
            System.out.println(Arrays.toString(interval));
        }
        // Output: [1,6], [8,10], [15,18]
    }
}

