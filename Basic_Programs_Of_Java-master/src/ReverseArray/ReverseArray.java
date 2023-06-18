package ReverseArray;

import java.util.Arrays;
import java.util.Collections;

public class ReverseArray {
    public static void main(String[] args) {
        Integer[] arr=new Integer[]{90,10,50,20,60,120};

        System.out.println("Original Array: ");
        for (int i=0;i<arr.length;i++) {
            System.out.println(arr[i]);
        }

        System.out.println("Sorted Array without for loop: ");
        Arrays.sort(arr);
            System.out.println(Arrays.toString(arr));

        System.out.println("Sorted Array with for loop: ");
        Arrays.sort(arr);
        for (int i=0;i<arr.length;i++) {
            System.out.println(arr[i]);
        }
        System.out.println(Arrays.toString(arr));
        //Collections.reverseOrder() accepts only type casted value for example: it not accepts int[] instead
        //it accepts Integer
        System.out.println("Reverse Array: ");
        Arrays.sort(arr, Collections.reverseOrder());
        System.out.println(Arrays.toString(arr));

        System.out.println("Reversing a String Array: \n");
        String[] str={"Europe","Disney","Australia","Ireland","Brazil","Canada"};

        int len= str.length;
        System.out.println("Before Sorting in Reverse: ");
        for (int i=0;i<len;i++){
            System.out.println(str[i]);
        }

        System.out.println("After Sorting : ");
        Arrays.sort(str);
        for (int i=0;i<len;i++){
            System.out.println(str[i]);
        }

        System.out.println("After Sorting in Reverse: ");
        Arrays.sort(str);
        for (int i=len-1;i>=0;--i){
            System.out.println(str[i]);
        }

        System.out.println("Reversing a String Array without function: \n");
        String[] str2={"Europe","Disney","Australia","Ireland","Brazil","Canada"};

        int lenofstr= str.length;
        for (int i=0;i<lenofstr;i++)
        {
            for (int j=i+1;j<lenofstr;j++)
            {
                if(str2[i].compareTo(str2[j])>0)
                {
                    String temp=str2[i];
                    str2[i]=str2[j];
                    str2[j]=temp;
                }
            }
        }
        System.out.println("Sorted String Array: "+Arrays.toString(str2));


    }
}