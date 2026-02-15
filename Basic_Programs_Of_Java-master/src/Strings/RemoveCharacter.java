package Strings;

import java.util.stream.*;
//Remove character occurrences
public class RemoveCharacter {
    public static void main(String[] args) {
        String str = "Hello World";
        char charToRemove = 'o';

        // Method 1: Using replace
        String result1 = str.replace(String.valueOf(charToRemove), "");
        System.out.println(result1); // Hell Wrld

        // Method 2: Using replaceAll with regex
        String result2 = str.replaceAll(String.valueOf(charToRemove), "");
        System.out.println(result2); // Hell Wrld

        //Using Streams
        System.out.println(removeCharacter(str, charToRemove));
        //Using StringBuilder
        System.out.println(removeCharacterUsingStringBuilder(str, charToRemove));
    }
    public static String removeCharacter(String str, char charToRemove) {
        return str.chars()
                .filter(c -> c != charToRemove)
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
    }
    public static String removeCharacterUsingStringBuilder(String str, char charToRemove) {
        return str.chars()
                .filter(c -> c != charToRemove)
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString();
    }
}
