package Arrays;

//Find the equilibrium index of an array
public class EquilibriumIndex {
    public static int equilibriumIndex(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        int leftSum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (leftSum == sum - leftSum - arr[i]) {
                return i;
            }
            leftSum += arr[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int equilibriumIndex = equilibriumIndex(new int[]{2, 4, 5, 9, 6, 8});
        System.out.println(equilibriumIndex);
    }
}
