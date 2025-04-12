package MyFunctionalInterface;

import java.util.Comparator;

@FunctionalInterface
public interface MyFunctionalInterface1 {
    void singleAbstractMethod();
    default void defaultMethod() {
        System.out.println("Default method implementation");
    }

    static void main(String[] args) {
        MyFunctionalInterface1 f = ()->System.out.println("Single Abstract method");
        f.singleAbstractMethod();
        f.defaultMethod();

        // Traditional way
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        };
        int compared = comparator.compare("Jeny", "Miny");
        System.out.println("Compared "+compared);

// Using lambda expression
        Comparator<String> lambdaComparator = (s1, s2) -> s1.compareTo(s2);
        int compare = lambdaComparator.compare("Jeny", "Miny");
        System.out.println("compare: "+compare);
    }
}


