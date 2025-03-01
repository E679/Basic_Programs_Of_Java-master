package SortingArray;

import java.util.Arrays;

//Traditional Approach
public class RemoveZerosLoop {
    public static void main(String[] args) {
        int[] arr = {1, 2, 0, 3, 0, 0, 0, 0};
        int count = 0;

        // Count non-zero elements
        for (int num : arr) {
            if (num != 0) {
                count++;
            }
        }

        // Create new array for non-zero elements
        int[] result = new int[count];
        int index = 0;

        for (int num : arr) {
            if (num != 0) {
                result[index++] = num;
            }
        }

        // Print result
        System.out.println(Arrays.toString(result));
    }
}


//Using streams
 class RemoveZeros {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 0, 0, 0, 0};

        // Filter non-zero elements
        int[] result = Arrays.stream(arr)
                .filter(num -> num != 0)
                .toArray();

        // Print result
        System.out.println(Arrays.toString(result));
    }
}
