package temp;

public class Print1to100withoutloop {
    public static void main(String[] args) {
        int n=1;
        getnumsfrom1to100withoutanyloop(n);
    }
    private static void getnumsfrom1to100withoutanyloop(int n){
        if(n<=100){
            System.out.println(n);
            getnumsfrom1to100withoutanyloop(n+1);
        }
    }
}
