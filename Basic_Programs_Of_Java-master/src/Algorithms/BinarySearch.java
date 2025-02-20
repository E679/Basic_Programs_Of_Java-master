package Algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

   public static void binarySearch(int a[],int first,int last,int key)
    {
        int mid=(first+last)/2;
        while(first<=last){
            if((a[mid])<key){
                first=mid+1;

            }   else if(a[mid]==key){
                System.out.println("Found at position: "+mid);
            break;
            }else{
                last=mid-1;
        }
        mid=(first+last)/2;
        }
        if(first>last){
            System.out.println("Not found");
        }
    }

    // Returns index of x if it is present in arr[].
    static int binarySearch(int arr[], int x)
    {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;//to avoid integer overflow in Binary Search.

            // Check if x is present at mid
            if (arr[mid] == x)
                return mid;

            // If x greater, ignore left half
            if (arr[mid] < x)
                low = mid + 1;

                // If x is smaller, ignore right half
            else
                high = mid - 1;
        }

        // If we reach here, then element was
        // not present
        return -1;
    }

    public static void main(String[] args) {
        int arr[]={20,10,50,30,40};
        Arrays.sort(arr);//In binary search array should be in sorted order for sure before searching
        int last=arr.length;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter key to search");
        int key=sc.nextInt();
        binarySearch(arr,0,last,key);

        //Another way easy
        int arr1[] = { 2, 3, 4, 10, 40 };
        int searchElement = 10;
        int result = binarySearch(arr1, searchElement);
        if (result == -1)
            System.out.println(
                    "Element is not present in array");
        else
            System.out.println("Element is present at "
                    + "index " + result);
    }
    }


