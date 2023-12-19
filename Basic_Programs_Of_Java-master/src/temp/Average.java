package temp;

//Calculate the average of numbers divisble by 3 and even at the same time
// Given an array nums and N where nums is array and N is its size
//Return the average of the number divisible by 3 and should be even

//Input:An array of nums with size N has been given
//Output: Return a single digit number which is average of all required numbers

import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the size: ");
        int size=scanner.nextInt();
        int[] nums=new int[size];
        int N=nums.length;
        System.out.println("Enter the numbers: ");
        for (int i=0;i<N;i++){
            nums[i]=scanner.nextInt();
        }
        System.out.println("Average is: "+countAverage(nums,N));

    }

    private static int countAverage(int[] nums, int n) {
        int sum=0;
        int count=0;
            for (int i=0;i<n;i++){
                if(nums[i]%2==0 && nums[i]%3==0 &&nums[i]!=0){
                    sum+=nums[i];
                    count++;
                }
            }
        return sum/count;
    }
}
