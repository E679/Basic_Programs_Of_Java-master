package Arrays;

import java.util.Arrays;

public class MergeAndSortArrays {

    // Method to merge two arrays into one
    public static int[] mergeArrays(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] mergedArray = new int[n1 + n2];

        // Copy elements from the first array
        for (int i = 0; i < n1; i++) {
            mergedArray[i] = arr1[i];
        }

        // Copy elements from the second array
        for (int i = 0; i < n2; i++) {
            mergedArray[n1 + i] = arr2[i];
        }

        return mergedArray;
    }


    // Method to merge two arrays into one
    public static String[] mergeArrays(String[] arr1, String[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        String[] mergedArray = new String[n1 + n2];

        // Copy elements from the first array
        for (int i = 0; i < n1; i++) {
            mergedArray[i] = arr1[i];
        }

        // Copy elements from the second array
        for (int i = 0; i < n2; i++) {
            mergedArray[n1 + i] = arr2[i];
        }

        return mergedArray;
    }

    // Method to sort the array without using built-in functions
    public static void sortArray(int[] arr) {
        int n = arr.length;

        // Using a simple bubble sort for demonstration
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {-7, 5, 9, 1};
        int[] arr2 = {8, 3, 6, 2};

        // Merging the arrays
        int[] mergedArray = mergeArrays(arr1, arr2);

        // Sorting the merged array
        sortArray(mergedArray);

        // Displaying the sorted merged array
        System.out.println("Sorted Merged Array: " + Arrays.toString(mergedArray));

        //merging and sorting using strings
        String[] arr3 = {"apple", "mango", "banana"};
        String[] arr4 = {"grape", "orange", "kiwi"};

        // Merging the arrays
        String[] stringMergedArray = mergeArrays(arr3, arr4);
        sortArray(stringMergedArray);
        // Displaying the sorted merged array
        System.out.println("Sorted String Merged Array: " + Arrays.toString(stringMergedArray));
    }

    public static void sortArray(String[] arr) {
        int n = arr.length;

        // Using a simple bubble sort for demonstration
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Compare strings lexicographically
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    // Swap arr[j] and arr[j + 1]
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}

