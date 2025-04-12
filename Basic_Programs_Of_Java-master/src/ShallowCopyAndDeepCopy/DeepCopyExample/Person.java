package ShallowCopyAndDeepCopy.DeepCopyExample;

public class Person implements Cloneable{
    String name;
    Address address;

    Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    // Deep copy
    public Object clone() throws CloneNotSupportedException {
        Person cloned = (Person) super.clone();
        cloned.address = (Address) address.clone(); // clone the Address too
        return cloned;
    }
}
