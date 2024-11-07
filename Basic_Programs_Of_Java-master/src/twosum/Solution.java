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