package Arrays.Complex.Level2_Common_in_Product_Companies;

//Find median of two sorted arrays
public class MedianTwoSorted {
    public static double findMedian(int[] a, int[] b) {
        int[] merged = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
            merged[k++] = (a[i] < b[j]) ? a[i++] : b[j++];
        }
        while (i < a.length) merged[k++] = a[i++];
        while (j < b.length) merged[k++] = b[j++];
        int n = merged.length;
        return (n % 2 == 0) ? (merged[n / 2] + merged[n / 2 - 1]) / 2.0 : merged[n / 2];
    }
}
//Time: O(n+m), Space: O(n+m)
