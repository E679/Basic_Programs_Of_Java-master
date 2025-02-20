package DSA;

/*
QuickSort Algorithm in Java
QuickSort is a divide-and-conquer sorting algorithm that works by selecting a pivot element, partitioning the array around the pivot, and recursively sorting the subarrays.

Steps of QuickSort
Choose a pivot (commonly the last element, first element, or median).
Partition the array:
Move elements smaller than pivot to the left.
Move elements greater than pivot to the right.
Recursively apply QuickSort on the left and right subarrays.
Base Case: When the subarray has one or zero elements, it is already sorted.
 */

import java.util.Arrays;

public class QuickSort {

    // Method to perform QuickSort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Find partition index
            int partitionIndex = partition(arr, low, high);

            // Recursively sort left and right subarrays
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    // Partition function
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];  // Choosing last element as pivot
        int i = low - 1;  // Pointer for smaller element

        for (int j = low; j < high; j++) {
            // If current element is smaller than pivot, swap it
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        // Swap pivot to its correct position
        swap(arr, i + 1, high);
        return i + 1; // Return partition index
    }

    // Swap method
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Main method to test QuickSort
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Unsorted Array: " + Arrays.toString(arr));

        quickSort(arr, 0, arr.length - 1);

        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }

    /*
    Time Complexity of QuickSort
Case	                                                Complexity
Best Case (Balanced Partitioning)	                    O(n log n)
Average Case (Random Distribution)	                    O(n log n)
Worst Case (Already Sorted, Unbalanced Partitioning)	O(n²)

Best/Average Case: When pivot divides array evenly, recursion depth is log n, and each level requires O(n) operations → O(n log n)
Worst Case: If pivot always selects smallest or largest element, results in n recursive calls with O(n) operations, leading to O(n²).

Space Complexity
O(log n) (Recursive function calls stack space)

Advantages of QuickSort
✅ Fast in Practice – Typically faster than Merge Sort for large datasets.
✅ In-Place Sorting – Uses constant extra space O(1).
✅ Efficient for Large Data Sets – Performs well on average.

Disadvantages
❌ Worst Case is O(n²) – If not implemented properly (e.g., choosing a bad pivot).
❌ Recursive Overhead – Can lead to stack overflow for large arrays.

Optimizations
Randomized Pivot Selection – Avoids worst-case scenarios.
Hybrid Sorting (Switch to Insertion Sort for Small Arrays) – Improves performance.
Tail Recursion Elimination – Reduces recursive overhead.
     */
}

