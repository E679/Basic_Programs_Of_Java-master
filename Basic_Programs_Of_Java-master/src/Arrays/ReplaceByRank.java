package Arrays;

import java.util.*;

// Replace each element of the array by its rank in the array
public class ReplaceByRank {
    public static void replaceByRank(int[] arr) {
        int[] sortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArr);
        Map<Integer, Integer> rankMap = new HashMap<>();
        for (int i = 0; i < sortedArr.length; i++) {
            rankMap.put(sortedArr[i], i + 1);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rankMap.get(arr[i]);
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        replaceByRank(new int[]{2,5,7,9,8,6});
    }
}
