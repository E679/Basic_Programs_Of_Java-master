package Strings;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringCaseConversion {
    public static String convertCase(String str) {
        int mid = str.length() / 2;

        String firstHalf = str.substring(0, mid).toLowerCase();
        String secondHalf = str.substring(mid).toUpperCase();

        return firstHalf + secondHalf;
    }

    // Using Stream
    public static String convertCaseStream(String str) {
        int mid = str.length() / 2;

        return IntStream.range(0, str.length())
                .mapToObj(i -> i < mid ?
                        Character.toLowerCase(str.charAt(i)) :
                        Character.toUpperCase(str.charAt(i)))
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        String str = "HelloWorld";
        System.out.println(convertCase(str));       // helloWORLD
        System.out.println(convertCaseStream(str)); // helloWORLD
    }
}
