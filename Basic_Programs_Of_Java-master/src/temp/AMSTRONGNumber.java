package temp;

public class AMSTRONGNumber {
    public static void main(String[] args) {
        /*
        Amstrong Number = sum of cubes of each digit of a number
        1^3 + 5^3 + 3^3 = 153
         */
        int n=153;
        int temp=n;
        int amstrongNumber=0;
        int numberLength = String.valueOf(n).length();
        while (temp>0) {
            int rem= temp%10;
            amstrongNumber+=Math.pow(rem,numberLength);
            temp=temp/10;
        }
        if(n==amstrongNumber){
            System.out.println(n+" is an Amstrong Number");
        } else {
            System.out.println(n+" is Not an Amstrong Number");
        }
    }
}
