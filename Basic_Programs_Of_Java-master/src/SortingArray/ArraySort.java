package SortingArray;

import java.util.Arrays;
import java.util.Collections;

public class ArraySort {
    public static void main(String[] args) {
        String arr[]=new String[]{"Vijay","Ajay","Abhi"};
        System.out.println("'Array before sorting'");
    for(String i:arr){
        System.out.println(i);
    }
        System.out.println("'Array after sorting'");
        Arrays.sort(arr);
        for(String i:arr){
            System.out.println(i);
        }
        System.out.println("'Array sorting in reverse'");
        Arrays.sort(arr, Collections.reverseOrder());
        for(String i:arr){
            System.out.println(i);
        }

    }

}
