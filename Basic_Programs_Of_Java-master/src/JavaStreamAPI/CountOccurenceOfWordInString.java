package JavaStreamAPI;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountOccurenceOfWordInString {
    public static void main(String[] args) {
        String s="The English test was good bcoz test was easy bcoz test was in english";
        String[] words=s.split("\\s");
        Map<String, Long> collect = Arrays.stream(words).map(String::toLowerCase).
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        collect.forEach((word,count)->System.out.println(word+": "+count));
    }
}
