package temp;

public class OperatorTest {
    public static void main(String[] args) {
        int x=5;
        int y=x++;
        int z=++x;
        System.out.println("X= "+x);
        System.out.println("Y= "+y);
        System.out.println("Z= "+z);
        /*
        Output:
        X=7 ,Y=5 ,Z=7
         */

    }
}
