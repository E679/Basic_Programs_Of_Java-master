package Leetcode;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MajorityElement {
    public static void main(String[] args) {
        int[] ints = {3, 2, 3};
        int k = majorityElement(ints);
        System.out.println(k);//Output : 3
        Integer majorityElement = Arrays.stream(ints).mapToObj(i -> i).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).map(e -> e.getKey()).get();
        System.out.print("majorityElement: "+majorityElement);
//        for(Map.Entry<Integer, Long> entry: integerLongMap.entrySet()){
//            if(entry.getValue()>1){
//                System.out.print(entry.getKey());
//            }
//        }
    }
    public static int majorityElement(int[] nums) {
        int n=nums.length/2;
        int count=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                count++;
            }
            if(count<n){
                return nums[i];
            }
        }
        return 0;
    }
}
/*
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.



Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2


Constraints:

n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109


Follow-up: Could you solve the problem in linear time and in O(1) space?
 */