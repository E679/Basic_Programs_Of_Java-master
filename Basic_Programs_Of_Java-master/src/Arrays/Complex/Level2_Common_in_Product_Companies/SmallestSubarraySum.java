package Arrays.Complex.Level2_Common_in_Product_Companies;

//Find smallest subarray with sum ≥ target
public class SmallestSubarraySum {
    public static int minLen(int[] a, int s) {
        int l = 0, sum = 0, minLen = Integer.MAX_VALUE;
        for (int r = 0; r < a.length; r++) {
            sum += a[r];
            while (sum >= s) {
                minLen = Math.min(minLen, r - l + 1);
                sum -= a[l++];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
//Time: O(n), Space: O(1)