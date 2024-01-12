package temp;

import java.util.Arrays;
import java.util.Scanner;

public class FibonacciSeries {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter input: ");
        int n=scanner.nextInt();
        int  t1 = 0, t2 = 1;
        System.out.println("Fibonacci Series of " + n + " terms:");

        for (int i = 1; i <= n; ++i) {
            System.out.print(t1 + ", ");

            // compute the next term
            int sum = t1 + t2;
            t1 = t2;
            t2 = sum;
        }
        System.out.println("Using recursion: ");
        for (int i = 0; i < n; i++) {
            System.out.print(fibnonacciUsingRecursion(i) + " ");
        }
        usingForLoop(n);
    }
    private static void usingForLoop(int n) {
        if (n == 0) {
            return ;
        }

        if (n == 1 || n == 2) {
            return ;
        }
        int[] arr=new int[n];
        arr[0]=0;
        arr[1]=1;
        for (int i=2;i<n;i++){
            arr[i]=arr[i-1]+arr[i-2];
        }
        System.out.println("\nUsing for loop"+ Arrays.toString(arr));
    }

    private static int fibnonacciUsingRecursion(int n) {
        if (n == 0) {
            return 0;
        }

        else if (n == 1 || n == 2) {
            return 1;
        }
        else
            return fibnonacciUsingRecursion(n-1)+fibnonacciUsingRecursion(n-2);
    }
}
