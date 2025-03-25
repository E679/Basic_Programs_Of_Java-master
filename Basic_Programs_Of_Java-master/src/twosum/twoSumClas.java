package twosum;

import java.util.Arrays;

public class twoSumClas extends Solution{
    public static void main(String[] args)   {
        int nums[]=new int[]{2,7,11,15};
        int target =9;
        Solution s=new Solution();
        s.twoSum(nums,target);

        TwoSumUsingHashMap twoSumUsingHashMap=new TwoSumUsingHashMap();
        twoSumUsingHashMap.twoSum(nums,target);

        TwoSum twoSum=new TwoSum();
        int[] twoSum1 = twoSum.findTwoSum(nums, target);
        System.out.println(Arrays.toString(twoSum1));

        int[] ints = twoSumUsingHashMap.twoSumUsingTwoPointerSolution(nums, target);
        System.out.println("twoSumUsingTwoPointerSolution: "+Arrays.toString(ints));
    }
}
