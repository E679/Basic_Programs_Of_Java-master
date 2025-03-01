package twosum;

import java.util.Arrays;
import java.util.HashMap;

class Solution {

    public int[] twoSum(int[] nums, int target)  {

        for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                if(nums[j]==target-nums[i])
                {

                    return new int[] {i,j};

                }
            }
        }
        return null;
    }
}

class TwoSumUsingHashMap
{
    public int[] twoSum(int[] nums, int target)
    {
        HashMap<Integer,Integer> map=new HashMap<>();
        int [] result=new int[2];
        for(int i=0;i<nums.length;i++)
        {
            if(map.containsKey(target-nums[i]))
            {
                result[0]=i;
                result[1]=map.get(target-nums[i]);
            }
            map.put(nums[i],i);
        }
        System.out.println(Arrays.toString(result));
        return result;
    }
}
class TwoSum {
    public static int[] findTwoSum(int[] nums, int target) {
        // HashMap to store the value and its index
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; // Calculate the other number required to form the target sum

            // Check if the complement is already in the map
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            // Store the value and its index in the HashMap
            map.put(nums[i], i);
        }

        // Return an empty array if no solution is found
        return new int[]{};
    }
}
