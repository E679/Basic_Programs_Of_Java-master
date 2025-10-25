package DesignPatterns.ProtoType;

class Employee implements Cloneable {
    int id;
    String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Employee clone() throws CloneNotSupportedException {
        return (Employee) super.clone();
    }
}

public class PrototypeDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Employee e1 = new Employee(101, "John");
        Employee e2 = e1.clone();
        System.out.println(e2.name); // John
    }
}

