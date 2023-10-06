package JavaStreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
Input: 1, 2, 3, 4, 5
Output: Doubled elements: [2, 4, 6, 8, 10]
 */
public class DoubleEachElement {
    public static void main(String[] args) {
        List<Integer> numbers= Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> result=numbers.stream().map(n->n*2).collect(Collectors.toList());
        System.out.println("Doubled elements: "+result);
    }
}
