package Strings;

import java.util.Scanner;

public class ReverseWordsInString {
    public static void main(String[] args) {
        /*
        2.Reverse the string word by word but each word's characters remain unchanged.

        Original String : how to do in Java
        Reversed String : Java in do to how
         */
        Scanner scanner=new Scanner(System.in);
        System.out.println("2nd Original String: ");
        String str1= scanner.nextLine();
        scanner.close();

        String[] words1 = str1.split("\\s");
        String reversedStr="";

//        for (int i=0; i< words1.length;i++){
//            if (i==words1.length-1){
//                reversedStr=words1[i]+reversedStr;
//            } else {
//                reversedStr=" "+words1[i]+reversedStr;
//            }
//        }
        for (int i=words1.length-1; i>=0 ;i--){
                reversedStr+=" "+words1[i];
        }
        System.out.println("2nd Reversed String: "+reversedStr);
    }
}
