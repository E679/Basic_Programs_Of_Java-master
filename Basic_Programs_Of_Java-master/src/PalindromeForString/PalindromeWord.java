package PalindromeForString;

public class PalindromeWord {
    public static void main(String[] args) {


        String str = "TeneT";
        String rev = "";

        int lent = str.length();

        for (int i = (lent - 1); i >= 0; --i) {
            rev = rev + str.charAt(i);
        }

        if (str.toLowerCase().equals(rev.toLowerCase())) {
            System.out.println("Palindrome");
        }else
            System.out.println("Not Palindrome");
    }
}
