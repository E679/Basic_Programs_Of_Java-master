package Arrays;

//Determine if an array contains a subarray with a sum of zero
import java.util.*;

public class SubarrayZeroSum {
    public static boolean hasZeroSumSubarray(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        for (int num : arr) {
            sum += num;
            if (sum == 0 || set.contains(sum))
                return true;
            set.add(sum);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr={3, 4, -7, 1, 2, -6};
        boolean res=hasZeroSumSubarray(arr);
        System.out.print(res);
    }
}

