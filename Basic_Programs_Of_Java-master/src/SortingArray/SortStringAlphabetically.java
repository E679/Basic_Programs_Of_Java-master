package SortingArray;

import java.util.Arrays;

public class SortStringAlphabetically {
    public static void main(String[] args) {
        String str="Supreeth";
        //Sort a string in alphabetical order without in built method
        getSortedString(str);
        //Sort a string in alphabetical order with in built method
        getSortedStringWithInBuiltMethod(str);
        //Sort String Array alphabetically by the initial character only in Java
        String[] strArr = { "PQRS", "AB", "RSTUVW", "RST", "U", "UVWXY", "OUJBG" };
        System.out.println("Sorting array strings = ");
        Arrays.sort(strArr, (str1, str2) -> str1.charAt(0) - str2.charAt(0));
        Arrays.asList(strArr).forEach(System.out::println);
    }

    private static void getSortedStringWithInBuiltMethod(String str) {
        str=str.toLowerCase();
        char arr[]=str.toCharArray();
        Arrays.sort(arr);
        System.out.println("Sorted string with in built method is :"+ Arrays.toString(arr));
    }

    private static void getSortedString(String str) {
        str=str.toLowerCase();
        char arr[]=str.toCharArray();
        int size=arr.length;
        int temp;
        for (int i=0; i<size;i++){
            for (int j=i+1; j< size; j++){
                if(arr[i]>arr[j]){
                    temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]= (char) temp;
                }
            }
        }
        System.out.println("Sorted string without in built method is :"+ Arrays.toString(arr));
    }
}
