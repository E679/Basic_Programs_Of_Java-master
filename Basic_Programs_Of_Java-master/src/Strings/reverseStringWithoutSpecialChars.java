package Strings;

public class reverseStringWithoutSpecialChars {
    public static void main(String[] args) {
        String str = "a,b$c";
        System.out.println("Reversed String: " + reverseStringWithoutSpecialChars(str));
    }

    public static String reverseStringWithoutSpecialChars(String str) {
        char[] arr = str.toCharArray();
        int left = 0, right = arr.length - 1;

        while (left < right) {
            if (!Character.isAlphabetic(arr[left])) {
                left++;
            } else if (!Character.isAlphabetic(arr[right])) {
                right--;
            } else {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        return new String(arr);
    }
}
