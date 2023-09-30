package ReverseString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReverseSentence {
    public static void main(String[] args) {
        String str = "I'm From India";

        String[] words = str.split("\\s");
        List<String> result=new ArrayList<>();
        int n=words.length;
        String[] result1 = new String[n];
        for (String res : words) {
            result.add(res);
        }
        System.out.println("Splitted words in list" + result);

        for (int i=0;i<n;i++){
            result1[i]=words[i];
        }
        System.out.println("Splitted words in String Array " + Arrays.toString(result1));
        getSentenceInReverseFromString(str);
        getReversedWordsInString();
    }

    private static void getReversedWordsInString() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter a String to reverse:\n");
        String str=scanner.nextLine();
        String[] words=str.split("\\s");
        String reversedStr="";

        //Reverse each words position
//        for (int i=0;i<words.length;i++){
//            if (i== words.length-1)
//                reversedStr=words[i]+reversedStr;
//            else
//                reversedStr=" " + words[i]+reversedStr;
//        }
        for (int i=words.length-1;i>=0;i--){
            reversedStr+=" "+words[i];
        }

        System.out.println("Reversed string only with words is: "+reversedStr);
    }

    private static void getSentenceInReverseFromString(String str) {
        String[] sentenceResult = str.split("\\s");
        System.out.println("Splitted words in method "+Arrays.toString(sentenceResult)+ "\nNow reversing the sentence");
        String reverseString = "";
        for (int i=0;i<sentenceResult.length;i++){
            String word=sentenceResult[i];
            String reverseWord = "";
            for(int j=word.length()-1;j>=0;j--){
                reverseWord+=word.charAt(j);
            }
            reverseString+=reverseWord+" ";
        }
        System.out.println("Reversed words in method "+reverseString);
    }
}
