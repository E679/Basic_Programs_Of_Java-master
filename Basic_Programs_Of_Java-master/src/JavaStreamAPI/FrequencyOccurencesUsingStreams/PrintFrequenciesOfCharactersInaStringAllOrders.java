package JavaStreamAPI.FrequencyOccurencesUsingStreams;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class PrintFrequenciesOfCharactersInaStringAllOrders {
    public static void main(String[] args) {
        String input = "bookkeeper";

        var mapOfChar = getMapOfCharacterFrequency(input);
        var linkedHashMapOfChar = getLinkedHashMapOfCharacterFrequency(input);

        System.out.println("\nfreqOfCharacters");
        freqOfCharacters(mapOfChar.entrySet());

        System.out.println("\nfreqInOrderOfAppearance");
        freqOfCharacters(linkedHashMapOfChar.entrySet());

        System.out.println("\nfreqInOrderOfAlphabetic");
        freqInOrderOfAlphabetic(mapOfChar.entrySet());

        System.out.println("\ncharactersInOrderOfMostOccurring");
        charactersInOrderOfMostOccurring(mapOfChar.entrySet());

    }

    private static Map<String, Long> getMapOfCharacterFrequency(String input) {
        return Stream.of(input.split(""))
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));
    }

    private static Map<String, Long> getLinkedHashMapOfCharacterFrequency(String input) {
        return Stream.of(input.split(""))
                .collect(Collectors.groupingBy(e -> e, LinkedHashMap::new, Collectors.counting()));
    }

    private static void freqOfCharacters(Set<Map.Entry<String, Long>> input) {
        input.stream()
                .map(e -> e.getKey()+e.getValue()+" ")
                .forEach(System.out::print);
    }

    private static void freqInOrderOfAlphabetic(Set<Map.Entry<String, Long>> input) {
        input.stream()
                .sorted(Map.Entry.comparingByKey())
                .map(e -> e.getKey()+e.getValue()+" ")
                .forEach(System.out::print);
    }

    private static void charactersInOrderOfMostOccurring(Set<Map.Entry<String, Long>> input) {
        input.stream()
                .sorted(Map.Entry.comparingByValue())
                .map(e -> e.getKey()+e.getValue()+" ")
                .forEach(System.out::print);
    }
}
