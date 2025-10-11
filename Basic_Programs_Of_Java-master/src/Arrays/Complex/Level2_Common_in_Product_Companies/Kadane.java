package Arrays.Complex.Level2_Common_in_Product_Companies;

//Kadane’s Algorithm — Maximum Subarray Sum
public class Kadane {
    public static int maxSubarray(int[] a) {
        int maxEnding = a[0], maxSoFar = a[0];
        for (int i = 1; i < a.length; i++) {
            maxEnding = Math.max(a[i], maxEnding + a[i]);
            maxSoFar = Math.max(maxSoFar, maxEnding);
        }
        return maxSoFar;
    }
}
//Time: O(n), Space: O(1)
