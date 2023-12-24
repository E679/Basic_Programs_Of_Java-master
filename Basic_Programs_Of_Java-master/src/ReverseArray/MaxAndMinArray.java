package ReverseArray;

import java.util.Arrays;

public class MaxAndMinArray {
    public static void main(String[] args) {
        int arr[]={48,2,49,56,12,52,14,99,102};
        int max=0;
        int min=0;
        System.out.println("Max is:");
        getMaxFromArr(arr,max);
        System.out.println("Min is:");
        getMinFromArr(arr,min);

        getMinandMaxUsingStream(arr);
    }

    private static void getMinandMaxUsingStream(int[] arr) {
        int max = Arrays.stream(arr)
                .max()
                .getAsInt();
        int min = Arrays.stream(arr)
                .min()
                .getAsInt();
        System.out.println("From Stream: \nMAX is: "+max+"\nMin is:"+min+"\n");
    }

    private static void getMinFromArr(int[] arr, int min) {
         min=arr[0];
        for (int i=0;i<arr.length;i++){
            if(arr[i]<min){
                min=arr[i];
            }
        }
        System.out.println(min);
    }

    private static void getMaxFromArr(int[] arr, int max) {
        max=arr[0];
        for (int i=0;i<arr.length;i++) {
            if (arr[i] > max) {
               max=arr[i];
            }
        }
        System.out.println(max);
    }
}
