package temp;

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

        String str = "abcd";

        System.out.println(str.charAt(2));       // c
        System.out.println(str.indexOf("a"));    // 0
        System.out.println(str.indexOf("z"));    // -1
        System.out.println(str.length());        // 4
        System.out.println(str.toString());      // abcd
        System.out.println("Substring with one begin index "+str.substring(2));    // cd
        System.out.println("Substring with two indices begin and end "+str.substring(2,3));  // c
        System.out.println(str.contains("c"));   // true
        System.out.println(str.endsWith("d"));   // true
        System.out.println(str.startsWith("a")); // true
        System.out.println(str.isEmpty());       // false
    }
}
