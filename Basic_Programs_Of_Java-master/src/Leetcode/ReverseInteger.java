package Leetcode;

/*
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

Example 1:

Plain Text
Input: x = 123
Output: 321

Example 2:

Plain Text
Input: x = -123
Output: -321

Example 3:

Plain Text
Input: x = 120
Output: 21

 */
public class ReverseInteger {
    public static int reverse(int x) {
        int rev=0;
        while(x!=0){
            int rem=x%10;
            x/=10;
            if(rev>0&&rev>(Integer.MAX_VALUE-rem)/10||rev<0&&rev<(Integer.MIN_VALUE-rem)/10) return 0;
            rev=rev*10+rem;
        }
        return rev;
    }

    public static void main(String[] args) {
        int reverse = reverse(-123);
        System.out.println(reverse);//-321
        int reverse1 = reverse(120);
        System.out.println(reverse1);//21
    }
}
