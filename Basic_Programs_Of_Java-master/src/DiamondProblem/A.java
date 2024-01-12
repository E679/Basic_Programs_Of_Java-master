//package DiamondProblem;
//
//class A
//{
//    public void display()
//    {
//        System.out.println("class A display() method called");
//    }
//}
//class B extends A
//{
//    @Override
//    public void display()
//    {
//        System.out.println("class B display() method called");
//    }
//}
//class C extends A
//{
//    @Override
//    public void display()
//    {
//        System.out.println("class C display() method called");
//    }
//}
////not supported in Java
//public class D extends B,C
//{
//    public static void main(String args[])
//    {
//        D d = new D();
////creates ambiguity which display() method to call
//        d.display();
//    }
//}