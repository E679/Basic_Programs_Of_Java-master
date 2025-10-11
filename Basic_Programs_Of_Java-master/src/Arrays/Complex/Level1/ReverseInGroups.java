package Arrays.Complex.Level1;
//Reverse array in groups of K.
public class ReverseInGroups {
    public static void reverseInGroups(int[] a,int k){
        for(int i=0;i<a.length;i+=k){
            int l=i, r=Math.min(i+k-1,a.length-1);
            while(l<r){
                int t=a[l]; a[l]=a[r]; a[r]=t; l++; r--;
            }
        }
    }
}

