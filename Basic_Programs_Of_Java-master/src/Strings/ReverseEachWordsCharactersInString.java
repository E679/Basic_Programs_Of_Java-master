package Strings;

import java.util.Scanner;

public class ReverseEachWordsCharactersInString {
    public static void main(String[] args) {
        /*
        1.Reverse each word's character's but the position of the word in string remain unchanged.

        Original String : how to do in Java
        Reversed String : woh ot od ni avaJ
         */

        Scanner scanner=new Scanner(System.in);
        System.out.println("Original String: ");
        String str=scanner.nextLine();
        scanner.close();

        String[] words = str.split("\\s");
        String reversedStr="";

        for (int i=0; i<words.length;i++){
            String word = words[i];
            String revWord="";
            for (int j=word.length()-1;j>=0;j--){
                revWord+=word.charAt(j);
            }
            reversedStr+=revWord+" ";
        }

        System.out.println("Reversed String: "+reversedStr);
    }
}
