public class CommonPracticeDoNotCommit {
    public static void main(String[] args) {
        int n=16;
        int sum=0;
        System.out.println("output of % of n is :"+n%10);
        System.out.println("output of % of n is :"+n/10);
        while (n>0){
            sum+=n%10;
            n=n/10;
        }

    }
}
