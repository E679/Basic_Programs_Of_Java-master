package Arrays.Complex.Level1;
//Find the element that appears once when every other element appears twice (XOR logic).
public class SingleNumber {
    public static int single(int[] a){
        int xor=0;
        for(int x:a) xor ^= x;
        return xor;
    }
}

