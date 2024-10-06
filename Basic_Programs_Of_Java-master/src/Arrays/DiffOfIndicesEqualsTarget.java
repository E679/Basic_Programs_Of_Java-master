package Arrays;

import java.util.Scanner;

public class DiffOfIndicesEqualsTarget {
    public static void main(String[] args) {
        /*

        Difference of same array element indices should be equal to target

        int[] arr={2,6,2,9};
        int n=2;
        output = true// bcoz two 2's are there and their indices are 0 and 2 hence, 2-0=2 which is =n
        int[] arr={5,6,2,5};
        int n=2;
        output = false// bcoz two 5's are there and their indices are 0 and 3 hence, 3-0=3 which is !=n
         */


        int[] arr = new int[256];

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter target");
        int n = sc.nextInt();
        System.out.println("Enter Array size ");
        int size = sc.nextInt();
        System.out.println("Enter Array elements ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        boolean getresult = getresult(arr, n);
        System.out.println("result is " + getresult);
    }


    private static boolean getresult(int[] arr, int n) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if ((arr[i] == arr[j]) && (j <= n - i)) {
                    return true;
                }
            }
        }
        return false;
    }
}
