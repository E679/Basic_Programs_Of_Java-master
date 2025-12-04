package Strings;

public class StringRotations {
    // Method 1: Concatenation approach
    public static boolean areRotations(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        String concatenated = str1 + str1;
        return concatenated.contains(str2);
    }

    // Method 2: Character by character comparison
    public static boolean areRotations2(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        for (int i = 0; i < str1.length(); i++) {
            String rotated = str1.substring(i) + str1.substring(0, i);
            if (rotated.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String str1 = "ABCD";
        String str2 = "CDAB";

        System.out.println(areRotations(str1, str2));  // true
        System.out.println(areRotations2(str1, str2)); // true

        String str3 = "ABCD";
        String str4 = "ACBD";
        System.out.println(areRotations(str3, str4));  // false
    }
}
