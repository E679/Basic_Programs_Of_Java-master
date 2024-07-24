package JavaStreamAPI;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
Return words which are repeated more than once in given sentence

Input:
there is a tree tree has three leaves three leaves are green

output:
leaves-2
tree-2
three-2
 */
public class ReturnDuplicateWordsByLength {
    public static void main(String[] args) {
        String s="there is a tree tree has three leaves three leaves are green";

        String[] words = s.split(" ");

        Map<String, Long> map =
                Arrays.stream(words).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        map.entrySet().forEach(
                x-> {
                    if(x.getValue()>1) {
                        System.out.println(x.getKey()+"-"+x.getValue());
                    }
                }
        );

    }
}
