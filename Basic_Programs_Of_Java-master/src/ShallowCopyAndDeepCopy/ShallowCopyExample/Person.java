package ShallowCopyAndDeepCopy.ShallowCopyExample;

public class Person implements Cloneable{
    String name;
    Address address;

    Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    // Shallow copy
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
