package temp;

import java.util.Scanner;

public class FibonacciSeries {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter input: ");
        int n=scanner.nextInt();
        int  t1 = 1, t2 = 1;
        System.out.println("Fibonacci Series of " + n + " terms:");

        for (int i = 1; i <= n; ++i) {
            System.out.print(t1 + ", ");

            // compute the next term
            int sum = t1 + t2;
            t1 = t2;
            t2 = sum;
        }
    }
}
