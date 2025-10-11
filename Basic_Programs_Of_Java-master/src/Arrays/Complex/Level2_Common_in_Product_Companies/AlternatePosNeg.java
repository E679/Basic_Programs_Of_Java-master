package Arrays.Complex.Level2_Common_in_Product_Companies;

//Rearrange array elements in alternating positive and negative order
public class AlternatePosNeg {
    public static void rearrange(int[] a) {
        int n = a.length;
        int[] res = new int[n];
        int pos = 0, neg = 0;
        for (int x : a) {
            if (x < 0) res[neg++] = x;
            else res[n / 2 + pos++] = x;
        } // simplified
        for (int i = 0; i < n; i++) a[i] = res[i];
    }
}
//Time: O(n), Space: O(n)
