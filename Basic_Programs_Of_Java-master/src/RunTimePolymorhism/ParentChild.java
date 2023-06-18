package RunTimePolymorhism;

public class ParentChild {
    public static void main(String[] args) {
        //If both Parent and child have static methods then parent method will be called
        //If both Parent and child have non-static methods then child method will be called
        Parent1 b=new Child2();
        b.method();
    }
}
