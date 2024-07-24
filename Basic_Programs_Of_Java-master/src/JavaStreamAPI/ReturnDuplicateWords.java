package JavaStreamAPI;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public class ReturnDuplicateWords {
    public static void main(String[] args) {
        String s="there is a tree tree has three leaves three leaves are green";

        String[] words = s.split(" ");

        //this map will contain word and number of times word is repeated
        Map<String, Long> map =
                Arrays.stream(words).collect(Collectors.groupingBy(str -> str, Collectors.counting()));

        map.entrySet().forEach(
                x-> {
                    if(x.getValue()>1) {
                        System.out.println(x.getKey()+"-"+x.getValue());
                    }
                }
        );
        List<String> words1= Arrays.asList("banana","banana", "apple","apple", "cherry", "date", "grape");
        System.out.println("Finding Duplicate Words: "+getgroupwordsByKeyASString(words1));

        System.out.println("Finding Duplicate Words Using Streams: ");
        Map<String, Long> result = words1.stream().collect(Collectors.groupingBy(str -> str, Collectors.counting()));
        System.out.println(result);
        //result.forEach((k,v)-> System.out.println(k+"-"+v));

    }

    private static Map<String, Integer> getgroupwordsByKeyASString(List<String> words){
        Map<String, Integer> result1=new HashMap<>();
        for (String word:words){
            if (result1.containsKey(word)){
                result1.put(word,result1.get(word)+1);
            } else {
                result1.put(word,1);
            }
        }
        return result1;
    }
}
