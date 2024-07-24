package Algorithms;

/*
Output
Sorted Array
1 5 7 8 9 10
Complexity Analysis of Quick Sort :
Time Complexity:

Best Case : Ω (N log (N))
The best-case scenario for quicksort occur when the pivot chosen at the each step divides the array into roughly equal halves.
In this case, the algorithm will make balanced partitions, leading to efficient Sorting.
Average Case: θ ( N log (N))
Quicksort’s average-case performance is usually very good in practice, making it one of the fastest sorting Algorithm.
Worst Case: O(N ^ 2)
The worst-case Scenario for Quicksort occur when the pivot at each step consistently results in highly unbalanced partitions. When the array is already sorted and the pivot is always chosen as the smallest or largest element. To mitigate the worst-case Scenario, various techniques are used such as choosing a good pivot (e.g., median of three) and using Randomized algorithm (Randomized Quicksort ) to shuffle the element before sorting.
Auxiliary Space: O(1), if we don’t consider the recursive stack space. If we consider the recursive stack space then, in the worst case quicksort could make O ( N ).
Advantages of Quick Sort:
It is a divide-and-conquer algorithm that makes it easier to solve problems.
It is efficient on large data sets.
It has a low overhead, as it only requires a small amount of memory to function.
Disadvantages of Quick Sort:
It has a worst-case time complexity of O(N 2 ), which occurs when the pivot is chosen poorly.
It is not a good choice for small data sets.
It is not a stable sort, meaning that if two elements have the same key, their relative order will not be preserved in the sorted output in case of quick sort, because here we are swapping elements according to the pivot’s position (without considering their original positions).
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = { 10, 7, 8, 9, 1, 5 };
        int N = arr.length;

        // Function call
        quickSort(arr, 0, N - 1);
        System.out.println("Sorted array:");
        printArr(arr);
    }

    // The main function that implements QuickSort
    // arr[] --> Array to be sorted,
    // low --> Starting index,
    // high --> Ending index
    static void quickSort(int[] arr, int low, int high)
    {
        if (low < high) {

            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // A utility function to swap two elements
    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // This function takes last element as pivot,
    // places the pivot element at its correct position
    // in sorted array, and places all smaller to left
    // of pivot and all greater elements to right of pivot
    static int partition(int[] arr, int low, int high)
    {
        // Choosing the pivot
        int pivot = arr[high];

        // Index of smaller element and indicates
        // the right position of pivot found so far
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            // If current element is smaller than the pivot
            if (arr[j] < pivot) {

                // Increment index of smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }
    // To print sorted array
    public static void printArr(int[] arr)
    {
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}
