package temp;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupWordsByLength {
    public static void main(String[] args) {
        List<String> words= Arrays.asList("I","have","a","sentence","with","technical","words");

        Map<Integer, List<String>> result=words.stream().collect(Collectors.groupingBy(String::length));
        System.out.println("stream result "+result);
        System.out.println("Normal output "+getgroupwords(words));
    }

    private static Map<Integer, List<String>> getgroupwords(List<String> words){
        Map<Integer, List<String>> result1=new HashMap<>();
        for (String word:words){
            int length=word.length();
            if (result1.containsKey(length)){
                List<String> rs1 = result1.get(length);
                rs1.add(word);
                result1.put(length,rs1);
            } else {
                List<String> rs = new ArrayList<>();
                //Add string
                rs.add(word);
                //Add key and list to map
                result1.put(length, rs);
            }
        }
        return result1;
    }
}
