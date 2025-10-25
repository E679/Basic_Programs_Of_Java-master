package RunTimePolymorhism;

public class ParentChild {
    public static void main(String[] args) {
        //If both Parent and child have static methods then parent method will be called
        //If both Parent and child have non-static methods then child method will be called
        Parent1 b=new Child2();//Run-Time-PolyMorphism
        System.out.println("Run-Time-PolyMorphism: ");
        b.method();

        //Method Hiding
        /*
        If a subclass defines a static method with the same signature as a static method in super class
        the subclass method hides the superclass method. It is only possible to hide the method if both the
        parent and child classes have same static methods
         */
        Parent1 p =new Parent1();
        System.out.println("Method Hiding Call: ");
        p.method();
    }
}
class SuperClass {
    public static void staticMethod() {
        System.out.println("Static method in SuperClass");
    }
}

class SubClass extends SuperClass {
    public static void staticMethod() { // Hides staticMethod in SuperClass
        System.out.println("Static method in SubClass");
    }
}

class MethodHidingExample {
    public static void main(String[] args) {
        SuperClass.staticMethod(); // Calls staticMethod in SuperClass
        SubClass.staticMethod();   // Calls staticMethod in SubClass

        SuperClass obj = new SubClass();
        obj.staticMethod();        // Calls staticMethod in SuperClass (due to reference type)
    }
}
//OUTPUT:
/*
Static method in SuperClass
Static method in SubClass
Static method in SuperClass
 */