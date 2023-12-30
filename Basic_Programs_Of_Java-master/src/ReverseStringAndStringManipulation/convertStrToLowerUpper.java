package ReverseStringAndStringManipulation;

//Convert first half of the string in lower case and second half in upper case
public class convertStrToLowerUpper {
    public static void main(String[] args) {
        String str="This is Java Program This is Java Program";
        int len=str.length()/2;
        String lowerCase="";
        String upperCase="";
        String result=convertFirstHalfStringToUpperAndSecondHalfToLower(str,lowerCase,upperCase,len);
        System.out.println(result);
    }
    private static String convertFirstHalfStringToUpperAndSecondHalfToLower(String str, String lowerCase, String upperCase, int len) {
        if(len==0){
            return "";
        }
        System.out.println("Half length of String is: "+len);
        for (int i=0;i<str.length();i++){
            if(i<len){
                lowerCase+=Character.toLowerCase(str.charAt(i));
            }else {
                upperCase += Character.toUpperCase(str.charAt(i));
            }
        }
        return (lowerCase + upperCase);
    }
}
