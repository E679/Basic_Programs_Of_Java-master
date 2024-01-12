package temp;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

class removeOccurence {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter a string as an input");
        String input = scanner.nextLine();
        System.out.println("Enter a letter to be removes from the string");
        Character character = scanner.next().charAt(0);

        System.out.println("Our resultant string is: "+removeOccurences(input,character));
        Predicate<String> ab=a->validateString(a);
    }

    private static boolean validateString(String a) {
        return a.isEmpty();
    }

    private static String removeOccurences(String input, Character character) {
        ArrayList<Character> al=new ArrayList<>();
        for(int i=0;i<input.length();i++)
        {
            char ch = input.charAt(i);
            if(ch != character)
            {
                al.add(ch);
            }
        }
        StringBuilder stringBuilder=new StringBuilder();
        for(char c:al)
        {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}