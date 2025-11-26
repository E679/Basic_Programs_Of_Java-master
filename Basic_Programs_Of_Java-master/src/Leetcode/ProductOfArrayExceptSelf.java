package Leetcode;

import java.util.Arrays;

/*
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 */
public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] arr={1,2,3,4};
        int[] productExceptSelf = productExceptSelf(arr);
        System.out.println("productExceptSelf: "+ Arrays.toString(productExceptSelf));
        int[] productExceptSelf1 = productExceptSelf1(arr);
        System.out.println("productExceptSelf1: "+ Arrays.toString(productExceptSelf1));
    }
    public static int[] productExceptSelf(int[] nums) {
        int len=nums.length;
        int[] leftProd=new int[len];
        int[] rightProd=new int[len];

        for(int i=0,temp=1;i<len;i++){
            leftProd[i]=temp;
            temp*=nums[i];
        }
        for(int i=len-1,temp=1;i>=0;i--){
            rightProd[i]=temp;
            temp*=nums[i];
        }
        int[] res=new int[len];
        for(int i=0;i<len;i++){
            res[i]=leftProd[i]*rightProd[i];
        }
        return res;
    }
    public static int[] productExceptSelf1(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int left = 1, right = 1;

        for (int i = 0; i < n; i++) {
            res[i] = left;
            left *= nums[i];
        }

        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }

        return res;
    }

}
