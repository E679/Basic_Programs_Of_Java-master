package Arrays.Complex.Level1;

//Find all unique elements in an array.
import java.util.*;
public class UniqueElements {
    public static Set<Integer> unique(int[] a) {
        Set<Integer> s = new HashSet<>();
        for(int x: a) s.add(x);
        return s;
    }
}

