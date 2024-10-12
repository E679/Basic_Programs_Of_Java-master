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
        //If String contains special characters do not consider them
        /*
        Input: "fun&!! time"
        Output: time
         */
        String s="fun&!! time";
        String[] split=s.replaceAll("[^a-zA-Z0-9 ]", "").split("\\s");
        Arrays.sort(split,((o1, o2) -> o2.length()-o1.length()));
        System.out.println("Longest word which doesnot have special chars is: "+split[0]);
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
