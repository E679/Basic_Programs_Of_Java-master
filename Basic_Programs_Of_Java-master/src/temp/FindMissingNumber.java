package temp;

public class FindMissingNumber {
    /*
    Input:
      int[] arr={1, 2, 4, 6, 3, 7, 8};

    Output:
      Missing number: 5
     */
    public static void main(String[] args) {
        int[] arr={1, 2, 4, 6, 3, 7, 8};
        int n=arr.length+1;
        int formulaSum=(n*(n+1))/2;
        int actualSum=0;

        for (int i=0;i< arr.length;i++){
            actualSum+=arr[i];
        }
        int result=formulaSum-actualSum;
        System.out.println("Missing Number: "+result);

    }
}
