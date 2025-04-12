package Arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

import java.util.*;

public class CustomSort {
    public static void main(String[] args) {
        Integer[] arr = {5, 3, 8, 6, 3, 2, 8, 9};
        Integer[] order = {3, 8, 6, 5};

        Integer[] sortedArr = sortByOrder(arr, order);

        System.out.println(Arrays.toString(sortedArr));
    }

    public static Integer[] sortByOrder(Integer[] arr, Integer[] order) {
        // Create a map to store the index of each element in the order array
        Map<Integer, Integer> orderMap = new HashMap<>();
        for (int i = 0; i < order.length; i++) {
            orderMap.put(order[i], i);
        }

        // Sort using custom comparator
        Arrays.sort(arr, (a, b) -> {
            if (orderMap.containsKey(a) && orderMap.containsKey(b)) {
                return orderMap.get(a) - orderMap.get(b); // Compare by order index
            } else if (orderMap.containsKey(a)) {
                return -1; // Elements in order array come first
            } else if (orderMap.containsKey(b)) {
                return 1; // Elements in order array come first
            } else {
                return a - b; // Default natural order
            }
        });

        return arr;
    }
}
