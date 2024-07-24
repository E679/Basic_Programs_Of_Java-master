package GuessOutput;

class A {
    void m1(){
        System.out.println("In m1 A");
    }

    void method1() throws ArrayIndexOutOfBoundsException{
        System.out.println("In m1 A");
    }
}

class B extends A {
    void m1() {
        System.out.println("In m1 B");
    }
    void m2() {
        System.out.println("In m2 B");
    }
    void method1() throws IndexOutOfBoundsException{
        System.out.println("In m1 A");
    }
}

class Test {
    public static void main(String[] args) {
        A a = new B();
        a.m1();// Ouput : In m1 B
        //a.m2();// Compilation Error
        a.method1();// Output: In m1 A
    }
}
