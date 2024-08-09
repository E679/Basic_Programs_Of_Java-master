package temp;

import java.util.Scanner;

public class SumOfDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Number to get Sum");
        int num= scanner.nextInt();
        scanner.close();
        int result = sumOfDigitsUsingRecursive(num);
        int result1 = sumOfDigitsUsingUsingLoop(num);
        System.out.println("Sum Using Recursion is: "+result);
        System.out.println("Sum Using Loop is: "+result1);
    }

    private static int sumOfDigitsUsingRecursive(int num) {
        if (num==0) {
            return 0;
        }
        return (num%10) + sumOfDigitsUsingRecursive(num/10);
    }

    private static int sumOfDigitsUsingUsingLoop(int num) {
        int sum=0;
        while (num>0) {
            int rem=num%10;
            sum+=rem;
            num/=10;
        }
        return sum;
    }
}
