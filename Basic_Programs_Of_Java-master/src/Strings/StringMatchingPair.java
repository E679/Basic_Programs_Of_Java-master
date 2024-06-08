package Strings;

import java.util.Stack;
//optional for preparation
public class StringMatchingPair {
    public static void main(String[] args) {
        checkBalance("abcsdfab");
    }

    public static String checkBalance(String s) {

        char charArray[] = s.toCharArray();

        Stack<Character> stack = new Stack<>();

        for (char c : charArray) {

            if (c == '(' || c == '[' || c == '{') {

                stack.push(c);
            } else {
                if (stack.isEmpty() || isMatchingPair(stack.pop(), c)) {
                    return "NO";

                }
            }
        }
        return stack.isEmpty() ? "YES" : "NO";
    }
    static boolean isMatchingPair(char open, char close) {

        return (open == '(' && close == ')') ||
                (open == '[' && close == ']') ||
                (open == '{' && close == '}');
    }
}
