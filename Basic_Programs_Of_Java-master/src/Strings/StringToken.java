package Strings;


import java.util.Arrays;

public class StringToken {
    public static void main(String[] args) {
        String s="He is a very very good boy, isn't he";
        String[] tokens = s.split("[^A-Za-z]+"); // Split by non-alphabetic characters

        // Filter out empty tokens and count valid tokens
        int tokenCount = 0;
        for (String token : tokens) {
            if (!token.isEmpty()) {
                tokenCount++;
            }
        }

        // Print the number of tokens
        System.out.println(tokenCount);

        // Print each token on a new line
        for (String token : tokens) {
            if (!token.isEmpty()) {
                System.out.println(token);
            }
        }
    }
}
