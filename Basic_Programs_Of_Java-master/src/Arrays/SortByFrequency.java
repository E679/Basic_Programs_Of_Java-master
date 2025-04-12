package Arrays;

import java.util.*;

//Sort the elements of an array by frequency
public class SortByFrequency {
    public static void sortByFrequency(int[] arr) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(frequencyMap.entrySet());
        Collections.sort(list, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));
        int[] result = new int[arr.length];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : list) {
            for (int i = 0; i < entry.getValue(); i++) {
                result[index++] = entry.getKey();
            }
        }
        System.arraycopy(result, 0, arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        sortByFrequency(new int[]{2,4,5,7,9,8});
    }
}
