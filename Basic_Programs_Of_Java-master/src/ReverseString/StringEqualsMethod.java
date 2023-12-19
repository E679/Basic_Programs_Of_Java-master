package ReverseString;

public class StringEqualsMethod {
    public static void main(String[] args) {
        
        String s1 = new String("QuickRef");
        String s2 = new String("QuickRef");

        System.out.println("s1==s2 value is: "+(s1==s2));          // false
        System.out.println("s1.equals(s2) value: "+s1.equals(s2));     // true
        String s3="QuickRef";
        String s4="quickRef";
        String s5="QuickRef";
        System.out.println("s1==s3 value is: "+(s1==s3));   //false
        System.out.println("s1.equals(s3) value is: "+(s1.equals(s3))); //true
        System.out.println("s1.equals(s4) value is: "+(s1.equals(s4))); //false
        System.out.println("s3==s5 value is: "+(s3==s5));   //true
    }
}
