package Arrays.Complex.Level1;
//Count frequency of each element without using extra space

public class FrequencyCount {
    public static void countFrequency(int[] a) {
        int n = a.length;
        for(int i=0;i<n;i++){
            int index = a[i]%n;
            a[index] += n;
        }
        for(int i=0;i<n;i++){
            System.out.println(i + " -> " + a[i]/n);
        }
    }
}

