package temp;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Primenumber {
    public static void main(String[] args) {
       int nums= 27;
        //List<Integer> numlist= Arrays.asList(2,3,5,8,4,6,13);
        boolean flag=false;
        getPrimenumber(nums, flag);
        //Prime Numbers from 1 to 100
        getPrimenumberFromList();
        //Prime numbers From GivenRange
        getPrimenumberFromGivenRange();
        getPrimenumberFrom1ToN();
    }

    private static void getPrimenumberFrom1ToN() {
        List<Integer> result = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1st number");
        int lower = sc.nextInt();
        System.out.println("Enter 2nd number");
        int upper = sc.nextInt();

        if (lower==1 || lower<=1) {
            System.out.println(lower+" Is not a Prime number\nPlease Enter 1st Number More than "+lower);
            return;
        }
        for (int i = lower; i <= upper; i++) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                result.add(i);
            }
        }
        System.out.println("Prime numbers within range from 1 to N : "+lower+" to "+upper+" :"+result);
    }

    private static void getPrimenumberFromGivenRange() {
        List<Integer> result=new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter 1st number");
        int lower=sc.nextInt();
        System.out.println("Enter 2nd number");
        int upper=sc.nextInt();

        if (lower==1 || lower<=1) {
            System.out.println(lower+" Is not a Prime number\nPlease Enter 1st Number More than "+lower);
            return;
        }
        for (int i=lower;i<=upper;i++){
            int count=0;
            for (int j=1;j<=i;j++){
                if (i%j==0){
                    count++;
                }
            }
            if (count==2){
                result.add(i);
            }
        }
        System.out.println("Prime numbers within range from "+lower+" to "+upper+" :"+result);
    }

    private static void getPrimenumberFromList() {
        List<Integer> result=new ArrayList<>();
        for (int i=1;i<=100;i++){
            int count=0;
            for (int j=1;j<=i;j++){
                if (i%j==0){
                    count++;
                }
            }
            if(count==2){
                result.add(i);
            }
        }
            System.out.println("Prime numbers from list are: "+result);
    }

    private static void getPrimenumber(int nums, boolean flag) {
        if (nums==0 || nums==1){
            System.out.println(nums+" Is not a Prime number");
        }
        for (int i=2;i<=nums/2;++i){
                if (nums%i==0){
                    flag=true;
                    break;
                }
        }
        if(!flag){
            System.out.println(nums+" Is a Prime number");
        }else {
            System.out.println("Not prime");
        }
    }
}
