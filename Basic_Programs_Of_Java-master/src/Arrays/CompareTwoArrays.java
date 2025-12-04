package Arrays;

import java.util.*;
import java.util.stream.*;
public class CompareTwoArrays {
    public static void main(String[] args) {
        int[] arr1 = {3, 2, 5, 7};
        int[] arr2 = {2, 3, 5, 7};

        // Method 1: Sort and compare
        boolean isEqual1 = Arrays.equals(
                Arrays.stream(arr1).sorted().toArray(),
                Arrays.stream(arr2).sorted().toArray()
        );
        System.out.println("Arrays Equal: " + isEqual1); // true

        // Method 2: Using Sets
        Set<Integer> set1 = Arrays.stream(arr1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(arr2).boxed().collect(Collectors.toSet());
        boolean isEqual2 = set1.equals(set2) && arr1.length == arr2.length;
        System.out.println("Arrays Equal: " + isEqual2); // true

        // Method 3: Using frequency map
        boolean isEqual3 = Arrays.stream(arr1).boxed()
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()))
                .equals(Arrays.stream(arr2).boxed()
                        .collect(Collectors.groupingBy(n -> n, Collectors.counting())));
        System.out.println("Arrays Equal: " + isEqual3); // true
    }
}
