package PalindromeForNumber;

public class PalindromeNum {
    public static void main(String[] args) {
        int num=1331;
        int rev=0;
        int rem;

        int temp=num;

        while (num>0){
            rem=num%10;
            rev=rev*10+rem;
            num/=10;
        }
        if(temp==rev){
            System.out.println("Palindrome");
        }else
            System.out.println("Not Palindrome");
    }
}
