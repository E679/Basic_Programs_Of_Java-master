package Arrays.Complex.Level1;
//Find equilibrium index (sum of left elements = sum of right elements).
public class EquilibriumIndex {
    public static int findEquilibrium(int[] a){
        int total = 0, left = 0;
        for(int x: a) total += x;
        for(int i=0;i<a.length;i++){
            total -= a[i]; // right sum
            if(left==total) return i;
            left += a[i];
        }
        return -1;
    }
}
