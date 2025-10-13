package Arrays;

import java.util.HashMap;
import java.util.Map;

public class subarraySum {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1};
        int k = 3;
        int c = subarraySumUptoKelements(nums, k);
        System.out.println("Number of Subarrays are: " + c);
        subarraySumUptoKelementsAnotherWay(new int[]{1, 1, 1}, 2);
        System.out.println("Number of Subarrays are: " + c);

    }

    private static int subarraySumUptoKelements(int[] nums, int k) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int currentSum = 0;

            for (int j = i; j < nums.length; j++) {
                currentSum += nums[j];

                if (currentSum == k) {
                    count++;
                }
            }
        }

        return count;
    }

    //Time complexity is O(n2)
    //Below is optimal solution with O(n)
    private static int subarraySumUptoKelementsAnotherWay(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
