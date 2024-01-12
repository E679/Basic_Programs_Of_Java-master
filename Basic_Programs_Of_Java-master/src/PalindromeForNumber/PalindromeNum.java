package PalindromeForNumber;

public class PalindromeNum {
    public static void main(String[] args) {
        int num=2552;
        int rev=0;
        int rem;

        int temp=num;

        while (num>0){
            rem=num%10;
            rev=rev*10+rem;
            num/=10;
        }
        //System.out.println("temp value "+temp);
        if(temp==rev){
            System.out.println("Palindrome");
        }else
            System.out.println("Not Palindrome");
    //////////////////////////////////////////////////////////////

        //Sum of digits
        int n=565;
        int sum=0;
        while(n>0){
             sum+=n%10;
            n=n/10;
        }
        System.out.println("Sum of given number is :"+sum);
        //Sum using recursion
        int res=sum_of_digit(16);
        System.out.println("Sum using Recursion is : "+res);
        int x=121;
        reverseStringUsingStringBuilder(x);
    }
    public static int sum_of_digit(int num)
    {
        if (num == 0)
            return 0;
        return (num % 10 + sum_of_digit(num / 10));
    }


    private static boolean reverseStringUsingStringBuilder(int x) {
        String strX = String.valueOf(x);
        StringBuilder sb=new StringBuilder();
        sb.append(strX);
        sb=sb.reverse();
        boolean res=strX.equals(sb.toString());
        return res;

    }
}
