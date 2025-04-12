package Arrays;
//Find the maximum product subarray in an array_
public class MaxProductSubarray {
    public static int maxProductSubarray(int[] arr) {
        int maxProduct = arr[0];
        int minProduct = arr[0];
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < 0) {
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }
            maxProduct = Math.max(arr[i], maxProduct * arr[i]);
            minProduct = Math.min(arr[i], minProduct * arr[i]);
            result = Math.max(result, maxProduct);
        }
        return result;
    }

    public static void main(String[] args) {
        int maxProductSubarray = maxProductSubarray(new int[]{2, 7, 4, 5, 6});
        System.out.println(maxProductSubarray);
    }
}
