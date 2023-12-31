package ReverseArray;

// Java Program to Remove Duplicate Elements
// From the Array using extra space

import java.util.HashSet;
import java.util.Set;

public class removeDuplicateElementsInArray {

    public static int removeduplicates(int a[], int n)
    {
        if (n == 0 || n == 1) {
            return n;
        }

        // creating another array for only storing
        // the unique elements
        int[] temp = new int[n];
        int j = 0;

        for (int i = 0; i < n - 1; i++) {
            if (a[i] != a[i + 1]) {
                temp[j++] = a[i];
            }
        }


        temp[j++] =a[n - 1];

        // Changing the original array
        for (int i = 0; i < j; i++) {
            a[i] = temp[i];
        }

        return j;
    }
    public static void main(String[] args)
    {
        int[] a = { 1, 1, 2, 2, 2,3,3,3,4,4,5,5,5,6 };
        int n = a.length;

        n = removeduplicates(a, n);

        // Printing The array elements
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }

        //Printing The array elements Using Set

        int[] arr={5,48,56,12,4,4,5,5,48};
        int len= arr.length;

        len=removeduplicatesUsingSet(arr,len);//48 4 5 56 12

        arr=sortedArray(arr,len);//4 5 12 48 56

        System.out.print("\nFrom set: \n");
        for (int i =0;i<len;i++){
            System.out.print(arr[i]+" ");
        }
    }

    private static int[] sortedArray(int[] arr, int len) {
        int temp=0;
        for (int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                if(arr[i]>arr[j]){
                    temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        return arr;
    }

    private static int removeduplicatesUsingSet(int[] arr, int len) {

        if(len<=1){
            return len;
        }
        Set<Integer> uniqueElements=new HashSet<>();

        for(int i=0;i<len;++i){
            uniqueElements.add(arr[i]);
        }

        int j=0;
        for(Integer a:uniqueElements){
                arr[j++]=a;
        }

        return uniqueElements.size();
    }
}

