package temp;


public class DivideStringIntoNEqualParts {
    public static void main(String[] args) {
        // Define a string and the number of parts to split.
        String str1 = "abcdefghijklmnopqr";
        int split_number = 6;

        // Call the method to split the string.
        splitString(str1, split_number);
        //Another Way
        System.out.println("\nAnother Way: ");
        divideString(str1, split_number);
    }

    // Method to split the string into 'n' parts.
    static void splitString(String str1, int n) {
        // Get the length of the string.
        int str_size = str1.length();
        int part_size;

        // Check if the size of the string is divisible by 'n'.
        if (str_size % n != 0) {
            // If not divisible, print a message and return.
            System.out.println("The size of the given string is not divisible by " + n);
        } else {
            // If divisible, proceed to split the string.
            System.out.println("The given string is: " + str1);
            System.out.println("The string divided into " + n + " parts and they are: ");

            // Calculate the size of each part.
            part_size = str_size / n;

            // Loop through the string characters.
            for (int i = 0; i < str_size; i++) {
                // If the current index is a multiple of 'part_size', start a new line.
                if (i % part_size == 0) {
                    System.out.println();
                }
                // Print the character at the current index.
                System.out.print(str1.charAt(i));
            }
        }
    }


    private static void divideString(String str, int n) {
        int temp = 0, chars = str.length() / n;
        String[] newStr = new String[n];
        //Check whether a string can be divided into n equal parts
        if (str.length() % n != 0) {
            System.out.println("Invalid Input");
            System.out.println("String size is not divisible by " + n);
            System.out.println("Try Again");
        } else {
            for (int i = 0; i < str.length(); i = i + chars) {
                //Dividing string in n equal part using substring()
                String part = str.substring(i, i + chars);
                newStr[temp] = part;
                temp++;
            }
            System.out.println("On dividing the entered string into " + n + " equal parts, we have ");
            for (int i = 0; i < newStr.length; i++) {
                System.out.println(newStr[i]);
            }
        }
    }
}


