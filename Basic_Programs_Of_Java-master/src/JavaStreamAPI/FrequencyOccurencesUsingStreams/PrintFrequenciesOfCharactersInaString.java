package JavaStreamAPI.FrequencyOccurencesUsingStreams;

import java.util.*;
import java.util.stream.Collectors;

public class PrintFrequenciesOfCharactersInaString {
    public static void main(String[] args) {
        /*
        1. Not considering the order of characters.
        String input = "bookkeeper";
        Output =  p1 r1 b1 e3 k2 o2
         */
        String input = "bookkeeper";
        Arrays.stream(input.toLowerCase().split("")).collect(Collectors.groupingBy(c->c,Collectors.counting()))
                .entrySet().stream().map(x->x.getKey()+x.getValue()+" ")
                .forEach(System.out::print);

        /*
        2. Character frequency in the order of their occurrence.
           HashMap doesn’t preserve the order in which key is added. To preserve the order we need to use LinkedHashMap.
           String input = "bookkeeper";
           Output = b1 o2 k2 e3 p1 r1
         */
        System.out.println("\nIn order");
        Arrays.stream(input.toLowerCase().split("")).collect(Collectors.groupingBy(c->c, LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream().map(x->x.getKey()+x.getValue()+" ")
                .forEach(System.out::print);

        /*
        3. Print characters frequency in alphabetic order.
           Sorting the stream based on the key of map Map.Entry.comparingByKey().
           Note that this could be done by using just sort() after .map operation as the map operation would generate string.
           String input = "bookkeeper";
           Output = b1 e3 k2 o2 p1 r1
         */
        System.out.println("\nIn Alphabetical order");
        Arrays.stream(input.toLowerCase().split("")).collect(Collectors.groupingBy(c->c,Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.comparingByKey()).map(x->x.getKey()+x.getValue()+" ").forEach(System.out::print);

        //Above code in java 7 looks like below
        List<Map.Entry<String, Long>> toSort = new ArrayList<>();
        for (Map.Entry<String, Long> x : Arrays.stream(input.toLowerCase().split("")).collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .entrySet()) {
            toSort.add(x);
        }
        toSort.sort(Map.Entry.comparingByKey());
        for (Map.Entry<String, Long> x : toSort) {
            String string = x.getKey() + x.getValue() + " ";
            System.out.print(string);
        }
        /*
        4. Print characters frequency in the order of most frequent one to least frequent one.
           For printing the output based on the frequency of characters, sort the map using value Map.Entry.comparingByValue().
           this would display the output in ascending order. since we want the most frequent once in the beginning we’ll pass comparator (a, b) -> b.compareTo(a)
           String input = "bookkeeper";
           Output = e3 k2 o2 p1 r1 b1
         */
        System.out.println("\nMost frequent one to least frequent one");
        Arrays.stream(input.toLowerCase().split("")).collect(Collectors.groupingBy(c->c,Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.comparingByValue()).map(x->x.getKey()+x.getValue()+" ").forEach(System.out::print);
    }
}
