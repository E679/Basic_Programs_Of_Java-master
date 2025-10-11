package Arrays.Complex.Level1;
//Replace every element with greatest element on its right
public class ReplaceWithGreatest {
    public static void replace(int[] a) {
        int max = -1;
        for(int i=a.length-1;i>=0;i--){
            int temp = a[i];
            a[i] = max;
            if(temp > max) max = temp;
        }
    }
}

