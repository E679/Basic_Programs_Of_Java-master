package Pattern;

public class Patternstar {
    public static void main(String args[]) {
        //System.out.println("Hello, World!");

        System.out.println("Left Triangle !");
        for(int i=1;i<=5;i++){
            for(int j=1;j<=5-i+1;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println("Right Triangle !");
        for(int i=1;i<=5;i++){
            for(int j=1;j<=i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println("Left Triangle number !");
        for(int i=1;i<=5;i++){
            for(int j=1;j<=5-i+1;j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
        System.out.println("Right Triangle number!");
        for(int i=1;i<=5;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }


    }
}
