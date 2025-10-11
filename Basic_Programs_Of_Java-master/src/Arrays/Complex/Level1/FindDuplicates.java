package Arrays.Complex.Level1;
//Find duplicate elements using O(1) extra space
import java.util.*;
public class FindDuplicates {
    public static List<Integer> duplicates(int[] a){
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<a.length;i++){
            int idx = Math.abs(a[i]) - 1;
            if(a[idx] < 0) res.add(Math.abs(a[i]));
            else a[idx] = -a[idx];
        }
        return res;
    }
}

