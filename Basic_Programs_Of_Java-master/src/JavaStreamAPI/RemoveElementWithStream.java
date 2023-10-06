package JavaStreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
Remove Strings from list which has 'an' present in it
Input: "banana", "apple", "cherry", "date", "grape"
Output: Filtered words: [apple, cherry, date, grape]
 */
public class RemoveElementWithStream {
    public static void main(String[] args) {
        List<String> words= Arrays.asList("apple", "banana", "cherry", "date", "grape");
        String removelement="an";
        List<String> result=words.stream().filter(n->!n.contains(removelement)).collect(Collectors.toList());
        System.out.println("Filtered words: "+result);
    }
}
