package Arrays.Complex.Level2_Common_in_Product_Companies;
//Rearrange array to form the largest number

import java.util.*;

public class LargestNumber {
    public static String largestNumber(int[] nums) {
        String[] arr = Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));
        if (arr[0].equals("0")) return "0";
        return String.join("", arr);
    }
}

