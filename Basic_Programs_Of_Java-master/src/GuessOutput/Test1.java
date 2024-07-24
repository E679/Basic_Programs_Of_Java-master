package GuessOutput;

public class Test1 {
    protected int x,y;
}
class Main{
    public static void main(String[] args) {
        Test1 t=new Test1();
        System.out.println(t.x+" "+t.y);//Output : 0 0
        //System.out.println(fun(20));// Compilation error bcoz func() is not static
    }

    int fun(int i) {
        return 20;
    }
}
