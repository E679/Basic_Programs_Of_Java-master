package temp;

import java.util.Scanner;

public class StringEqualsMethod2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the string: ");
        String s1=sc.nextLine();
        System.out.println("Enter the string: ");
        String s2=sc.nextLine();
        //Compare two strings
        System.out.println("Are the two strings equal?" + s1.equals(s2));//true
        /////////////////////////
        String str1 = "Study tonight";
        System.out.println("The entered string is "+str1);
        String str2 = "Study tonight";
        System.out.println("The entered string is "+str2);
        System.out.println("Are the two strings equal?");
        //Compare the strings using == operator
        if(str1 == str2)
            System.out.println("Yes the entered strings are equal ");//output will be this
        else
            System.out.println("No the entered strings are not equal ");
        ///////////////////////////////////////////
        String strr1 = new String("Study Tonight");
        System.out.println("The entered string is: "+strr1);
        String strr2 = new String("Study Tonight");
        System.out.println("The entered string is: "+strr2);
        System.out.println("Are the two strings equal? with new keyword (using equals() method)"+strr1.equals(strr2));
        boolean result = strr1.equals("Study Tonight"); // true
        System.out.println(result);
        System.out.println("Are the two strings equal? (Comparing by using == )");
        result = strr2 == "Study Tonight"; // false
        System.out.println(result);
        System.out.println("Are the two strings equal? (Comparing by using == )");
        result = strr1 == strr2; // false
        System.out.println(result);
        System.out.println("Are the two strings equal? (Comparing Both Strings)");
        result = "Study Tonight" == "Study Tonight"; // true
        System.out.println(result);
    }
}
