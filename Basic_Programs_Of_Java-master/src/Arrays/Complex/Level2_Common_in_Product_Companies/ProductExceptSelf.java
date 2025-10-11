package Arrays.Complex.Level2_Common_in_Product_Companies;

//Product of array elements except self (no division)
public class ProductExceptSelf {
    public static int[] productExceptSelf(int[] a) {
        int n = a.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) res[i] = res[i - 1] * a[i - 1];
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= a[i];
        }
        return res;
    }
}
//Time: O(n), Space: O(1) extra (output array allowed)
