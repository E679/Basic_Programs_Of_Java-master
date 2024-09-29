package JavaStreamAPI.Streams;

import java.util.*;
import java.util.stream.Collectors;

public class StreamAPICodingQns {
    public static void main(String[] args) {
        //Given a list of list of string, flatten them to single list of strings
        List<List<String>> listoflistofstrings = Arrays.asList(Arrays.asList("one", "two"), Arrays.asList("three", "four"));
        List<String> singlelistofstrings = listoflistofstrings.stream().flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println("singlelistofstrings: " + singlelistofstrings);

        //Sort a list of names in reverse alphabetical order.
        List<String> listofnames = Arrays.asList("John", "Jane", "Alice", "Bob");
        List<String> sortednameslist = listofnames.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("sortednameslist " + sortednameslist);

        //Peek is used for debuging purpose
        List<String> listofwords = Arrays.asList("apple", "banana", "cherry");
        List<String> peekedlist = listofwords.stream().peek(word -> System.out.println(word + " Length is " + word.length())).map(String::toUpperCase).collect(Collectors.toList());
        System.out.println("peekedlist " + peekedlist);

        //Fetch first 3 elements from a list
        List<Integer> integerList = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> limitedlist = integerList.stream().limit(3).collect(Collectors.toList());
        System.out.println("limitedlist " + limitedlist);

        //Skip 4 elements
        List<Integer> skippedlist = integerList.stream().skip(4).collect(Collectors.toList());
        System.out.println("skippedlist " + skippedlist);

        //reduce method
        List<Integer> integerList1 = Arrays.asList(0, 1, 2, 3, 4);
        Integer reducedSum = integerList1.stream().reduce((a, b) -> a + b).get();
        System.out.println("reducedSum " + reducedSum);

        //Allmatch and anymatch and nonematch
        boolean allMatch = integerList1.stream().allMatch(n -> n >= 0);
        System.out.println("allMatch " + allMatch);
        boolean anyMatch = integerList1.stream().anyMatch(n -> n >= 3);
        System.out.println("anyMatch " + anyMatch);
        boolean noneMatch = integerList1.stream().noneMatch(n -> n < 0);
        System.out.println("noneMatch " + noneMatch);

        //Max and Min
        Integer max = integerList1.stream().max(Integer::compareTo).get();
        Integer min = integerList1.stream().min(Integer::compareTo).get();
        System.out.println("Max: " + max + " Min: " + min);

        //Convert list to array
        Integer[] array = integerList1.stream().toArray(Integer[]::new);
        System.out.println("Converted list to array " + Arrays.toString(array));

        //Join Strings
        String joinedString = listofwords.stream().collect(Collectors.joining("| "));
        System.out.println("joinedString " + joinedString);
        String joinedStringWithdelimeters = listofwords.stream().collect(Collectors.joining(", ", "[", "]"));
        System.out.println("joinedStringWithdelimeters " + joinedStringWithdelimeters);
    }
}
