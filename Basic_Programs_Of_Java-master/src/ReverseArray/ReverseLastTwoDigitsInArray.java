package ReverseArray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ReverseLastTwoDigitsInArray {
    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        int n=scanner.nextInt();
//        int m=scanner.nextInt();
//        int[] arr=new int[m];
//        int[] arr2=new int[2];
//        for (int i=0;i<n;i++){
//            arr[i]=scanner.nextInt();
//        }
//        for (int i=0;i<n;i++){
//            arr2[i]=scanner.nextInt();
//        }
    }
    private static void reverseArray(ArrayList<Integer> arr, int m)
    {
        // Write your code here.
        int start = m+1;
        int end = arr.size()-1;
        for(int i=start;i<=end;i++){
            Collections.swap(arr, i,end);
            end--;
        }
    }
}
