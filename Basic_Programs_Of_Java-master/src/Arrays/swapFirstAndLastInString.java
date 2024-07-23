package Arrays;

public class swapFirstAndLastInString {
    /*
Input: str = “GeeksForGeeks”
Output: seeksForGeekG
Input: str = “Java”
Output: aavJ
     */
    public static String swapFirstAndLast(String str)
    {

        // Check if the string has only
        // one character then return
        // the string
        if (str.length() < 2)
            return str;

        // Converting the string into
        // a character array
        char[] ch = str.toCharArray();

        // Swapping first and the last
        // character of a string
        char temp = ch[0];
        ch[0] = ch[ch.length - 1];
        ch[ch.length - 1] = temp;

        // Converting character to
        // string and return
        return String.valueOf(ch);
    }

    // Driver Code
    public static void main(String args[])
    {
        // Given String str
        String str = "GeeksForGeeks";

        // Function Call
        System.out.println(
                swapFirstAndLast(str));
    }
}
