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
    }
}
