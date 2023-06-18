package BinarySearch;

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

    public static void main(String[] args) {
        int arr[]={20,10,50,30,40};
        Arrays.sort(arr);//In binary search array should be in sorted order for sure before searching
        int last=arr.length;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter key to search");
        int key=sc.nextInt();
        binarySearch(arr,0,last,key);
    }

}
