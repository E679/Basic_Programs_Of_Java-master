package temp;

import java.util.Scanner;

import javax.management.RuntimeErrorException;

public class solution {

    public static void main(String[] args) {
        int[] arr={};
        //findSum(arr);
        System.out.println("result :"+findextrasum(arr));
    }

    private static int findextrasum(int[] arr) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter size:\n");
        int size=scanner.nextInt();

        if(size==0){
            return 0;
        }
        arr=new int[size];
        System.out.println("Enter elements:\n");
        for(int i=1;i<arr.length;i++){
            arr[i]=scanner.nextInt();
        }

        int sum=0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]%2==0 || arr[i]%3==0 || arr[i]==0){
                sum+=arr[i];
            }
        }
        return sum;
    }

    public static int findSum(int arr[])
    {
        //Write code here
        Scanner scanner=new Scanner(System.in);
        int size=0;
        try{
            size=scanner.nextInt();
            arr=new int[size];
            for(int i=1;i<arr.length;i++){
                arr[i]=scanner.nextInt();
            }
        }
        catch(Exception e){
            return  0;
        }

        int sum=0;
        //while(size!=0){
        for(int i=1;i<arr.length;i++){
            if(arr[i]%2==0 || arr[i]%3==0){
                sum+=arr[i];
            }
        }
        //}

        return sum;
    }

}
