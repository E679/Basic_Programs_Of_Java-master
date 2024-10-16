package Optional;

import java.util.List;
import java.util.Optional;

public class OptionalExample {

    // Method to find the longest string in the list
    public static Optional<String> findLongestString(List<String> strings) {
        return strings.stream()
                .reduce((s1, s2) -> s1.length() >= s2.length() ? s1 : s2);
    }

    public static void main(String[] args) {
        List<String> strings = List.of("apple", "banana", "kiwi", "grapefruit", "pear");

        // Find the longest string
        Optional<String> longestString = findLongestString(strings);

        // Print the result
        longestString.ifPresent(s -> System.out.println("Longest string: " + s));

        Optional<String> name=Optional.ofNullable(null);
        name.ifPresentOrElse(System.out::print,()->System.out.println("name is null"));
    }
}

