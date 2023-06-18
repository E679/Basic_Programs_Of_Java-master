package Anagram;

import java.util.Arrays;
public class AnagramString {
    public static void main(String[] args) {
        String str="Race";
        String str2="Care";

        str=str.toLowerCase();
        str2=str2.toLowerCase();
        if(str.length()==str2.length()){
            char[] chararr=str.toCharArray();
            char[] chararr2=str2.toCharArray();

            Arrays.sort(chararr);
            Arrays.sort(chararr2);
            boolean res=Arrays.equals(chararr,chararr2);
            if(res){
                System.out.println("anagram");
            }else {
                System.out.println("not anagram");
            }
        }else{
            System.out.println("Not anagram");
        }
    }
}
