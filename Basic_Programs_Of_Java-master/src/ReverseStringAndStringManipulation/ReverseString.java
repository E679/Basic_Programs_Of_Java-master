package ReverseStringAndStringManipulation;

public class ReverseString {
    public static void main(String[] args) {

        System.out.println("Reversing a String: ");
        String str2="Radar";
        System.out.println("Original String: "+str2);
        String rev="";
        int len2=str2.length();
        str2.toLowerCase();
        for(int i=len2-1;i>=0;--i){
            rev=rev+str2.charAt(i);
        }
        System.out.println("Reverse of String: "+rev.toLowerCase());


    }
}
