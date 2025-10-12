package Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class MergeUnSortedArray {
    static ArrayList<Integer> mergeNsort(int[] arr1, int[] arr2) {
        ArrayList<Integer> res = new ArrayList<>();

        int i = 0, j = 0;

        // Push elements of 'arr1' into res
        while (i < arr1.length) {
            res.add(arr1[i]);
            i++;
        }

        // Push elements of 'arr2' into res
        while (j < arr2.length) {
            res.add(arr2[j]);
            j++;
        }

        // Sort the merged list
        Collections.sort(res);

        // Remove duplicates (unique elements only)
        ArrayList<Integer> uniqueRes = new ArrayList<>();
        for (int val : res) {
            if (uniqueRes.isEmpty() || uniqueRes.get(uniqueRes.size() - 1) != val) {
                uniqueRes.add(val);
            }
        }

        return uniqueRes;
    }

    public static void main(String[] args) {
        int[] arr1 = {11, 1, 8};
        int[] arr2 = {10, 11};

        ArrayList<Integer> res = mergeNsort(arr1, arr2);

        for (int x : res)
            System.out.print(x + " ");
    }
}
