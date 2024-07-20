package ReverseArray;

import Validations.constantUtils;

/*
Rotate an array by n positions

Input1:
  int [] arr={1, 2, 3, 4, 5};
  positions=2;

Output:
  Rotated Array: 4 5 1 2 3

Input2:
  int [] arr={1, 2, 3, 4, 5, 6, 7};
  positions=3;

Output:
  Rotated Array: 5, 6, 7, 1, 2, 3, 4
 */
public class RotatedArrayToRight {
    public static void main(String[] args) {
        int [] arr={1, 2, 3, 4, 5};
        int positions=2;

        int [] nums={10, 20, 30, 40, 50};
        int k=2;
        int n=nums.length;

        int[] rotatedArr=new int[arr.length];

        for (int i=0;i< arr.length;i++){
            int newPos=(i+positions) % arr.length;
            rotatedArr[newPos]=arr[i];
        }

        System.out.println("Rotated Array: ");
        for (int num:rotatedArr) {
            System.out.print(num+" ");
        }

        //Another way
        int[] res=rotatearrayUsingPositions(nums,n,k);
        System.out.println("\nrotatearrayUsingPositions: \n");
        for (int i=0;i<n;++i){
            System.out.print(res[i]+" ");
        }

        //Rotate array using reverse logic
        int [] nums2={1, 2, 3, 4, 5, 6, 7};
        int k2=3;
        int n2=nums2.length;
        rotatearrayUsingPositionsUsingReverseLogic(nums2,n2,k2);
        System.out.println("\nRotate array using Reverse Logic: \n");
        for (int i=0;i<n2;++i){
            System.out.print(nums2[i]+" ");
        }

    }


    private static int[] rotatearrayUsingPositions(int[] nums, int n,int k) {
        if (k > n)
            k = k % n;

        int[] ans = new int[n];

        for (int i = 0; i < k; i++) {
            ans[i] = nums[n - k + i];
        }

        int index = 0;
        for (int i = k; i < n; i++) {
            ans[i] = nums[index++];
        }
        return ans;
    }

    private static void rotatearrayUsingPositionsUsingReverseLogic(int[] nums, int n, int k) {
        if (k > n)
            k = k % n;
        //1st step reverse array
        constantUtils.reverse(nums, 0, n - 1);
        //2nd step reverse array from o to kth elements
        constantUtils.reverse(nums, 0, k - 1);
        //3rd step reverse array from k to n-1
        constantUtils.reverse(nums, k, n - 1);
    }

}
