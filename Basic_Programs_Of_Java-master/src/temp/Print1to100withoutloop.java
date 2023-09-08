package temp;

public class Print1to100withoutloop {
    public static void main(String[] args) {
        int n=1;
        getnumsfrom1to100withoutanyloop(n);
        String s=1+2+"abc"+1+2+"def";
        System.out.println("string value"+s);// output: 3abc12def// if string starts with integers it starts adding and once it encounters with character it starts concatenating till end
    }
    private static void getnumsfrom1to100withoutanyloop(int n){
        if(n<=100){
            System.out.println(n);
            getnumsfrom1to100withoutanyloop(n+1);
        }
    }
}
