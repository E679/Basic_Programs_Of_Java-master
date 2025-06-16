package Leetcode;

import java.util.HashSet;
import java.util.Set;

/*
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
You must implement a solution with a linear runtime complexity and use only constant extra space.

Example 1:
Input: nums = [2,2,1]
Output: 1
Example 2:
Input: nums = [4,1,2,1,2]
Output: 4
Example 3:
Input: nums = [1]
Output: 1
 */
public class SingleNumber {
    public static void main(String[] args) {
        int[] nums={4,1,2,1,2};
        int singleNumber = singleNumber(nums);
        System.out.println("singleNumber: "+singleNumber);//4
    }
    public static int singleNumber(int[] nums) {
        Set<Integer> set=new HashSet<>(nums.length);
        for(int i:nums){
            if(set.contains(i)){
                set.remove(i);
            }
            else{
                set.add(i);
            }
        }
        return set.iterator().next();
    }
}
