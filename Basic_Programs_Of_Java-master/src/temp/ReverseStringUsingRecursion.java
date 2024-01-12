package temp;

public class ReverseStringUsingRecursion {
    public static void main(String[] args) {
        String str="gnirtS esreveR";
        reverseString(str);
        //remove white spaces
        String str1="Count Frequency Of Characters In String";

        String res=str1.replaceAll("\\s","");
        System.out.println(res);
    }

    private static void reverseString(String str) {
        if(str==null || str.length()<=1){
            System.out.println(str);
        }else {
            System.out.print(str.charAt(str.length()-1));
             reverseString(str.substring(0,str.length()-1));
        }
    }
}
