package JavaStreamAPI;

import java.util.Arrays;
import java.util.List;


/*
Find sum of squares from list

Input: 1, 2, 3, 4, 5
Output: Sum of Squares: 55

 */
public class SumOfSquaresWithStream {
    public static void main(String[] args) {
        List<Integer> numbers= Arrays.asList(1, 2, 3, 4, 5);

        int result=numbers.stream().mapToInt(n->n*n).sum();
        System.out.println("Sum of Squares: "+result);

        int N=5244;
        int prod=1;
        int temp=N;
        while(temp>0){
            int sum=temp%10;
            prod*=sum;
            temp/=10;
        }
        System.out.println("Product of digits of "+N+" is "+prod);
        productOfGivenNumber(N);
        sumOfGivenNumber(N);
    }

    public static int productOfGivenNumber(int number){
        //Product of a given number
        int product = String.valueOf(number)
                .chars() // Convert the number into a stream of characters
                .map(ch -> Character.getNumericValue(ch)) // Convert each char back to its numeric value
                .reduce(1, (a, b) -> a * b); // Multiply all digits together

        System.out.println("Product of digits of " + number + " is " + product);
        return product;
    }
    public static int sumOfGivenNumber(int number){
        //Sum of given number
        int sum = String.valueOf(number)
                .chars() // Convert the number into a stream of characters
                .map(ch -> Character.getNumericValue(ch)) // Convert each char back to its numeric value
                .reduce(0, (a, b) -> a + b); // Multiply all digits together

        System.out.println("Sum of digits of " + number + " is " + sum);
        return sum;
    }
}
