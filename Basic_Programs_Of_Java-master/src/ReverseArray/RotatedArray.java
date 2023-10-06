package ReverseArray;

/*
Rotate an array by n positions

Input:
  int [] arr={1, 2, 3, 4, 5};
  positions=2;

Output:
  Rotated Array: 4 5 1 2 3
 */
public class RotatedArray {
    public static void main(String[] args) {
        int [] arr={1, 2, 3, 4, 5};
        int positions=2;

        int[] rotatedArr=new int[arr.length];

        for (int i=0;i< arr.length;i++){
            int newPos=(i+positions) % arr.length;
            rotatedArr[newPos]=arr[i];
        }

        System.out.println("Rotated Array: ");
        for (int num:rotatedArr) {
            System.out.println(num);
        }
    }
}
