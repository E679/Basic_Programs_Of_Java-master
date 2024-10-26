package JavaStreamAPI.Streams;

import java.util.*;
import java.util.stream.Collectors;

public class findfirstnonrepeatingcharfromstring {
    public static void main(String[] args) {
        char Stress = getfirstnonrepeatingcharfromstring("Stress");
        System.out.println("firstnonrepeatingcharfromstring is : "+Stress);
        sortAscandDsc();
    }
    static char getfirstnonrepeatingcharfromstring(String s){
        Map<Character, Long> map=s.chars().mapToObj(c->Character.toLowerCase(Character.valueOf((char) c)))
                .collect(Collectors.groupingBy(c->c, LinkedHashMap::new,Collectors.counting()));//using linkedhashmap to maintain insertion order

        Character c = map.entrySet().stream().filter(i -> i.getValue() == 1).map(i -> i.getKey())
                .findFirst().get();
        return c;
    }

    static void sortAscandDsc(){
        Map<String,Integer> map=new HashMap<>();
        map.put("Apple",30);
        map.put("Banana",15);
        map.put("Orange",20);
        map.put("Mango",10);

        List<Map.Entry<String,Integer>> list=new ArrayList<>(map.entrySet());//adding map details to list

        list.sort(Map.Entry.comparingByValue());//asc order
        //list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder())); dsc order

        Map<String,Integer> linkmap=new LinkedHashMap<>();

        for (Map.Entry<String, Integer> e:list){
            linkmap.put(e.getKey(), e.getValue());
        }
        System.out.println("Sorted map is :" +linkmap);
        //below is the simple way using streams
        map.entrySet().stream().sorted((Map.Entry.comparingByValue())).forEach(System.out::println);//ASC order
        System.out.println("------------------------------");
        map.entrySet().stream().sorted((Map.Entry.comparingByValue(Comparator.reverseOrder()))).forEach(System.out::println);//Desc order
    }
}
