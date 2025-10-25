package Arrays;
import java.util.Arrays;
public class MergeSortedArray1 {
    static void mergeArrays(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;

        // temporary array to store all elements
        // from arr1 and arr2
        int[] merged = new int[n + m];

        // copy elements from arr1 and arr2 into merged array
        for (int i = 0; i < n; ++i) {
            merged[i] = arr1[i];
        }
        for (int j = 0; j < m; ++j) {
            merged[n + j] = arr2[j];
        }

        // sort the merged array
        Arrays.sort(merged);
        System.out.print(Arrays.toString(merged));
        // distribute first n elements to arr1
        for (int i = 0; i < n; ++i) {
            arr1[i] = merged[i];
        }

        // distribute remaining m elements to arr2
        for (int j = 0; j < m; ++j) {
            arr2[j] = merged[n + j];
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8};

        mergeArrays(arr1, arr2);

        for (int num : arr1) {
            System.out.print(num + " ");
        }
        System.out.println();

        for (int num : arr2) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
