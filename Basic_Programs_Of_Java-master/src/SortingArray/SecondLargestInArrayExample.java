package SortingArray;

import java.util.Arrays;
import java.util.Collections;

public class SecondLargestInArrayExample {
    public static int getSecondLargest(int[] a, int total){
        int temp;
        for (int i = 0; i < total; i++)
        {
            for (int j = i + 1; j < total; j++)
            {
                if (a[i] > a[j])
                {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        return a[total-2];
    }
    //Another way to get second largest element in array
    static void print2largest(Integer arr[], int arr_size)
    {
        // Sort the array in descending order
        Arrays.sort(arr, Collections.reverseOrder());
        // Start from second element as first
        // element is the largest
        for (int i = 1; i < arr_size; i++) {
            // If the element is not
            // equal to largest element
            if (arr[i] != arr[0]) {
                System.out.printf("The second largest "
                                + "element is %d\n",
                        arr[i]);
                return;
            }
        }

        System.out.printf("There is no second "
                + "largest element\n");
    }
    public static void main(String args[]){
        int a[]={1,2,5,6,3,2};
        int b[]={44,66,99,77,33,22,55};
        System.out.println("Second Largest: "+getSecondLargest(a,6));
        System.out.println("Second Largest: "+getSecondLargest(b,7));
    }
}
