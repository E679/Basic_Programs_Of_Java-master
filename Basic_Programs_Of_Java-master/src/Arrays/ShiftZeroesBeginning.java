package Arrays;

//Java Program to Shift the 0's in an Array to the Beginning
/*
Java Program to Move All Zeros to the Start of an Array
This is the Java Program to Shift the 0’s in an Array to the Beginning.

Problem Description
Given an array of integers, shift all the zeroes present in it to the beginning.
Example:

Array = [1 0 2 3 0 4]

Output
Array = [0 0 1 2 3 4]

Problem Solution
Traverse the array from beginning to end, and whenever a zero is encountered, move it to the position of the first nonzero element, in the array.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class ShiftZeroesBeginning {
    // Function to shift 0's in the beginning
    static void inTheBeginning(int[] array){
        int startIndex=0;
        int i,temp,j;
        for(i=1; i<array.length; i++){
            if(array[i] == 0){
                for(j=i; j>startIndex;j--){
                    temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
                startIndex++;
            }
        }
    }
    // Function to read input and display the final array
    public static void main(String[] args){
        BufferedReader br = new BufferedReader
                (new InputStreamReader(System.in));
        int size;
        System.out.println("Enter the size of the array");
        try {
            size = Integer.parseInt(br.readLine());
        } catch (Exception e) {
            System.out.println("Invalid Input");
            return;
        }
        int[] array = new int[size];
        System.out.println("Enter array elements");
        int i;
        for (i = 0; i < array.length; i++) {
            try {
                array[i] = Integer.parseInt(br.readLine());
            } catch (Exception e) {
                System.out.println("An error occurred");
                return;
            }
        }
        inTheBeginning(array);
        System.out.println("The array after shifting the" +
                " zeroes in the beginning is");
        for(i=0; i<array.length; i++){
            System.out.print(array[i] + " ");
        }
    }
    /*
    Output:
    Enter the size of the array
4
Enter array elements
1
3
0
0
The array after shifting the zeroes in the beginning is
0 0 1 3
     */
}
