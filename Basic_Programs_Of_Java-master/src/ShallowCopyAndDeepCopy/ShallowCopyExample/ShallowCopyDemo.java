package ShallowCopyAndDeepCopy.ShallowCopyExample;

public class ShallowCopyDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Address address = new Address("Mumbai");
        Person p1 = new Person("John", address);
        Person p2 = (Person) p1.clone();

        p2.name = "Doe";
        p2.address.city = "Pune";  // Changing city in cloned object

        System.out.println(p1.name + " lives in " + p1.address.city);
        System.out.println(p2.name + " lives in " + p2.address.city);
    }
}

///output:
/*
John lives in Pune
Doe lives in Pune
Why?
Because p1.address and p2.address are still the same reference!
 */
