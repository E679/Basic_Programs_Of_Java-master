package Arrays.Complex.Level1;
//Find the number of occurrences of a given element using binary search.
public class CountOccurrences {
    public static int count(int[] a, int x){
        int first = first(a,x);
        int last = last(a,x);
        return (first==-1)?0:(last-first+1);
    }
    private static int first(int[] a,int x){
        int l=0,r=a.length-1,res=-1;
        while(l<=r){
            int m=(l+r)/2;
            if(a[m]==x){ res=m; r=m-1; }
            else if(a[m]<x) l=m+1;
            else r=m-1;
        }
        return res;
    }
    private static int last(int[] a,int x){
        int l=0,r=a.length-1,res=-1;
        while(l<=r){
            int m=(l+r)/2;
            if(a[m]==x){ res=m; l=m+1; }
            else if(a[m]<x) l=m+1;
            else r=m-1;
        }
        return res;
    }
}
