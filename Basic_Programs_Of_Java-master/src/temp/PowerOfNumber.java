package temp;

public class PowerOfNumber {
    public static void main(String[] args) {
        int a=2,b=3;
        int ans=1;
        for (int i=1;i<=b;i++){
            ans=ans*a;
        }
        System.out.println("Power is "+ans);
        double pow = Math.pow(a, b);
        System.out.println(pow);
    }
}
