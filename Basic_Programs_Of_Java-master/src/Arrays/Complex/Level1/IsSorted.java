package Arrays.Complex.Level1;
//Check if an array is sorted (ascending or descending)
public class IsSorted {
    public static boolean isSorted(int[] a) {
        boolean asc = true, desc = true;
        for(int i=1;i<a.length;i++){
            if(a[i]<a[i-1]) asc=false;
            if(a[i]>a[i-1]) desc=false;
        }
        return asc || desc;
    }
}

