package Arrays;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] arr1={1,3,5,7};
        int[] arr2={0,2,6,8,9};
        int n= arr1.length;
        int m= arr2.length;
        merge(arr1,arr2,n,m);
        System.out.print(Arrays.toString(arr1)+" ");//[0, 1, 2, 3]
        System.out.print(Arrays.toString(arr2)+" ");//[5, 6, 7, 8, 9]
        int n1= arr1.length;
        int m1= arr2.length;
        int[] mergedArr=new int[n1+m1];
        for(int i=0;i<n1;i++){
            mergedArr[i]=arr1[i];
        }
        for(int i=0;i<m1;i++){
            mergedArr[n1+i]=arr2[i];
        }
        System.out.print(Arrays.toString(mergedArr));
    }

    private static void merge(int[] arr1, int[] arr2, int n, int m) {
        int left=0;
        int right=0;
        int[] res=new int[n+m];
        int k=0;
        while (left<n && right<m){
            if(arr1[left]<=arr2[right]){
                res[k++]=arr1[left];
                left++;
            }
            else {
                res[k++]=arr2[right];
                right++;
            }
        }
        while (left<n){
            res[k++]=arr1[left++];
        }
        while (right<m){
            res[k++]=arr2[right++];
        }

        //System.out.print(Arrays.toString(res));//[0, 1, 2, 3, 5, 6, 7, 8, 9]
        for(int i=0;i<n+m;i++){
            if(i<n){
                arr1[i]=res[i];
            } else {
                arr2[i-n]=res[i];
            }
        }
    }
}
//Time Complexity O(n+m) Space Complexity O(n+m)