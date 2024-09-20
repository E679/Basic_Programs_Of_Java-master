package temp;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class DistinctCharsAndTheirCount {
    public static void main(String[] args) {
        String str="abcdABCDabcd";
        char[] chars=str.toCharArray();

        Map<Character,Integer> map=new HashMap<>();

        for(char aChar:chars){
            if (map.containsKey(aChar)){
                map.put(aChar,map.get(aChar)+1);
            }else {
                map.put(aChar,1);
            }
        }
        System.out.println("Chars and count are:\n"+map);

        //Using Streams
        Map<Character, Long> collect = str.chars().mapToObj(ch -> (char) ch).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        System.out.println(collect);
    }
}
