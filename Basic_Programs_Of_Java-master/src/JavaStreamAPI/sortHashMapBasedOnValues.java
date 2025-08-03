package JavaStreamAPI;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class sortHashMapBasedOnValues {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 30);
        map.put("B", 20);
        map.put("C", 10);
        map.put("D", 40);
        map.put("E", 50);

        LinkedHashMap<String, Integer> sortedMap = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));

        System.out.println(sortedMap);
    }
}
