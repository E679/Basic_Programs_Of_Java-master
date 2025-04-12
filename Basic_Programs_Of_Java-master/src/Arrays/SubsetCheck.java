package Arrays;

import java.util.HashSet;
import java.util.Set;
//Check if an array is a subset of another array or not
public class SubsetCheck {
    public static boolean isSubset(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr1) {
            set.add(num);
        }
        for (int num : arr2) {
            if (!set.contains(num)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] arr1 = {11, 1, 13, 21, 3, 7};  // Larger array
        int[] arr2 = {11, 3, 7, 1};          // Subset array

        boolean isSubset = isSubset(arr1, arr2);
        System.out.println("Is arr2 a subset of arr1? " + isSubset);
    }
}