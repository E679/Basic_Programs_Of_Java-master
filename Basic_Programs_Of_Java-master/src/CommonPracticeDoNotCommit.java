import java.util.Arrays;
import java.util.StringJoiner;

public class CommonPracticeDoNotCommit {
    public static void main(String[] args) {
        String s1=String.join("-","Supreeth","abcd");
        System.out.println(s1);
        String s2="Supreeth";
        String[] s3=s2.split("u");

        System.out.println(Arrays.toString(s3));

    }
    CommonPracticeDoNotCommit getme(){
        return new CommonPracticeDoNotCommit();
    }
}
