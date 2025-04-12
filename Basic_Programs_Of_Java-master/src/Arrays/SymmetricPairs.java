package Arrays;

//Find all symmetric pairs in an array_

import java.util.HashMap;
import java.util.Map;

public class SymmetricPairs {
    public static void symmetricPairs(int[] arr) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + ", " + entry.getKey());
            }
        }
    }

    public static void main(String[] args) {
        symmetricPairs(new int[]{2,4,7,7,9,5,5});
    }
}
