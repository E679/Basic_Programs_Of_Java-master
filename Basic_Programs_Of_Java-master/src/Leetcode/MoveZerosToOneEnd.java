package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
Note that you must do this in-place without making a copy of the array.

Example 1:
Input: nums = [0,1,0,3,12]Output: [1,3,12,0,0]
Example 2:
Input: nums = [0]Output: [0]

 */
public class MoveZerosToOneEnd {
    public static void moveZeroes(int[] nums) {
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[j]=nums[i];
                if (i != j) {
                    nums[i] = 0; // Set the current position to 0 if a swap occurred
                }
                j++;
            }
        }
    }

    //Another Way
    public static void moveZeroesAnotherWay(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for(int i:nums){
            if(i!=0){
                list.add(i);
            }

        }
        for(int i=0;i<nums.length;i++){
            if(i<list.size()){
                nums[i]=list.get(i);
            }else{
                nums[i]=0;
            }
        }
    }
    //Another way
    public static void moveZeros(int[] arr) {
        int index = 0;
        for (int num : arr)
            if (num != 0)
                arr[index++] = num;
        while (index < arr.length)
            arr[index++] = 0;
    }

    public static void main(String[] args) {
        int[] arr={0,1,0,3,12};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));//Output: [1, 3, 12, 0, 0]
        moveZeroesAnotherWay(arr);
        System.out.println(Arrays.toString(arr));//Output: [1, 3, 12, 0, 0]
    }
}
