package SortingArray;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.Collections;
import java.util.List;

public class MedianOfSortedArrays {

    public static double findMedianSortedArrays(List<Integer> numbers1, List<Integer> numbers2) {
        List<Integer> mergedList = mergedmine(numbers1, numbers2);
        int n = mergedList.size();

        if (n % 2 == 0) {
            // If the size is even, take the average of the middle two elements.
            int mid1 = mergedList.get(n / 2 - 1);
            int mid2 = mergedList.get(n / 2);
            return (double) (mid1 + mid2) / 2;
        } else {
            // If the size is odd, return the middle element.
            return (double) mergedList.get(n / 2);
        }
    }


    public static void main(String[] args) {
        // Example usage:
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 7, 9, 10, 11);
        List<Integer> numbers2 = Arrays.asList(5, 6, 7, 8, 9, 12, 13, 14);

        double median = findMedianSortedArrays(numbers1, numbers2);
        System.out.println("Median: " + median);

    }

    private static List<Integer> mergedmine(List<Integer> numbers1, List<Integer> numbers2) {
        List<Integer> merres = new ArrayList<>();

        merres.addAll(numbers1);
        merres.addAll(numbers2);
        //Collections.sort(merres);
        int temp = 0;

        for (int i = 0; i < merres.size(); i++) {
            for (int j = i + 1; i < merres.size(); i++) {
                if (merres.get(i) > merres.get(j)) {
                    temp = merres.get(i);
                    merres.set(i, merres.get(j));
                    merres.set(j, temp);
                }
            }

        }
        return merres;
    }
}
