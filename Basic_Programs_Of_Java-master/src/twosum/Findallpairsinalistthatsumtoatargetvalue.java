package twosum;

import java.util.*;
import java.util.stream.Collectors;

public class Findallpairsinalistthatsumtoatargetvalue {
    public static void main(String[] args) {
        //Find all pairs in a list that sum to a target value
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,7,5,8,6,4));
        int target=10;
        List<List<Integer>> pairs = list.stream().flatMap(i -> list.stream()
                        .filter(j -> i < j && i + j == target)
                        .map(j -> Arrays.asList(i, j)))
                .collect(Collectors.toList());
        System.out.println(pairs);//[[2, 8], [3, 7], [4, 6]]
        //Another way
        List<Integer> list1 = Arrays.asList(1, 2, 3, 7, 5, 8, 6, 4);
        int target1 = 10;
        Set<Integer> seen = new HashSet<>();
        List<List<Integer>> pairs1 = new ArrayList<>();

        for (int num : list1) {
            int complement = target1 - num;
            if (seen.contains(complement)) {
                pairs1.add(Arrays.asList(complement, num));
            }
            seen.add(num);
        }
        System.out.println(pairs1);
        // Output: [[3, 7], [2, 8], [6, 4]]
    }

}
