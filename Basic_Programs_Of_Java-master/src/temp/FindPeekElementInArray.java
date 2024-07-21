package temp;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FindPeekElementInArray {
    /*
    Find a peek element which is not smaller than its neighbours

    Example 1: [5,10,20,15]
    The element 20 has neighbours 10 and 15, both of them are less than 20
    Example 2: [10,20,30,40,50] 50 is the peak element
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Number of Elements:");
        int N= scanner.nextInt();
        int[] arr=new int[N];
        System.out.println("Enter Array Elements:");
        for (int i=0;i< arr.length;i++) {
            try {
                arr[i] = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please Enter digits...... Program Terminated!");
                throw new RuntimeException(e);
            }
        }

        int peekElement = getPeekElement(arr);
        System.out.println("peekElement is: " + peekElement);
        scanner.close();
    }

    private static int getPeekElement(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if ((i + 1) >= n) {
                return arr[n - 1];
            }
            if (((i - 1) > -1) && (arr[i] > arr[i - 1]) && (arr[i] > arr[i + 1])) {
                return arr[i];
            }
        }
        return 0;
    }
}
