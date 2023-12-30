package ReverseStringAndStringManipulation;

import java.util.Arrays;

public class FindLongestStringByLength {
    public static void main(String[] args) {
        String [] words={"java","Hibernate","springboot","microservices"};
        String ser="";
        for (int i=0;i< words.length;i++){
            if(words[i].length()>ser.length()){
                ser=words[i];
            }
        }
        System.out.println("1St approach : "+ser+" and length is:"+ser.length());
        System.out.println("Using method "+getLongestString(words));
        String res="";
        res= Arrays.stream(words).reduce((word1, word2)->word1.length()>word2.length()?word1:word2).get();
        System.out.println("Using stream: "+res);
    }
    private static String getLongestString(String[] words) {
        String largestWord="";
        String currentWord="";
        for (int i=0;i< words.length;i++){
            currentWord=words[i];
            if (currentWord.length()>largestWord.length()){
                largestWord=currentWord;
            }
        }
        return largestWord;
    }
}
