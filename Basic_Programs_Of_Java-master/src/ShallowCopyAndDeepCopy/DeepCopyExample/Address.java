package ShallowCopyAndDeepCopy.DeepCopyExample;

public class Address implements Cloneable{
    String city;

    Address(String city) {
        this.city = city;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
