package Strings;

import java.util.*;
import java.util.stream.*;

public class ReverseWordsUsingStream {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Original String: ");
        String str1 = scanner.nextLine();
        scanner.close();

        String reversedStr = Arrays.stream(str1.split("\\s+"))
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        list -> {
                            Collections.reverse(list);
                            return String.join(" ", list);
                        }
                ));

        System.out.println("Reversed String: " + reversedStr);

        //Easy and clean version
        List<String> list = Arrays.stream(str1.split("\\s+")).collect(Collectors.toList());
        Collections.reverse(list);
        String reversedWords = "";//String.join(" ", list);
        String string = list.stream().map(w -> reversedWords + w).collect(Collectors.joining(" "));
        System.out.print("Reversed Words Easy Way: "+string);
    }
}

