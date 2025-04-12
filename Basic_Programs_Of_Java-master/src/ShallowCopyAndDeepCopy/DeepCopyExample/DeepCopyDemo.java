package ShallowCopyAndDeepCopy.DeepCopyExample;

public class DeepCopyDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Address address = new Address("Mumbai");
        Person p1 = new Person("John", address);
        Person p2 = (Person) p1.clone();

        p2.name = "Doe";
        p2.address.city = "Pune"; // Changing city in cloned object

        System.out.println(p1.name + " lives in " + p1.address.city);
        System.out.println(p2.name + " lives in " + p2.address.city);
    }
}
/// Output:
/*
John lives in Mumbai
Doe lives in Pune
Why?
Because p1.address and p2.address are now different objects!

Summary in One Line:
Shallow Copy → Copies the object, not the objects inside it (shared references).

Deep Copy → Copies the object and all objects inside it (new independent copies).

Interview Tip:
If asked:

What is the difference between shallow and deep copy?

You can answer:

In shallow copy, fields that are objects are copied as references. In deep copy, fields are copied as completely new objects so the original and copy are fully independent.
 */
