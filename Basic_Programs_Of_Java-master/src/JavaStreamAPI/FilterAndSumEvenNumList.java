package JavaStreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
Filter even numbers from list using Java 8

Input: 1,2,3,4,5,6,7,8,9,10
Output: Even Numbers: [2,4,6,8,10]
 */
public class FilterAndSumEvenNumList {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> result = numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        System.out.println("Even Numbers: " + result);

        int[] a = {1, 2, 3, 4, 5, 6, 7, 8};
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        int sum = Arrays.stream(a).filter(n -> n % 2 == 0).sum();
        System.out.println("Array SUM: " + sum);
        int sum1 = list.stream().filter(n -> n % 2 == 0).mapToInt(Integer::intValue).sum();
        System.out.println("List SUM: " + sum1);
    }
}
