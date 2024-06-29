package PalindromeForString;

public class PalindromeRecursive {
    public static void main(String[] args) {
        boolean givenString = isPalindrome("ab1221ba");
        boolean withoutRecursive = testPalindromeWithNonRecursive("ab1221ba");
        System.out.println("Given String Is a Palindrome with Recursive method");
        System.out.println("Given String Is a Palindrome without Recursive method");
    }

    private static boolean isPalindrome(String text){
        String tempText = palindrome(text);
        return text.equals(tempText);
    }

    private static String palindrome(String text){
        if(text == null || text.isEmpty()){
            return text;
        }
        String result= text.charAt(text.length() - 1) + palindrome(text.substring(0, text.length() - 1));
        return result;
    }
    private static boolean testPalindromeWithNonRecursive(String text){
        if(text == null || text.isEmpty()){
            return false;
        }
        String result="";
        for(int i=text.length()-1;i>=0;i--){
            result+=text.charAt(i);
        }
        if(result.equals(text)){
            return true;
        }
        return false;
    }
}
