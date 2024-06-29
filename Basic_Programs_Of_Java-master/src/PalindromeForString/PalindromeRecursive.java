package PalindromeForString;

public class PalindromeRecursive {
    public static void main(String[] args) {
        System.out.println(isPalindrome("ab1221ba"));
    }

    private static boolean isPalindrome(String text){
        String tempText = palindrome(text);
        return text.equals(tempText);
    }

    private static String palindrome(String text){
        if(text == null || text.isEmpty()){
            return text;
        }
        return text.charAt(text.length()-1)+
                palindrome(text.substring(0,text.length()-1));
    }
}
