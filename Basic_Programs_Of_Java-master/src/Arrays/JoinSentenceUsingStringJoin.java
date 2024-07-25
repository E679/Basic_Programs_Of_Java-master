package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class JoinSentenceUsingStringJoin {
    public static void main(String[] args) {
        String s="Move all zeros to start and ones to end in an Array";
        //Join Words
        String[] words = s.split(" ");
        String joinedSentence = String.join("-", words);
        System.out.println(joinedSentence);

        //String joining
        StringJoiner stringJoiner=new StringJoiner(",","[","]");


        //Join Each Letter
        String[] words1 = s.split("");
        String joinedSentence1 = String.join("-", words1);
        System.out.println(joinedSentence1);

        //Split string by camelCase
        String stringSentence="moveAllZerosToStart";
        String[] wordsWithCamelCase = splitStringByCamelCase(stringSentence);
        String joinedSentenceCamelCase = String.join("_", wordsWithCamelCase).toUpperCase();
        System.out.println(joinedSentenceCamelCase);

        //Make Each word First letter to uppercase in a sentence
        String stringCap="Move all zeros to start and ones to end in an Array";
        String[] splittedWords = stringCap.split(" ");

        List<String> splittedWordsRes = new ArrayList<>();

        for (String word:splittedWords) {
            char[] charArray = word.toCharArray();
            char upperCase = Character.toUpperCase(charArray[0]);
            String replacedWord = word.replace(charArray[0], upperCase);
            splittedWordsRes.add(replacedWord);
        }
        String joinedString = String.join("_", splittedWordsRes);
        System.out.println(joinedString);

        List<String> wordsList = Arrays.asList("Java", "is", "powerful");
        String sentenceList = String.join(" ", wordsList);
        System.out.println(sentenceList);
        // Output:
        // 'Java is powerful'

        String string1 = "Hello";
        String string2 = "World";
        String result4 = String.join("-", string1, string2);
        System.out.println(result4);

// Output:
// 'Hello-World'

        String result = String.format("%s-%s", "Hello", "World");
        System.out.println(result);
        // Output:
        // 'Hello-World'

        String str1 = null;
        String str2 = "World";

// Check for null values
        //if one of the strings is null then String.join will throw null pointer exception
        if (str1 != null && str2 != null) {
            String result1 = String.join("-", str1, str2);
            System.out.println(result1);
        } else {
            System.out.println("One or more values are null");
        }

    }

    private static String[] splitStringByCamelCase(String s) {
        return s != null ? s.split("(?=[A-z])") : null;
    }
/*
Complete outputs:

Move-all-zeros-to-start-and-ones-to-end-in-an-Array
M-o-v-e- -a-l-l- -z-e-r-o-s- -t-o- -s-t-a-r-t- -a-n-d- -o-n-e-s- -t-o- -e-n-d- -i-n- -a-n- -A-r-r-a-y
M_O_V_E_A_L_L_Z_E_R_O_S_T_O_S_T_A_R_T
Move_All_Zeros_To_Start_And_Ones_To_End_In_An_Array
Java is powerful
Hello-World
Hello-World
One or more values are null
 */

}
